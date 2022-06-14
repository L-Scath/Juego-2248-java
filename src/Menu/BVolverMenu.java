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
 * @author luis.uzcategui * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos */
/**Clase que contiene toda la informacion de el boton "Volver al menu Principal" del menu de pausa*/
public class BVolverMenu extends Boton{
    
    /**constructor de la clase "BVolverMenu", inicializa todos sus atributos */
    public BVolverMenu(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/volverMenu0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Volver al menu (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/volverMenu1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Volver al menu (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon);
        cargartamaño();
    }    

}
