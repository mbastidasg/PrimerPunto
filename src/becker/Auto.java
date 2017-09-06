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
    private double posX;
    private double posY;  
    private String HoraEntrada;
    private  String HoraSalida;

    public Auto(String placa,double posX, double posY,  String HoraEntrada, String HoraSalida) {
        this.placa = placa;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.posX = posX;
        this.posY = posY;
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
    
    public void recorrer ( String Mapa[][] ){
        System.out.println("hola");
        for (int i = 1; i<13 ; i+=2){
            for (int j = 2; j<13; j+=4){
                if (Mapa [i][j] == null){
                
                    Mapa [i] [j] = placa;
            //        posicion = i,j ;
            }
                else {
                    System.out.println("Gracias, no hay lugar disponible");
                }
        }
        
    }
    }
}

