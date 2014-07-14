package jjoommnn.scala.test

import scala.actors.Actor._
import scala.actors.Actor

object HelloApp2 extends App {
    
    def foo(i:Int):Int = { println( i ); i }
    
    def f(x:Function1[Int,Int] ) = x(10)
    
    f( foo );
    
    val a = new MyActor;
    a.start;
    
    a ! "111";
    a ! "222";
    a ! "333";
    
    val b = () => loop {
        react
        {
            case _ => println()
        }
    }
}
