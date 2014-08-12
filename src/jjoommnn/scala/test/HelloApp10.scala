package jjoommnn.scala.test

object HelloApp10 extends App
{
    val f : ()=>Int=>String = () => {
        var aa = 10;
        (a:Int) => { aa = 11; "" + a + aa; } 
    }
    
    val b = f();
    
    b( 20 );
}
