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
/**Clase que contiene toda la informacion de el boton pordefecto del menu y es boton que aparece si llega a ocurir un error de los demas botones*/
public class Boton extends JLabel{
     Image selImg,unselImg;
     ImageIcon selIcon,unselIcon;
/**constructor de la clase "Boton", inicializa todos sus atributos */     
    public Boton(){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/boton0.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton por defecto (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/boton1.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton por defecto (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon);
        cargartamaño();
    }    
    public Boton(String sinseleccionar,String seleccionado){
        try {            
            unselImg = ImageIO.read(new File("src/Imagenes/"+sinseleccionar));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton por defecto (boton sin seleccionar)");       
        }        
        try {            
            selImg = ImageIO.read(new File("src/Imagenes/"+seleccionado));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el boton por defecto (boton seleccionado)");       
        }        
        unselIcon= new ImageIcon(unselImg);
        selIcon= new ImageIcon(selImg);
        this.setIcon(unselIcon); 
        cargartamaño();
    }    
    public void ent(){
       this.setIcon(selIcon);
    }
    public void sal(){
       this.setIcon(unselIcon); 
    }
    public void cargartamaño(){
        this.setSize(selIcon.getIconWidth(), selIcon.getIconHeight());       
    }
    
}
