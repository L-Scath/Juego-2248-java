/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene las instrucciones para jugar el juego, es una parte del los menus*/
public class Instrucciones extends JFrame{
    JTextArea instr;
    public JLabel fondo,instrucciones,volver;
 /**constructor de la clase "Instrucciones", inicializa todos sus atributos */
    public Instrucciones(){
        super("Instrucciones");
        volver= new JLabel("volver");
        instr=new JTextArea();
        fondo=new JLabel();
        instrucciones=new JLabel();
        cargarInstrucciones();
    }
    public void cargarInstrucciones(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(0,0,670,720);
        this.setLocationRelativeTo(null);        
        this.setVisible(false);
        this.setLayout(null);
        this.getContentPane().add(volver);
        volver.setBounds(450,550,100,100);
        volver.setVisible(true);         
        this.getContentPane().add(instrucciones);
        instrucciones.setBounds(178,60,335,100);
        instrucciones.setVisible(true);
        this.getContentPane().add(instr);        
        instr.setBounds(45,200,600,350);
        instr.setVisible(true);
        instr.setOpaque(false);
        instr.setBackground(Color.white);
        instr.setFont(new Font("Segoe UI Emoji",0,18));
        instr.setForeground(Color.white);        
        instr.setText(  "   ¿Podrás sumar todos los números en este desafiante juego de ingenio?         \n"+
                        "       Mueve las bolas ó esferas numeradas para hacerlas fusionarse.             \n"+
                        "         ¿Cuántos movimientos lograrás hacer hasta que te trabes?                 \n\n\n\n" +
                        "      La mecánica es la siguiente: Se selecciona una esfera con un valor             \n" +
                        "    y a través de un trazo que puede ser en cualquier sentido, se busca una       \n" +
                        "esfera adyacente del mismo valor, y éstas se suman. Si después de la fusión    \n" +
                        "  la segunda esfera tiene otra esfera adyacente que sea del valor resultante             \n" +
                        "     de las dos anteriormente seleccionadas, también se podrían fusionar            \n" +
                        "                                           y así sucesivamente.  ");
        instr.setEditable(false);
        this.getContentPane().add(fondo);
        fondo.setBounds(0,0,this.getWidth(),this.getHeight());
        fondo.setVisible(true);
                cargarImagenes();
    }
    
     public void cargarImagenes(){
        Image fondoImg=null ,iconoImg=null,volverImg=null,tituloImg=null;
        ImageIcon fondoIcon,volverIcon,tituloIcon;
        try {            
            tituloImg = ImageIO.read(new File("src/Imagenes/instrucciones.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el fondo del menu");       
        } 
        try {            
            volverImg = ImageIO.read(new File("src/Imagenes/volver menu.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el fondo del menu");       
        }  
        try {            
            fondoImg = ImageIO.read(new File("src/Imagenes/menu.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el fondo del menu");       
        }        
        try {            
            iconoImg = ImageIO.read(new File("src/Imagenes/icono.jpg"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el icono del menu");       
        }        
        volverIcon=new ImageIcon(volverImg);
        fondoIcon = new ImageIcon(fondoImg);
        tituloIcon=new ImageIcon(tituloImg);
        fondo.setIcon(fondoIcon); 
        volver.setIcon(volverIcon);
        instrucciones.setIcon(tituloIcon);
        this.setIconImage(iconoImg);
    }    
}
