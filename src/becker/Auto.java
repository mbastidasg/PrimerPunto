/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

/**
 *
 * @author MARIAJOSE
 */
public class Auto {
 // atributos
    
    private String placa;
     
            private int n;
    private String HoraEntrada;
    private  String HoraSalida;

    public Auto(String placa,  String HoraEntrada, String HoraSalida) {
        this.placa = placa;
        
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }
    
    String Mapa[][] = new String [13][13]; 
    int posicion [][] = new int [2][n]; 
    
    public boolean ingresar (){
    
}
    
    public double recorrer ( String Mapa[][] ){
        
        for (int i = 1; i<13 ; i+=2){
            for (int j = 2; j<13; j+=4){
                if (Mapa [i][j] == null){
                
                    Mapa [i] [j] = placa;
                    posicion = i,j ;
            }
                else {
                    System.out.println("Gracias, no hay lugar disponible");
                }
        }
        
    }
    
}
