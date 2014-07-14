package jjoommnn.scala.test

object HelloApp4 extends App
{
    var xx = 10;
    
    class MyFoo
    {
        val x = xx;
        
        def print = println( this.x )
    }
    
    xx = 11;
    
    val f = new MyFoo;
    
    f.print;
}
