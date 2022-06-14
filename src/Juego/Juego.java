package Juego;

import Menu.BCreditos;
import Menu.BInstrucciones;
import Menu.BJugar;
import Menu.BSalir;
import Menu.BTop;
import Menu.Creditos;
import Menu.Instrucciones;
import Menu.MenuPause;
import Menu.MenuPpal;
import Menu.Top;
import Principal.Sfx;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_SPACE;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
//import javafx.geometry.Pos;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.Timer;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */

/**Clase donde se ejecuta el juego */
public class Juego extends JFrame{
    
    Sfx sonido;
    Orb ball[][];
    Reloj tiempo;
    Timer timerAnim;
    int acumsel,acumpunt,numdesbl;
    JLabel puntaje,relojfondo,puntajefondo;
    JLabel menu;
    MenuPause menuP;
    MenuPpal menuppal;
    Instrucciones instrucc;
    Top top;
    Creditos creditos;
    /**constructor de la clase "Juego", inicializa todos sus atributos */
    public Juego(String s){
        super(s);
        top=new Top();
        instrucc=new Instrucciones();
        creditos=new Creditos();        
        numdesbl=4;
        acumsel=0;
        acumpunt=0;
        tiempo=new Reloj();
        sonido=new Sfx();
        ball= new Orb[5][7];
        puntaje=new JLabel();
        puntajefondo=new JLabel();
        menuP=new MenuPause(); 
        menu=new JLabel();
        menuppal=new MenuPpal();
        relojfondo=new JLabel();
        cargarJuego();        
    }  
    public void cargarImagenes(){
        Image fondoImg=null ,iconoImg=null,relojImg=null,pauseImg=null,PuntajeImg=null;
        ImageIcon fondoIcon,relojIcon,pauseIcon,puntajeIcon;
        JLabel fondo= new JLabel();
        try {            
            fondoImg = ImageIO.read(new File("src/Imagenes/fondoJuego.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el fondo del menu");       
        }        
        try {            
            iconoImg = ImageIO.read(new File("src/Imagenes/icono.jpg"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el icono del menu");       
        }
        try {            
            relojImg = ImageIO.read(new File("src/Imagenes/reloj.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el icono del menu");       
        }
        try {            
            pauseImg = ImageIO.read(new File("src/Imagenes/pause.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el icono del menu");       
        }
        try {            
            PuntajeImg = ImageIO.read(new File("src/Imagenes/reloj.png"));            
        } catch (IOException e) {            
            System.out.println("Error Cargando el icono del menu");       
        }
        
        fondoIcon = new ImageIcon(fondoImg);
        relojIcon = new ImageIcon(relojImg);
        puntajeIcon= new ImageIcon(PuntajeImg);
        pauseIcon = new ImageIcon(pauseImg);
        this.setIconImage(iconoImg);        
        this.getContentPane().add(fondo);
        fondo.setIcon(fondoIcon);
        puntajefondo.setIcon(puntajeIcon);
        relojfondo.setIcon(relojIcon);
        menu.setIcon(pauseIcon);
        fondo.setVisible(true);
        fondo.setBounds(0,0,fondo.getIcon().getIconWidth() ,fondo.getIcon().getIconHeight());
    }  
    public void cargarJuego(){
        tiempo.IniciarReloj();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.decode("#DEB887"));//-----------color hexadecimal-----------//
        this.setSize(670,720);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.getContentPane().setLayout(null);        
        this.menuP.setVisible(false);
        this.getContentPane().add(tiempo);
        this.tiempo.setVisible(true);
        this.tiempo.setBounds(100,15,100,30);
        puntaje.setForeground(Color.WHITE);
        puntaje.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        this.getContentPane().add(puntaje);
        this.puntaje.setVisible(true);
        this.puntaje.setBounds(510,15,100,30);        
        this.getContentPane().add(relojfondo);
        relojfondo.setBounds(400,5,300,50);
        relojfondo.setVisible(true);
        this.getContentPane().add(puntajefondo);
        puntajefondo.setBounds(10,5,300,50);
        puntajefondo.setVisible(true);        
        this.getContentPane().add(menu);
        menu.setBounds(200,640,300,50);
        menu.setVisible(true);
        menu.setText("\t\t                                      MENU");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                ball[i][j]=new Orb();
            }            
        }
        cargarOrbes();
        cargarImagenes();
        if (isVisible()) {
            sonido.sonidoContinuo(sonido.sfxmainTheme);
        }        
        cargarTimers();
        cargarEventos();
    }    
    public void cargarOrbes(){ 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {            
                this.getContentPane().add(ball[i][j]);
                ball[i][j].setVisible(true);
                ball[i][j].setText(Integer.toString(i+j));               
                ball[i][j].setBounds((ball[i][j].getWidth())*(i)+115,80*j,ball[i][j].getWidth(),ball[i][j].getHeight());
                ball[i][j].setFocusable(false);
            }
        }
        orbesAleat(numdesbl);
   }
    public void orbesAleat(int desb){
        Random rand= new Random();
        int num=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (ball[i][j].valor==0){
                    num=rand.nextInt(numdesbl)+1;
                    if (num<=2) {
                        ball[i][j].valor=2;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor);
                    }else if (num>=2 && num<4){
                        ball[i][j].valor=2;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=4 && num<8){
                        ball[i][j].valor=4;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=8 && num<16){
                        ball[i][j].valor=8;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=16 && num<32){
                        ball[i][j].valor=16;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=32 && num<64){
                        ball[i][j].valor=32;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=64 && num<128){
                        ball[i][j].valor=64;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=128 && num<256){
                        ball[i][j].valor=128;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=256 && num<512){
                        ball[i][j].valor=256;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=512 && num<1024){
                        ball[i][j].valor=512;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=1024 && num<2048){
                        ball[i][j].valor=1024;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    } else if (num>=2048 && num<4096){
                        ball[i][j].valor=2048;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=4096 && num<8192){
                        ball[i][j].valor=4096;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }else if (num>=8192 && num<16384){
                        ball[i][j].valor=8192;
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor); 
                    }  
                }
            }
        }
    }
    public void cargarEventos(){
            menuppal.b[0].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuppal.b[0].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuppal.b[0].sal();
                }
                public void mouseClicked(MouseEvent e) {                    
                    sonido.sonido(sonido.sfxbClick);
                    
                    String nombre = JOptionPane.showInputDialog(null,"Ingrese Su nombre","Nuevo Jugador",JOptionPane.QUESTION_MESSAGE);
                    if (nombre!=null) {                    
                        while(nombre.length()>8||nombre.length()==0||nombre==null){
                            nombre = JOptionPane.showInputDialog(null,"el nombre no debe estar en blanco ni debe tener mas de 8 letras","ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"entro como usuario anonimo");
                        nombre="AAA";
                    }
                    try {
                            File archivo = new File("Top.data");
                            FileWriter fw = new FileWriter(archivo,true);                      
                            BufferedWriter bw = new BufferedWriter(fw);                            
                            fw.append(nombre + ":");
                            fw.close();//cierro         
                        } catch (IOException ex) {
                            System.out.println("Error en escritura de archivo...");
                        }
                    
                    menuppal.ocultarMenu();
                    sonido.sonidoContinuo(sonido.sfxmusicaJuego);
                    sonido.sfxmainTheme.stop();
                    setVisible(true);
                    tiempo.IniciarReloj();
                    tiempo.timerReloj.start();
                    timerAnim.start();
                }
            });            
            menuppal.b[1].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuppal.b[1].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuppal.b[1].sal(); 
                }
                public void mouseClicked(MouseEvent e) {                    
                    sonido.sonido(sonido.sfxbClick);
                    instrucc.setVisible(true);
                    menuppal.setVisible(false);
                }
            });            
            menuppal.b[2].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuppal.b[2].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuppal.b[2].sal(); 
                }
                public void mouseClicked(MouseEvent e) {                    
                    sonido.sonido(sonido.sfxbClick);
                    top.ordenarTop(top.leerArch());
                    top.setVisible(true);
                    menuppal.setVisible(false);
                }                
            });
            menuppal.b[3].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuppal.b[3].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuppal.b[3].sal(); 
                }
                public void mouseClicked(MouseEvent e) {
                    sonido.sonido(sonido.sfxbClick);
                    creditos.setVisible(true);
                    menuppal.setVisible(false);
                }                  
            });
            menuppal.b[4].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuppal.b[4].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuppal.b[4].sal(); 
                }
                public void mouseClicked(MouseEvent e) {
                    sonido.sonido(sonido.sfxbClick);
                    System.exit(0);
                }                
            });        
            menuP.b[0].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuP.b[0].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuP.b[0].sal();
                }
                public void mouseClicked(MouseEvent e) {                    
                    sonido.sonido(sonido.sfxbClick);
                    menuP.setVisible(false);
                    tiempo.IniciarReloj();
                    timerAnim.start();
                    sonido.sfxmainTheme.stop();
                    sonido.sonidoContinuo(sonido.sfxmusicaJuego);
                    setVisible(true);
                }
            });            
            menuP.b[1].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuP.b[1].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuP.b[1].sal(); 
                }
                public void mouseClicked(MouseEvent e) {                    
                    sonido.sonido(sonido.sfxbClick);
                    instrucc.setVisible(true);
                    menuP.setVisible(false);
                }
            });            
            menuP.b[2].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuP.b[2].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuP.b[2].sal(); 
                }
                public void mouseClicked(MouseEvent e) {                    
                    sonido.sonido(sonido.sfxbClick);
                    numdesbl=4;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 7; j++) {
                            ball[i][j].valor=0;
                            ball[i][j].setBounds((ball[i][j].getWidth())*(i)+115,80*j,ball[i][j].getWidth(),ball[i][j].getHeight());
                            orbesAleat(numdesbl);
                        }
                    }
                    tiempo.limpiarReloj();
                    acumpunt=0;
                    puntaje.setText("");                    
                    setVisible(true);
                    menuP.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Se Reinicio el juego");
                    timerAnim.start();
                    tiempo.timerReloj.start();
                }                
            });
            menuP.b[3].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuP.b[3].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuP.b[3].sal(); 
                }
                public void mouseClicked(MouseEvent e) {
                    sonido.sonido(sonido.sfxbClick);
                    try {
                        File archivo = new File("Top.data");
                        FileWriter fw = new FileWriter(archivo,true);                      
                        BufferedWriter bw = new BufferedWriter(fw);                            
                        fw.append(acumpunt+"\n");
                        fw.close();//cierro         
                        } catch (IOException ex) {
                            System.out.println("Error en escritura de archivo...");
                        }
                    numdesbl=4;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 7; j++) {
                            ball[i][j].valor=0;
                            ball[i][j].setBounds((ball[i][j].getWidth())*(i)+115,80*j,ball[i][j].getWidth(),ball[i][j].getHeight());
                            orbesAleat(numdesbl);
                        }
                    }
                    tiempo.limpiarReloj();
                    acumpunt=0;
                    puntaje.setText("");
                    top.ordenarTop(top.leerArch());
                    menuppal.setVisible(true);
                    menuppal.setEnabled(true);
                    menuP.setVisible(false);                    
                }                  
            });
            menuP.b[4].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e){
                    menuP.b[4].ent();
                    sonido.sonido(sonido.sfxbSel);
                }
                public void mouseExited(MouseEvent e){
                   menuP.b[4].sal(); 
                }
                public void mouseClicked(MouseEvent e) {
                    sonido.sonido(sonido.sfxbClick);
                    try {
                        File archivo = new File("Top.data");
                        FileWriter fw = new FileWriter(archivo,true);                      
                        BufferedWriter bw = new BufferedWriter(fw);                            
                        fw.append(acumpunt+"\n");
                        fw.close();//cierro         
                        } catch (IOException ex) {
                            System.out.println("Error en escritura de archivo...");
                        }
                    System.exit(0);
                }                
            });        
        this.addKeyListener(new KeyAdapter() {   
            public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode()==VK_SPACE||e.getKeyCode()==VK_ENTER) {
                    timerAnim.stop();
                    tiempo.timerReloj.stop();
                    setVisible(false);
                    sonido.sfxmusicaJuego.stop();
                    sonido.sonidoContinuo(sonido.sfxmainTheme);                   
                    menuP.setVisible(true);
                    menuP.setEnabled(true);
                }
            }
        }); 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                ball[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e){
                        Orb auxA=(Orb)e.getSource();
                        Orb auxB= new Orb();
                        if (auxA.selecc&&auxA.pos==0) {                            
                            auxA.selecc=false;
                            auxA.pos=-1;                            
                            }else if (auxA.selecc&&auxA.pos!=0) {
                                                for (int k = 0; k < 5; k++) {
                                                    for (int l = 0; l < 7; l++) {
                                                        if (ball[k][l].equals(e.getSource())) {
                                                            contar();
                                                            ball[k][l].selecc=false;
                                                                if (acumsel<=2) {
                                                                    ball[k][l].valor=2;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=2 && acumsel<4){
                                                                    ball[k][l].valor=2;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=4 && acumsel<8){
                                                                    ball[k][l].valor=4;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=8 && acumsel<16){
                                                                    ball[k][l].valor=8;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=16 && acumsel<32){
                                                                    ball[k][l].valor=16;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=32 && acumsel<64){
                                                                    ball[k][l].valor=32;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=64 && acumsel<128){
                                                                    ball[k][l].valor=64;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=128 && acumsel<256){
                                                                    ball[k][l].valor=128;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=256 && acumsel<512){
                                                                    ball[k][l].valor=256;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=512 && acumsel<1024){
                                                                    ball[k][l].valor=512;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=1024 && acumsel<2048){
                                                                    ball[k][l].valor=1024;
                                                                    ball[k][l].pos=-1;
                                                                } else if (acumsel>=2048 && acumsel<4096){
                                                                    ball[k][l].valor=2048;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=4096 && acumsel<8192){
                                                                    ball[k][l].valor=4096;
                                                                    ball[k][l].pos=-1;
                                                                }else if (acumsel>=8192 && acumsel<16384){
                                                                    ball[k][l].valor=8192;
                                                                    ball[k][l].pos=-1;
                                                                }
                                                            sonido.sonido(sonido.sfxorbErr);                                         
                                                        }
                                                    }
                                               }
                            verificar();                            
                        }
                        
                    }
                });                        
                ball[i][j].addMouseMotionListener(new MouseMotionAdapter() {
                    //@Override
                    public void mouseDragged(MouseEvent e){                         
                        for (int k = 0; k < 5; k++) {
                            for (int l = 0; l < 7; l++) {                                
                                Orb auxA =(Orb)e.getSource();
                                Orb auxB=new Orb();
                                if (auxA.areaCirculo().contains(e.getComponent().getX()+e.getX(),e.getComponent().getY()+e.getY(),1,1)) {
                                    if (!auxA.selecc) {    
                                        sonido.sonido(sonido.sfxorbSel);
                                        auxA.selecc=true;
                                        auxA.pos=0;
                                        }    
                                }
                                if(auxA.pos==0){
                                        if (auxA.areaext().intersects(ball[k][l].areaext())) {
                                            if (ball[k][l].areaCirculo().contains(e.getComponent().getX()+e.getX(),e.getComponent().getY()+e.getY(),1,1)&&ball[k][l].equals(e.getSource())==false&&auxA.valor==ball[k][l].valor&&ball[k][l].selecc==false&&ball[k][l].pos==-1) {
                                                auxB.selecc=auxA.selecc;
                                                auxB.valor=auxA.valor;
                                                auxB.pos=auxA.pos;                                                
                                                auxB.setBounds(auxA.getX(),auxA.getY(),auxA.getWidth(),auxA.getHeight());
                                                auxA.setLocation(ball[k][l].getX(),ball[k][l].getY());
                                                auxA.valor=ball[k][l].valor;
                                                auxA.pos=auxA.pos+1;
                                                ball[k][l].selecc=auxB.selecc;
                                                ball[k][l].valor=auxB.valor;   
                                                ball[k][l].setLocation(auxB.getX(),auxB.getY());                                                
                                                ball[k][l].pos=auxB.pos;
                                                e.setSource(auxA);
                                                e.translatePoint(auxA.getX()+e.getXOnScreen(),auxA.getY()+e.getY());                                               
                                            }
                                        }  
                                }

                                if(auxA.pos>0){
                                        if (auxA.areaext().intersects(ball[k][l].areaext())) {
                                            if (ball[k][l].areaCirculo().contains(e.getComponent().getX()+e.getX(),e.getComponent().getY()+e.getY(),1,1)&&ball[k][l].equals(e.getSource())==false&&(auxA.valor==ball[k][l].valor||auxA.valor*(2)==ball[k][l].valor)&&!ball[k][l].selecc&&ball[k][l].pos==-1) {
                                                auxB.selecc=auxA.selecc;
                                                auxB.valor=auxA.valor;
                                                auxB.pos=auxA.pos;                                                
                                                auxB.setBounds(auxA.getX(),auxA.getY(),auxA.getWidth(),auxA.getHeight());
                                                auxA.setLocation(ball[k][l].getX(),ball[k][l].getY());
                                                auxA.valor=ball[k][l].valor;
                                                auxA.pos=auxA.pos+1;
                                                ball[k][l].selecc=auxB.selecc;
                                                ball[k][l].valor=auxB.valor;                                                
                                                ball[k][l].setLocation(auxB.getX(),auxB.getY());
                                                ball[k][l].pos=auxB.pos;
                                                e.setSource(auxA);
                                                e.translatePoint(auxA.getX()+e.getXOnScreen(),auxA.getY()+e.getY());
                                                sonido.sonido(sonido.sfxorbSel); 
                                            }
                                        }  
                                } 
                                 e.setSource(auxA);       
                            }
                        }  
                    } 
                });                
            }
        }
        menu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                menuP.setVisible(true);
                sonido.sfxmusicaJuego.stop();
                sonido.sonidoContinuo(sonido.sfxmainTheme); 
            }
        });
        creditos.volver.addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent e) {
                if (menuppal.isEnabled()) {
                    creditos.setVisible(false);
                    menuppal.setVisible(true);
                    sonido.sonido(sonido.sfxatras);
                }else{
                    creditos.setVisible(false);
                    menuP.setVisible(true); 
                    sonido.sonido(sonido.sfxatras);
                }
            }
        });
        top.volver.addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent e) {
                if (menuppal.isEnabled()) {
                    top.setVisible(false);
                    menuppal.setVisible(true);
                    sonido.sonido(sonido.sfxatras);
                }else{
                    top.setVisible(false);
                    menuP.setVisible(true);  
                    sonido.sonido(sonido.sfxatras);
                }
            }
        });       
        instrucc.volver.addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent e) {
                if (menuppal.isEnabled()) {
                    instrucc.setVisible(false);
                    menuppal.setVisible(true);
                    sonido.sonido(sonido.sfxatras);
                }else{
                    instrucc.setVisible(false);
                    menuP.setVisible(true);
                    sonido.sonido(sonido.sfxatras);
                }
            }
        });   
        
    }     
    public void reiniciar(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                ball[i][j].valor=0;
            }
        }
        orbesAleat(4);
    }
    public void cargarTimers(){
        timerAnim=new Timer(50,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 7; j++) {
                        ball[i][j].cargarImagenOrbe(ball[i][j].valor);
                    }
                }
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 7; j++) {                       
                        if (ball[i][j].area().getY()!=(560)&&ball[i][j].selecc==false){
                            ball[i][j].setLocation(ball[i][j].getX(),ball[i][j].getY()+5);
                            if (colision(ball[i][j])) {
                                ball[i][j].setLocation(ball[i][j].getX(),ball[i][j].getY()-5);
                            }
                        }
                    }
                }
                orbesAleat(numdesbl);
            }        
        });        
    }    
    public void contar(){
for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (ball[i][j].selecc==true&&ball[i][j].pos!=-1) {
                    acumsel+=ball[i][j].valor;                          
                }                
            }
        }
        if (numdesbl<acumsel) {
            numdesbl=acumsel ;
        }
        acumpunt+=acumsel;
        puntaje.setText(Integer.toString(acumpunt));                
    }    
    public void verificar(){
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 7; j++) {
                    if (ball[i][j].selecc==true&&ball[i][j].pos!=-1) {
                        ball[i][j].setLocation(ball[i][j].getX(),ball[i][j].getY()*-1);
                        ball[i][j].pos=-1;
                        ball[i][j].selecc=false;
                        ball[i][j].valor=0;                        
                    }                
                }
            }
            acumsel=0;
            puntaje.setText(Integer.toString(acumpunt));        
        }
    public boolean colision(Orb o){
        boolean aux =false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (o.area().intersects(ball[i][j].area())&&!o.equals(ball[i][j])) {
                    aux = true;
                }
            }
        }
        return aux;
    }    
}
