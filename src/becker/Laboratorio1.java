package becker;

import java.util.*;
import becker.robots.*;

public class Laboratorio1 {

    private Auto[] auto;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean[][] usado = new boolean[3][];
        for (int i = 0; i < 3; i++) {
            usado[i] = new boolean[5];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                usado[i][j] = true;
            }
        }
        Auto[][] matrizAutos = new Auto[5][3];

        // Set up the initial situation
        City ciudad = new City();

        // Parqueadero 1
        for (int i = 0; i < 5; i++) {
            new Wall(ciudad, i, 0, Direction.WEST);
            //new Wall(ciudad, i, 1, Direction.EAST);
        }
        new Wall(ciudad, 0, 0, Direction.NORTH);

        // Parqueadero2
        for (int i = 0; i < 5; i++) {
            new Wall(ciudad, i, 1, Direction.WEST);
            //new Wall(ciudad, i, 2, Direction.EAST);
        }
        new Wall(ciudad, 0, 1, Direction.NORTH);

        // Parqueadero 3
        for (int i = 0; i < 5; i++) {
            new Wall(ciudad, i, 2, Direction.WEST);
            new Wall(ciudad, i, 2, Direction.EAST);
        }
        new Wall(ciudad, 0, 2, Direction.NORTH);

        // Zona temporal
        for (int i = 3; i < 7; i++) {
            new Wall(ciudad, 5, i, Direction.NORTH);
            new Wall(ciudad, 5, i, Direction.SOUTH);
        }
       
        new Wall(ciudad, 5, 6, Direction.EAST);

        Robot karel = new Robot(ciudad, 5, 2, Direction.NORTH, 5);
        System.out.println("desea iniciar presione 1?");
        int ini = sc.nextInt();
        while( ini == 1 ) {
            System.out.println("desea ingresar carro");
        String cmd = sc.next();
        switch (cmd) {
            case "ingresar": {
                     int posX, posY;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (usado[i][j] == true) {
                            posX = i;
                            posY = j;
                            System.out.println("placa");
                            String placa = sc.next();
                            System.out.println("hora entrada");
                            String HoraEntrada = sc.next();
                            String HoraSalida = "cv";
                            Auto auto = new Auto(placa, posX, posY, HoraEntrada, HoraSalida);

                            matrizAutos[i][j] = auto;

                            agregarCarro(ciudad);
                            parquearCarro(karel, 5, 2, posX, posY);
                            
                            if (posY == 0){
                            volverPos(karel, posY, posX, 5, 2);
                            }
                            else if (posY == 1){
                               volverPos(karel, posY, posX, 5+1, 1);
                               
                            }
                            else if (posY == 2){
                               volverPos(karel, posY, posX, 5+2, 0);
                               
                            }
                            usado[i][j] = false;
                        } else {
                            System.out.println("no hay lugar para parquear");
                        }
                    }
                    
                    break;
                }

            }
        }
        //} 
        /*
		agregarCarro(ciudad);
		int x = -1, y = -1;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (x == -1 && y == -1 && !usado[i][j]) {
					x = i;
					y = j;
				}
			}
		}
		x = 1; y = 2;
		parquearCarro(karel, 6, 6, x, 2 * y + 1);
         */
        //irEntrada(karel, 6, 6, )
        // karel.move();
        // karel.move();
        // karel.pickThing();
        // karel.move();
        // karel.turnLeft(); // start turning right as three turn lefts
        // karel.turnLeft();
        // karel.turnLeft(); // finished turning right
        // karel.move();
    }
    }
    
    
    
    
    static void agregarCarro(City ciudad) {
        new Thing(ciudad, 5, 2);
    }

    static void parquearCarro(Robot karel, int fx, int fy, int tx, int ty) {
        karel.pickThing();
        karel.turnLeft();
        for (int j = fy; j > ty; j--) {
            karel.move();
        }
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        for (int i = fx; i > tx; i--) {
            karel.move();
        }
        karel.putThing();
        karel.turnLeft();
        karel.turnLeft();

    }

    static void volverPos(Robot karel, int fx1, int fy1, int tx1, int ty1) {
        
        
        for (int ij = fx1; ij < tx1; ij++) {
            karel.move();
        }
        karel.turnLeft();
        for (int j = 0; j < ty1; j++) {
            karel.move();
        }
        karel.turnLeft();
    }

}
