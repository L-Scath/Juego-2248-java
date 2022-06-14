/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;
import Principal.Sfx;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase del menu de pause que se abre una vez iniciado el juego*/
public class MenuPause extends Menu{
/**constructor de la clase "MenuPause", inicializa todos sus atributos */   
    public MenuPause(){
        super("Pause");
        sonido=new Sfx();
        b= new Boton[5];        
        cargarMenu();
    } 
    public void cargarBotones(){ 
        b[0]=new BContinuar();
        b[1]=new BInstrucciones();
        b[2]=new BReiniciar();
        b[3]=new BVolverMenu();
        b[4]=new BSalir();        
        for (int i = 0; i <b.length; i++) {
            this.getContentPane().add(b[i]);            
            b[i].setVisible(true);
        }
        b[0].setBounds((this.getWidth()/2)-b[0].getWidth()/2,(b[1].getHeight()*0)+210  ,b[0].getWidth(),b[0].getHeight());
        b[1].setBounds((this.getWidth()/2)-b[1].getWidth()/2,(b[1].getHeight())+215  ,b[1].getWidth(),b[1].getHeight());
        b[2].setBounds((this.getWidth()/2)-b[2].getWidth()/2,(b[1].getHeight()*2)+220  ,b[2].getWidth(),b[2].getHeight());
        b[3].setBounds((this.getWidth()/2)-b[3].getWidth()/2,(b[1].getHeight()*3)+225  ,b[3].getWidth(),b[3].getHeight());
        b[4].setBounds((this.getWidth()/2)-b[4].getWidth()/2,(b[1].getHeight()*4)+230  ,b[4].getWidth(),b[4].getHeight());        
   }  
    public void cargarImagenes(){
        Image fondoImg=null ,iconoImg=null;
        ImageIcon fondoIcon;
        JLabel fondo= new JLabel();
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
        fondoIcon = new ImageIcon(fondoImg);
        this.setIconImage(iconoImg);        
        this.getContentPane().add(fondo);
        fondo.setIcon(fondoIcon);
        fondo.setVisible(true);
        fondo.setBounds(0,0,fondo.getIcon().getIconWidth() ,fondo.getIcon().getIconHeight());
    }
    public void cargarMenu(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.decode("#FF7518"));//-----------color hexadecimal-----------//
        this.setSize(670,720);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.getContentPane().setLayout(null);
        cargarBotones();
        cargarImagenes(); 
        //sonido.sonidoContinuo(sonido.sfxmainTheme);
    }    
    public void ocultarMenu(){
        this.setVisible(false);
        this.setEnabled(false);
        sonido.sfxmainTheme.stop();  
    } 
    
    
}
