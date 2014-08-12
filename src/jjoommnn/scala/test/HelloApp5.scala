package jjoommnn.scala.test

object HelloApp5 extends App
{
    val f:()=>String = () => "123"
        
    var ff: Int => Unit = null;
    
    ff = (i:Int) => Unit;
    
    def foo():()=>String = {
        val aa = 10;
        def innerFoo():String = {
            println( aa );
            this.f();//"inner"
        }
        innerFoo
    }
    
    val fp = foo();
    println( fp() );
    
    def aaa( f: =>String ) = f;
    
    def bbb( f:()=>String ) = f;
    
    aaa { "aaa" }
    
    bbb { () => "bbb" };
    
    //bbb { "bbb" }; //error
    
    
    val aaa2 = aaa _;
    
    val bbb2 = bbb _;
    
    aaa2( { "aaa2" } )
    
    bbb2 { () => "bbb2" }
    
    
    
    def ccc( a:Int )( b: => String ) = a + b
    
    def ddd( a:Int, b: => String ) = a + b
    
    ccc( 10 ) { "ccc" }
    
    ddd( 10, { "ddd" } )
}
