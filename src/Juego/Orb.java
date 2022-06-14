package Juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene toda la informacion de un orbe*/
public class Orb extends JLabel{
    Image imagen;
    ImageIcon imageIco;
    boolean selecc;
    int valor;
    int pos;
    /**constructor de la clase "Orb", inicializa todos sus atributos */
    public Orb() {
        selecc=false;
        valor=0;
        pos=-1;
        try {            
            imagen = ImageIO.read(new File("src/imagenes/0.png"));           
        } catch (IOException e) {            
            System.out.println("Error Cargando el orb");       
        }
        imageIco= new ImageIcon(imagen);
        this.setIcon(imageIco);
        cargartamaño();
    } 
    
    public void cargartamaño(){
        this.setSize(imageIco.getIconWidth(), imageIco.getIconHeight());       
    }          
    public void cargarvalor(){
        
    }     
    public void cargarImagenOrbe(int val){
        if (selecc==false) {
        try {            
            imagen = ImageIO.read(new File("src/imagenes/"+val+".png"));           
        } catch (IOException e) {            
            System.out.println("Error Cargando el orb");       
        }
        imageIco= new ImageIcon(imagen);
        this.setIcon(imageIco);
        }else {
        try {            
            imagen = ImageIO.read(new File("src/imagenes/"+val+" - copia.png"));           
        } catch (IOException e) {            
            System.out.println("Error Cargando el orb");       
        }
        imageIco= new ImageIcon(imagen);
        this.setIcon(imageIco);
        }        
    }    
    public Rectangle2D areaCirculo(){        
        return new Rectangle2D.Double(getX()+12,getY()+12, this.getWidth()-12,80-12);        
    }
    public Rectangle2D areaext(){        
        return new Rectangle2D.Double(getX()-12,getY()-12, this.getWidth()+12,80+12);        
    }
    public Rectangle2D area(){        
        return new Rectangle2D.Double(getX(),getY(), this.getWidth(),80);        
    }
    
}
