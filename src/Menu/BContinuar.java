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
/**Clase que contiene toda la informacion de el boton "Continuar" del menu de pausa*/
public class BContinuar extends Boton{
    
    /**constructor de la clase "BContinuar", inicializa todos sus atributos */
    public BContinuar(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/continuar0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Continuar (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/continuar1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton Continuar (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon);
        cargartamaño();
    }    

}