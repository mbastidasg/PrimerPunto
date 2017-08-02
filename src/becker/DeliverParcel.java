package becker;

import becker.robots.*;

public class DeliverParcel
{
    
    public static void girarDerecha (Robot karel){
        for (int i =0; i< 3 ; i++) {
            karel.turnLeft ();
        }
    }
     
    
        public static void mover (Robot karel){
        for (int i = 0; i < 3 ; i++) {
            karel.move ();
        }
    }

   public static void main(String[] args)
   {  
     // Set up the initial situation
      City prague = new City();
       Robot karel = new Robot(prague, 0, 2, Direction.WEST);
      Wall p1 =
              new Wall (prague, 1, 2, Direction.NORTH );
    
      
      Wall p2 =
              new Wall (prague, 1, 1, Direction.NORTH);
      
      Wall p3 =
              new Wall (prague, 1, 1, Direction.WEST);
      
      Wall p4 = 
              new Wall (prague, 2, 1, Direction.WEST);
      
    Wall p5 = 
              new Wall (prague, 2, 1, Direction.SOUTH);
    
    Wall p6 = 
              new Wall (prague, 2, 2, Direction.SOUTH);
    
    Wall p7 = 
              new Wall (prague, 2, 2, Direction.EAST);
    
    Wall p8 = 
              new Wall (prague, 1, 2, Direction.EAST);
    // Direct the robot to the final situation
   
      karel.turnLeft();
      karel.turnLeft();
      karel.move ();
      girarDerecha (karel);
      mover (karel);
      girarDerecha (karel );
      mover (karel );
      girarDerecha (karel);
      mover (karel);
      girarDerecha (karel);
      mover (karel);
     
      	// start turning right as three turn lefts
      	// finished turning right

     // karel.putThing();
     
      System.out.println(karel.countThingsInBackpack());
   }
}
