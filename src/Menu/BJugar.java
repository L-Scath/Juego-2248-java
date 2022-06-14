/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene toda la informacion de el boton "Jugar" del menu Principal*/
public class BJugar extends Boton{ 
    /**constructor de la clase "BJugar", inicializa todos sus atributos */    
    public BJugar(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/jugar0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Jugar (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/jugar1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Jugar (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon);
        cargartamaño();
    }
}
    
    

