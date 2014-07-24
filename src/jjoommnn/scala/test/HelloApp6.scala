package jjoommnn.scala.test

object HelloApp6 extends App
{
    val list = List( 1, 2, 3, 4, 5 )
    
    val r = for( i <- list ) yield { println( i ); i + 1 }
    
    println( r );
}
