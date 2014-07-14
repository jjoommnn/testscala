package jjoommnn.scala.test

object HelloApp extends App {
    println( "Hello App" );
    
    def foo(x:Int):Int = {
        var x = 10;
        x + 1;
    }
    
    val f = (x:Int) => {
        println( x );
        val y = x + 1;
        println( y );
        Unit;
    };
    
    def fff( x:AnyRef=>Unit ) = {
        x( "fff function" );
    }
    
    def fff1( x:(AnyRef)=>Unit ) = {
        x( new java.lang.Integer( 10 ) );
    }
    
    def fff2( x:(AnyRef,AnyRef)=>Unit, y:Int ) = {
        x( "fff function", "111" );
    }
    
    def fff3( x:()=>Unit ) = {
        
    }
    
    fff( println );
}
