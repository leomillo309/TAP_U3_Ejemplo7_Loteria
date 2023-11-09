/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tap_u3_ejemplo7_loteria;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo Pereida
 */
public class Barajar extends Thread {
    Ventana v;
    boolean barajar = false;
    int i = 0, n;
    Random r = new Random();
    

    public Barajar(Ventana v) {
        this.v = v;
    }
    
    public void run(){
        while(true){
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Loteria.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(barajar){  //este solo debe ejcutarse para cambiar el orden de las cartas y luego esperar a que vuelva a nesecitarse
                v.turno=0;
                while(i<v.fila.length){
                    n = r.nextInt(54)+1;
                    if(!busqueda(v.fila, n, i)){
                        v.fila[i] = n;
                        i++;
                    }
                }
                v.setTitle("Loteria Barajada");
                barajar = false;
            }
            
        }
    }
    
    public static boolean busqueda(int[] A, int n, int i){
        int j;
        
        for(j=0;j<i;j++){
            if(n == A[j]){
                return true;
            }
        }
        return false;
    }
    
    public void barajar(boolean barajar){
        this.barajar = barajar;
    }
    
    
}
