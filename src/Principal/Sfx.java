package Principal;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**Clase que carga los sonidos del juego*/
public class Sfx {
    
    public String bSel, bClick,orbSel,orbErr,mainTheme,atras,musicaJuego;
    public Clip sfxbSel, sfxbClick,sfxorbSel,sfxorbErr,sfxmainTheme,sfxatras,sfxmusicaJuego;
    
/**constructor de la clase "Sfx", carga la direccion donde se encuentran los archivos de musica*/               
    public Sfx(){        
        bSel = "src/Audio/Scroll.wav";
        bClick = "src/Audio/Confirm.wav";
        orbSel = "src/Audio/sel.wav";
        orbErr = "src/Audio/err.wav";
        mainTheme = "src/Audio/menu.wav";
        atras = "src/Audio/atras.wav";
        musicaJuego = "src/Audio/juego.wav";        
        CargarSonido(); 
    }    
    
    public void sonidoContinuo(Clip audio){            
            audio.stop();
            audio.setFramePosition(0);
            audio.loop(Clip.LOOP_CONTINUOUSLY);                
    }    
    public void sonido(Clip audio){            
            audio.stop();
            audio.setFramePosition(0);
            audio.start();  
    }  
    public void CargarSonido(){        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bSel));
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            sfxbSel=(Clip)AudioSystem.getLine(info);
            sfxbSel.open(audioInputStream);
            
            audioInputStream = AudioSystem.getAudioInputStream(new File(bClick));
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            sfxbClick=(Clip)AudioSystem.getLine(info);
            sfxbClick.open(audioInputStream);               
                
            audioInputStream = AudioSystem.getAudioInputStream(new File(mainTheme));
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            sfxmainTheme=(Clip)AudioSystem.getLine(info);
            sfxmainTheme.open(audioInputStream);
            
            audioInputStream = AudioSystem.getAudioInputStream(new File(orbSel));
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            sfxorbSel=(Clip)AudioSystem.getLine(info);
            sfxorbSel.open(audioInputStream);
            
            audioInputStream = AudioSystem.getAudioInputStream(new File(orbErr));
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            sfxorbErr=(Clip)AudioSystem.getLine(info);
            sfxorbErr.open(audioInputStream);       
            
            audioInputStream = AudioSystem.getAudioInputStream(new File(musicaJuego));
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            sfxmusicaJuego=(Clip)AudioSystem.getLine(info);
            sfxmusicaJuego.open(audioInputStream);
            
            audioInputStream = AudioSystem.getAudioInputStream(new File(atras));
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            sfxatras=(Clip)AudioSystem.getLine(info);
            sfxatras.open(audioInputStream);             
            

        } catch (Exception ex) {
            System.out.println("Error Cargando sonidos: ");
        }
    }
    
}

