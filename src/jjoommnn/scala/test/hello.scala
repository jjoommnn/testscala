package jjoommnn.scala.test

object hello {

    def main( args : Array[String] ) : Unit = {
        
        println( "Hello Scala" );
        
        var nums = List( "123", "456", "789" );
        
        nums = nums ::: List( "000" );
        
        nums.foreach( s => println( "Num " + s ) );
        
        var c = new MyClass;
        
        println( c );
    }
}

object MyObj {
    
}

class MyClass {
    val x:Int = 10;
}

trait Foo {
    def foo():Unit;
    def foo2():String = "123"
    def foo3 = "123"
}
