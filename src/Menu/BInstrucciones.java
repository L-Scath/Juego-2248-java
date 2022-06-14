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
/**Clase que contiene toda la informacion de el boton "instrucciones" de los menus*/
public class BInstrucciones extends Boton{   
    /**constructor de la clase "BInstrucciones", inicializa todos sus atributos */
    public BInstrucciones(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/instrucciones0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Instrucciones (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/instrucciones1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Instrucciones (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon); 
        cargartamaño();
    }    

}
