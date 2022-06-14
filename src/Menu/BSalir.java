/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene toda la informacion de el boton "salir" de los menus*/
public class BSalir extends Boton{
     /**constructor de la clase "BSalir", inicializa todos sus atributos */ 
    public BSalir(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/salir0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Salir (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/salir1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Salir (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon);
        cargartamaño();
    }    

}
