package jjoommnn.scala.test

import scala.actors.Actor

class MyActor extends Actor
{
    def act =
    {
        println( "start act" );
        
        loop
        {
            react
            {
                case "111" => println( "111" )
                case "222" => println( "222" )
                case _ => println( "default" )
            }
        }
    }
}
