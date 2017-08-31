
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
public class Parqueadero {
    
    Zonas[] zonas;
    Zonas zonaTemporal;
    
    public Parqueadero( int cantidadZonas, int tamZona, int tamZonaTemp ) {
        zonas = new Zonas[cantidadZonas];
        for( int i = 0; i < cantidadZonas; i++) {
            zonas[i] = new Zonas(tamZona);
        }
        zonaTemporal = new Zonas(tamZonaTemp);
    }
    
}
