package jjoommnn.scala.test

object HelloApp7 extends App
{
    def foo( x:Int ) : String = x match {
        case 1 => "1"
        case _ => "Unknown"
    }
    
    val foo2: Int => String = {
        x => "" + x
        //_ => "aaa"
        // "" + _
    }
    
    val foo3: Int => String = {
        case 1 => "1"
        case _ => "else"
    }
}
