/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tap_u3_ejemplo7_loteria;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Leo Pereida
 */
public class Loteria extends Thread {
    Ventana v;
    boolean running = true;
    

    public Loteria(Ventana v) {
        this.v = v;
    }
    
    public void run(){
        while(true){
            try {
                sleep(750);
            } catch (InterruptedException ex) {
                Logger.getLogger(Loteria.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(running){ // el juego inicia pausado para barajar las cartas
                v.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("Loteria//"+
                        (v.fila[v.turno])+".png")) );
                v.turno++;
                if(v.turno>=54){
                    running = false;
                }
            }
        }
    }
    
    public void pausar(){
        running = false;
    }
    
    public void reanudar(){
        running = true;
    }
    
    public boolean estaPausado(){
        return running;
    }
    
}
