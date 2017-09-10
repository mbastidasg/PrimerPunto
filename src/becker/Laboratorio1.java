package becker;

import java.util.*;
import becker.robots.*;

public class Laboratorio1 {

    private Auto[] auto;
    private FechaHora Hora;
    static float Dinero; 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n= 20;
        float Ingresos [][] = new float [2][n]; 

        boolean[][] usado = new boolean[5][];
        for (int i = 0; i < 5; i++) {
            usado[i] = new boolean[3];
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                usado[i][j] = true;
            }
        }

        boolean[] ZonaT = new boolean[4];

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

        Robot karel = new Robot(ciudad, 5, 2, Direction.NORTH, 20);

        System.out.println("Presione 1. para iniciar:\n");
        int ini = sc.nextInt();
        while (ini == 1) {
            int posX = 0, posY = 0, hy = 0;
            System.out.println("Presione 1. para ingresar auto:\n" + "Presione 2. para sacar auto\n" + "Presione 3. para salir\n "+ "Presione 4. para ver los ingresos del dia:\n"+ "Presione 5. para ver las placas de una zona en el parqueadero:\n");
            int cmd = sc.nextInt();

            String placa1;
            switch (cmd) {
                case 1: {

                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 3; j++) {
                            posX = i;
                            posY = j;

                            if (usado[i][j] == true) {

                                for (int ig = 4; ig >= posX; ig--) {

                                    if (usado[ig][posY] == false && ig != posX) {
                                        sacar2(karel, posX, posY, usado, ZonaT);
                                        ingresar(sc, posX, posY, matrizAutos, ciudad, karel, i, j, usado);
                                        sacarZonaT(karel, posY, ZonaT);

                                        System.out.println("presione 1. para volver a ingresar:\n" + "Presione 2. para volver al menu:\n");
                                        int err = sc.nextInt();
                                        if (err == 2) {
                                            ig = -6;
                                            j = 20;
                                            i = 20;
                                        } else {

                                        }

                                    } else if (ig == posX) {
                                        ingresar(sc, posX, posY, matrizAutos, ciudad, karel, i, j, usado);
                                        System.out.println("presione 1. para volver a ingresar:\n" + "presione 2. para volver al menu:\n");
                                        int err = sc.nextInt();
                                        if (err == 2) {
                                            j = 20;
                                            i = 20;
                                        } else {

                                        }

                                    }

                                }

                            } else {
                                System.out.println("No hay lugar para parquear");
                            }

                        }
                    }
                    break;

                }
                case 2: {
                    System.out.println("Escriba la placa del auto a sacar:");
                    placa1 = sc.next();
                    System.out.println("INDICACION: Segun el mapa del parqueadero responda:");
                    System.out.println("Escriba la fila del sector:");
                    posX = sc.nextInt();
                    System.out.println("Escriba la colmna del sector");
                    posY = sc.nextInt();

                    Sacar(karel, posX, posY, placa1, matrizAutos, usado, ZonaT, n , Ingresos);

                    break;
                }
                case 3:
                    System.out.println("Gracias.");
                    System.exit(0);
                    break;
                case 4:
                    FechaHora mos = new FechaHora();
                    MostrarI ( n, Ingresos, Dinero);
                    
                    break;
                case 5:
                    
                    System.out.println("Escriba la zona de parqueadero que desea ver de '0' a '2' ");
                    int zona = sc.nextInt();
                            for ( int h= 0; h<5; h++){
                                
                                if (usado [h][zona] == false){
                                   System.out.println( matrizAutos[h][zona].getPlaca()); 
                                    
                                } else {
                                   System.out.println("LIBRE");  
                                }
                            }
                    break;
            }

        }
    }

    static void agregarCarro(City ciudad) {
        new Thing(ciudad, 5, 2);
    }

    static void ingresar(Scanner sc, int posX, int posY, Auto matrizAutos[][], City ciudad, Robot karel, int i, int j, boolean usado[][]) {
        System.out.println("placa");
        String placa = sc.next();
        String HoraEntrada;
        FechaHora Hi = new FechaHora();
        HoraEntrada = Hi.Hora();
        String Fecha = Hi.Fecha();

        String HoraSalida = "0.0";
        Auto auto = new Auto(placa, posX, posY, HoraEntrada, HoraSalida);

        matrizAutos[i][j] = auto;

        agregarCarro(ciudad);
        karel.pickThing();
        parquearCarro(karel, 5, 2, posX, posY);
        karel.putThing();

        volverPos(karel, posX, posY, 5, 2);

        usado[i][j] = false;
    }

    static void sacar2(Robot karel, int fx1, int fy1, boolean usado[][], boolean ZonaT[]) {

        for (int i = 4; i > fx1; i--) {

            if (usado[i][fy1] == false) {

                parquearCarro(karel, 5, 2, i, fy1);
                karel.pickThing();
                volverPos(karel, i, fy1, 5, i + 2);

                karel.putThing();
                ZonaT[i - 1] = false;
                karel.turnLeft();
                for (int j = i + 2; j > 2; j--) {
                    karel.move();

                }
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();

            } else {
                ZonaT[i - 1] = true;
            }
        }

    }

    static void parquearCarro(Robot karel, int fx, int fy, int tx, int ty) {

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

        karel.turnLeft();
        karel.turnLeft();

    }

    static void volverPos(Robot karel, int fx1, int fy1, int tx1, int ty1) {

        for (int ij = fx1; ij < tx1; ij++) {
            karel.move();
        }
        karel.turnLeft();
        for (int j = fy1; j < ty1; j++) {
            karel.move();
        }
        karel.turnLeft();
    }

    static void Sacar(Robot karel, int fx1, int fy1, String placa, Auto matrizAutos[][], boolean usado[][], boolean ZonaT[], int n, float Ingresos [][]) {
        int g = 0, d = fx1, u = fy1;

        if (matrizAutos[d][u].getPlaca().equals(placa) && d == fx1 && u == fy1) {

            for (int i = 4; i >= fx1; i--) {

                if (usado[i][fy1] == false && i != fx1) {

                    parquearCarro(karel, 5, 2, i, fy1);
                    karel.pickThing();
                    volverPos(karel, i, fy1, 5, i + 2);

                    karel.putThing();
                    ZonaT[i - 1] = false;
                    karel.turnLeft();
                    for (int j = i + 2; j > 2; j--) {
                        karel.move();

                    }
                    karel.turnLeft();
                    karel.turnLeft();
                    karel.turnLeft();

                } else if (usado[i][fy1] == false && i == fx1) {

                    parquearCarro(karel, 5, 2, fx1, fy1);
                    karel.pickThing();
                    int hy1 = (5 - i) + fy1;
                    volverPos(karel, fx1, fy1, 5, 2);

                    FechaHora Hi = new FechaHora();
                    String Fsalida = Hi.Fecha();
                    String Salida = Hi.Hora();
                    float Precio;
                    matrizAutos[i][fy1].setHoraSalida(Salida);
                    Precio = Hi.Cobro(matrizAutos[i][fy1].getHoraEntrada(), Salida, Fsalida);
                    System.out.println("El precio es :   " + Precio);
                    Dinero = Dinero + Precio;
                    usado[i][fy1] = true;
                    matrizAutos[i][fy1] = null;
                   float fecha = Float.parseFloat(Fsalida);
                    for ( int x = 0; x < n; x ++ ){
                Ingresos [0][x] = Precio;
                Ingresos [1][x] = fecha;
                       
                        }

                    i = -7;
                } else {
                    ZonaT[i - 1] = true;
                }
            }

            sacarZonaT(karel, fy1, ZonaT);

        }
    }

    static void sacarZonaT(Robot karel, int fy1, boolean ZonaT[]) {

        for (int r = 0; r <= 3; r++) {
            System.out.println(r+ "  " );
            if (ZonaT[r] == false) {
                System.out.println("entro");
                karel.turnLeft();
                karel.turnLeft();
                int ui = r + 3;
                int su = r + 1;

                volverPos(karel, 5, 2, 5, ui);

                karel.pickThing();
                parquearCarro(karel, 5, ui, su, fy1);
                karel.putThing();
                ZonaT [r]= true;
                volverPos(karel, su, fy1, 5, 2);
            }

        }

    }
    
    static void MostrarI (int n, float Ingresos[][], float Dinero){
    for (int v = 0; v < 2; v++){
            for ( int x = 0; x < n; x ++ ){
                System.out.println(Ingresos [v][x]);
                System.out.println("Total:   " + Dinero);
                        }
        }
} 

   

}