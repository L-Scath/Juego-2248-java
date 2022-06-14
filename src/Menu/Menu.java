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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase padre de las clases MenuPpal y MenuPause */
  public abstract class  Menu extends JFrame{
    public Sfx sonido;    
    public Boton b[];
/**constructor de la clase "Menu", recibe el titulo que se le quiera poner al menu */    
    public Menu(String titulo){
        super(titulo);}    
    abstract public void cargarBotones();
    abstract public void cargarImagenes();
    abstract public void cargarMenu();
    abstract public void ocultarMenu();
}  

