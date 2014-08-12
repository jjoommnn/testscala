package jjoommnn.scala.test

object HelloApp9 extends App
{
    def foo():Int=>Unit = {
        val aa = 10;
        
        def bar( bb:Int ) = {
            println( bb )
            println( aa )
        }
        
        bar
    }
    
    val b = foo();
    b(11);
}