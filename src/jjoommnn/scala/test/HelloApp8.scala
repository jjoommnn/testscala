package jjoommnn.scala.test

object HelloApp8 extends App
{
    var f:PartialFunction[Int,String] = { case 1 => "1" }
    
    println( f( 1 ) )
    println( f.isDefinedAt( 2 ) )
    println( f( 2 ) )
}
