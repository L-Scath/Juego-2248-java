package Juego;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Luis Jose Uzcategui Ramirez y Yeferson Saul Perez Ostos
 */
/**JLabel Preparado para hacer la funcion de Reloj mostrando minutos y segundos transcurridos*/
public class Reloj extends JLabel{  
    int minDec;
    int minUnit;
    int secDec;
    int secUnit;
    Timer timerReloj;
/**constructor de la clase "Reloj", inicializa todos sus atributos */
    public Reloj() {
        super("00:00");
        minDec = 0;
        minUnit = 0;
        secDec = 0;
        secUnit = 0;        
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        IniciarReloj();
    }
    
    public int getMinDec() {
        return minDec;
    }
    public int getMinUnit() {
        return minUnit;
    }
    public int getSecDec() {
        return secDec;
    }
    public int getSecUnit() {
        return secUnit;
    }  
    
    public void setMinDec(int minDec) {
        this.minDec = minDec;
    }
    public void setMinUnit(int minUnit) {
        this.minUnit = minUnit;
    }
    public void setSecDec(int secDec) {
        this.secDec = secDec;
    }
    public void setSecUnit(int secUnit) {
        this.secUnit = secUnit;
    }    
    
    public void IniciarReloj(){
        timerReloj= new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secUnit++;
                if (secUnit==10) {
                    secDec++;
                    secUnit=0;
                }
                if (secDec==6) {
                    minUnit++;
                    secDec=0;
                }
                if (minUnit==10) {
                    minDec++;
                    minUnit=0;                            
                }
                setText(Integer.toString(minDec)+""+Integer.toString(minUnit)+":"+""+Integer.toString(secDec)+""+Integer.toString(secUnit));
            }
        });
    }
    public void PararReloj(){
        timerReloj.stop();
    }
    public void limpiarReloj(){
        minDec = 0;
        minUnit = 0;
        secDec = 0;
        secUnit = 0;
    }
}
