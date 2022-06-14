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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que contiene los primeros 10 jugadores en un puntaje ordenado del mayor a menor*/
public class Top extends JFrame{
    JLabel top[];   
    public JLabel fondo,volver,top10;
/**constructor de la clase "Top", inicializa todos sus atributos */
    public Top(){
        super("Top 10");
        top=new JLabel[10];
        fondo=new JLabel();
        volver=new JLabel("volver");
        top10=new JLabel();
        cargarTop();
    }
    public void cargarTop(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(0,0,670,720);
        this.setLocationRelativeTo(null);        
        this.setVisible(false);
        this.setLayout(null);
        this.getContentPane().add(top10);
        top10.setBounds(178,25,335,100);
        top10.setVisible(true);         
        this.getContentPane().add(volver);
        volver.setBounds(550,550,100,100);
        volver.setVisible(true);
        for (int i = 0; i < 10; i++) {
            top[i]=new JLabel();
            this.getContentPane().add(top[i]);
            top[i].setBounds(150,((i)*50)+150,400,50);
            top[i].setVisible(true);            
            top[i].setForeground(Color.white);
            top[i].setFont(new Font("Segoe UI Emoji",0,50));
        }
        ordenarTop(leerArch());        
        this.getContentPane().add(fondo);
        fondo.setBounds(0,0,this.getWidth(),this.getHeight());
        fondo.setVisible(true);
                cargarImagenes();
    }
    
     public void cargarImagenes(){
        Image fondoImg=null ,iconoImg=null,volverImg=null,tituloImg=null;
        ImageIcon fondoIcon,volverIcon,tituloIcon;
        try {            
            tituloImg = ImageIO.read(new File("src/Imagenes/top 10.png"));            
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
        top10.setIcon(tituloIcon);
        this.setIconImage(iconoImg);
    }
    public String leerArch(){
        String archivo ="Top.data";        
        String linea="";
        String texto="";
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader entrada = new BufferedReader (fr);
            linea=entrada.readLine();
            while(linea!=null){
                texto=texto+linea+"\n";
                linea=entrada.readLine();                
            }
            entrada.close();
        } catch (IOException ex) {
            System.out.println("Ocurrio un Error al Leer el Archivo");
        }
        return texto; 
    }
    public void ordenarTop(String t){
        int vectornum[]=new int[0];
        String  aux[];
            aux=t.split("\n");   
        String auxpunt[];        
        for (int i = 0; i <aux.length; i++) {
            if (vectornum.length==0) {
            vectornum=new int[aux.length];                
            }
            auxpunt=aux[i].split(":");
            if (auxpunt.length==2) {
               vectornum[i]=Integer.parseInt(auxpunt[1]);  
            }

        }
        
        for (int x = 0; x < vectornum.length; x++) {
            for (int i = 0; i < vectornum.length-x-1; i++) {
                if(vectornum[i] < vectornum[i+1]){
                    int tmp = vectornum[i+1];
                    String stringtmp=aux[i+1];
                    
                    vectornum[i+1] = vectornum[i];
                    aux[i+1]=aux[i];
                            
                    vectornum[i] = tmp;
                    aux[i]=stringtmp;
                }
            }
        }
        for (int i = 0; i < top.length; i++) {
            this.top[i].setText("  "+(i+1)+")"+aux[i]);
        }
    }
}
