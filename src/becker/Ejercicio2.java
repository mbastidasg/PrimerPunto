/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

import becker.robots.*;

public class Ejercicio2 {

    
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
       Robot karel = new Robot(prague, 1, 2, Direction.SOUTH, 1);
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
            new Wall (prague, 1, 2, Direction.SOUTH );
    
    Wall p7 = 
              new Wall (prague, 1, 2, Direction.EAST);
    
    Thing c1 = new Thing (prague, 2, 2);
    // Direct the robot to the final situation
   girarDerecha (karel);
      karel.move ();
    
      karel.turnLeft();
      karel.move();
      karel.turnLeft();
      karel.move ();
      karel.pickThing();
      karel.turnLeft();
      karel.turnLeft();
      karel.move();
      
     
      	// start turning right as three turn lefts
      	// finished turning right

     // karel.putThing();
     
      System.out.println(karel.countThingsInBackpack());
   }
}



