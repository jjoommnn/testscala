package jjoommnn.scala.network

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import scala.actors.Actor
import java.util.concurrent.ConcurrentHashMap
import io.netty.channel.Channel

object Main extends App
{
    implicit def function2ChannelInitializer( f:(SocketChannel) => AnyRef ) =
        new ChannelInitializer[SocketChannel] {
            override def initChannel(ch: SocketChannel):Unit = f(ch)
        }
    
    case class Message( ctx:ChannelHandlerContext, msg:Object )
    
    val bossGroup = new NioEventLoopGroup();
    val workerGroup = new NioEventLoopGroup();
    
    try
    {
        val b = new ServerBootstrap();
        b.group( bossGroup, workerGroup );
        b.channel( classOf[NioServerSocketChannel] );
        b.option[java.lang.Integer]( ChannelOption.SO_BACKLOG, 128 );
        b.childOption[java.lang.Boolean]( ChannelOption.SO_KEEPALIVE, true );
        b.childHandler( (ch:SocketChannel) =>
        {
            println( "New Client : " + ch );
            
            val ca = new ChannelInboundHandlerAdapter with Actor
            {
                override def channelRead( ctx:ChannelHandlerContext, msg:Object ):Unit =
                {
                    this ! Message( ctx, msg )
                }
                
                override def channelInactive( ctx:ChannelHandlerContext ):Unit =
                {
                    this ! Message( ctx, "_disconnected_" )
                }
        
                def act =
                {
                    loop
                    {
                        react
                        {
                            case Message( ctx, "_disconnected_" ) =>
                                println( "Client Disconnected : " + ctx.channel() )
                                this.exit();
                                
                            case Message( ctx, msg ) =>
                                println( "Client : " + ctx.channel() + " sent : " + msg )
                                ctx.write( msg )
                                ctx.flush()
                        }
                    }
                }
            }
            ca.start()
            
            ch.pipeline().addLast( ca )
        });
        
        val f:ChannelFuture = b.bind( 9999 ).sync();
        
        println( "Listening..." );
        
        f.channel().closeFuture().sync();
    }
    finally
    {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}
