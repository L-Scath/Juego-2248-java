/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene toda la informacion de el boton "top 10" del menu principal*/
public class BTop extends Boton{
        /**constructor de la clase "BTop", inicializa todos sus atributos */
    public BTop(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/top0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Top (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/top1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Top (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon); 
        cargartamaño();
    }        
}
