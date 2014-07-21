package jjoommnn.scala.test

object HelloApp5 extends App
{
    val f:()=>String = () => "123"
        
    var ff: Int => Unit = null;
    
    ff = (i:Int) => Unit;
    
    def foo = {
        def foo2 = {
            
        }
    }
    
    def aaa( f: =>String ) = f;
    
    def bbb( f:()=>String ) = f;
    
    aaa { "aaa" }
    
    bbb( () => "bbb" );
}
