/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Juego.Juego;
import Menu.Creditos;
import Menu.Instrucciones;
import Menu.MenuPpal;
import Menu.MenuPause;
import Menu.Top;
import javax.swing.JFrame;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene el main y ejecuta el juego*/
public class Principal {
    public Juego j; 
/**constructor de la clase "Principal",crea una instancia de Juego y lo inicia*/  
    public Principal() {
        j=new Juego("2248");
    }       
    public static void main(String[] args) {
        Principal p = new Principal();
        
    }
    
}
