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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene la informacion de los desarrolladores del juego, es una parte del menu principal*/
public class Creditos extends JFrame{
    JTextArea cred;
    public JLabel fondo,creditos,volver,unet;
/**constructor de la clase "Creditos", inicializa todos sus atributos */
    public Creditos(){
        super("Creditos");
        volver= new JLabel("volver");
        cred=new JTextArea();
        fondo=new JLabel();
        creditos=new JLabel();
        unet=new JLabel();
        cargarCreditos();
    }
    public void cargarCreditos(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(0,0,670,720);
        this.setLocationRelativeTo(null);        
        this.setVisible(false);
        this.setLayout(null);
        this.getContentPane().add(volver);
        volver.setBounds(480,550,100,100);
        volver.setVisible(true); 
        this.getContentPane().add(unet);
        unet.setBounds(250,450,151,187);
        unet.setVisible(true);
        this.getContentPane().add(creditos);
        creditos.setBounds(178,60,335,100);
        creditos.setVisible(true);
        this.getContentPane().add(cred);        
        cred.setBounds(35,200,600,350);
        cred.setVisible(true);
        cred.setOpaque(false);
        cred.setBackground(Color.white);
        cred.setFont(new Font("Segoe UI Emoji",0,20));
        cred.setForeground(Color.white);        
        cred.setText("\tJuego Realizado por: \n\n"
                + "    Luis José Uzcátegui Ramírez CI: 25 727 657 \tsección: 03\n"
                +  "    Yéferson Saúl Pérez Ostos  CI: 26 665 544 \tsección: 02\n\n"
                + "    Estudiantes de Ingeniería informática en la UNET\n"
                + "    Proyecto Realizado para la materia Programación I\n\n"
                + "    profesores de la materia:\n"
                + "    Yeniffer del Carmen Peña Castillo\n"
                + "    Saúl Alfonso Quintero Pedroza\n"
                + "    Juego en la version 1.0");
        cred.setEditable(false);
        this.getContentPane().add(fondo);
        fondo.setBounds(0,0,this.getWidth(),this.getHeight());
        fondo.setVisible(true);
        cargarImagenes();
    }
    
     public void cargarImagenes(){
        Image fondoImg=null ,iconoImg=null,volverImg=null,tituloImg=null,unetImg=null;
        ImageIcon fondoIcon,volverIcon,tituloIcon,unetIcon;
        try {            
            unetImg = ImageIO.read(new File("src/Imagenes/unet.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el fondo del menu");       
        }        
        try {            
            tituloImg = ImageIO.read(new File("src/Imagenes/creditos.png"));            
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
        unetIcon=new ImageIcon(unetImg);
        fondo.setIcon(fondoIcon); 
        volver.setIcon(volverIcon);
        creditos.setIcon(tituloIcon);
        unet.setIcon(unetIcon);
        this.setIconImage(iconoImg);
    }
}
