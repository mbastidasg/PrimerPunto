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
public class Zonas {
    
    Espacio[] espacio;
    
    public Zonas( int tamano ) {
        espacio = new Espacio[tamano];
        for( int i = 0; i < tamano; i++ ) {
            espacio[i] = new Espacio();
        }
    }
    
}
