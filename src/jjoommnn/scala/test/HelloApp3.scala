package jjoommnn.scala.test

object HelloApp3 extends App
{
    val b = new Bar;
    
    val bf = b.bar _;
    
    val p = println (_:AnyRef);
    
    p( "abcd" );
    
    bf();
    
    b.x = 20;
    
    bf();
}

class Bar
{
    var x = 10;
    def bar():Unit = println( "foo" + this.x )
}
