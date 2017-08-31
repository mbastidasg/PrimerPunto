/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;
import java.util.*;

import becker.robots.*;

public class Laboratorio1
{
   public static void main(String[] args)
   {  
       Scanner g = new Scanner(System.in);
       
     // Set up the initial situation
      City parque = new City();
      Thing espacio = new Thing(parque, 1, 2);
      Robot karel = new Robot(parque, 6, 7, Direction.NORTH,5);
     
      // estacionamiento
     /* for (int iw = 0; iw++ < 9; iw ++){
      Wall pe =
               new Wall (parque, iw, 2, Direction.WEST ) ;
      Wall pe1 =
               new Wall (parque, iw, 2, Direction.NORTH) ;
      Wall pe2 =
               new Wall (parque, iw, 2, Direction.SOUTH ) ;
      }*/
      
      // parqueadero1
       for (int i = 0; i < 5; i++){               
    Wall p1 =
               new Wall (parque, i, 1, Direction.WEST ) ;
    Wall p2 =
               new Wall (parque, i, 1, Direction.EAST ) ;
       }
      Wall p0 =
               new Wall (parque, 0, 1, Direction.NORTH ) ;
       /*for (int j = 1; j < 4; j++){               
    Wall p2 =
               new Wall (parque, 0, j, Direction.NORTH ) ;
       }/*
       
       */
       
       // parqueadero2
         for (int ie = 0; ie < 5; ie++){               
    Wall p4 =
               new Wall (parque, ie, 3, Direction.WEST ) ;
    Wall p6 =
               new Wall (parque, ie,3, Direction.EAST ) ;
       }
      Wall p5 =
               new Wall (parque, 0, 3, Direction.NORTH ) ;
       /*for (int je = 5; je < 8; je++){               
    Wall p5 =
               new Wall (parque, 0, je, Direction.NORTH ) ;
       }
              
       for (int iw = 0; iw++ < 9; iw ++){
      Wall pe =
               new Wall (parque, iw, 6, Direction.WEST ) ;
      Wall pe1 =
               new Wall (parque, iw, 6, Direction.NORTH) ;
      Wall pe2 =
               new Wall (parque, iw, 6, Direction.SOUTH ) ;
      }*/
       
       
        // parqueadero3
        for (int iq = 0; iq < 5; iq++){               
    Wall p1 =
               new Wall (parque, iq, 5, Direction.WEST ) ;
    Wall p3 =
               new Wall (parque, iq, 5, Direction.EAST ) ;
       }
      
      Wall p02 =
               new Wall (parque, 0, 5, Direction.NORTH ) ;
       
             
       
       /*for (int iw = 0; iw++ < 9; iw ++){
      Wall pe6 =
               new Wall (parque, iw, 10, Direction.EAST ) ;
      Wall pe7 =
               new Wall (parque, iw, 10, Direction.NORTH) ;
      Wall pe8 =
               new Wall (parque, iw, 10, Direction.SOUTH ) ;
      }*/       
       
       // zona temporal
       
       for (int ig = 7; ig < 11; ig++){               
    Wall pw =
               new Wall (parque, 5, ig, Direction.NORTH ) ;
    Wall pw1 =
               new Wall (parque, 5, ig, Direction.SOUTH ) ;
       }
      
                  
    Wall peh =
               new Wall (parque, 5, 10, Direction.EAST ) ;
    
   // Wall peh2 =
     //          new Wall (parque, jy, 21, Direction.EAST ) ;
               
       
       /*for (int iw = 13; iw++ < 20; iw ++){
      Wall pee =
               new Wall (parque, 6, iw, Direction.EAST ) ;
      Wall pee1 =
               new Wall (parque, 6, iw, Direction.NORTH) ;
      Wall pee2 =
               new Wall (parque, 6, iw, Direction.WEST ) ;
      }*/
       //enviar codigo a mavergarad@unal.edu.co
       Parqueadero parqueadero = new Parqueadero( 3, 5, 4 );
       
       int opcion= 0, opcion2 = 0 ; 
               String placa = null ;
       System.out.println("Bienvenido a simulador de parqueadero\n"+ "Presione 1 para continuar\n" + "Presione 2 para salir.");
       opcion = g.nextInt();
       while (opcion == 1 ){
           System.out.println("Presione 3 para ingresar vehiculo\n" +"Presione 4 para sacar vehiculo\n" +"Presione 5 para mostrar seccion\n" +  "Presione 6 para generar ingresos\n" );
           opcion2= g.nextInt();
           switch (opcion2){
           case 3: 
               System.out.println("Digite la placa del vehiculo");
               placa= g.next();
               
       }
       
              
       }
       System.out.println("Gracias por visitarnos");
       
       
//       
    
      // Direct the robot to the final situation
      karel.move();
      karel.move();
      karel.pickThing();
      karel.move();
      karel.turnLeft();	// start turning right as three turn lefts
      karel.turnLeft();
      karel.turnLeft();	// finished turning right
      karel.move();
     // karel.putThing();
      karel.move();
      System.out.println(karel.countThingsInBackpack());
   }
}
/**
 *
 * @author MARIAJOSE
 */

