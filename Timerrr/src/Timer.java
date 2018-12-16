
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class Timer extends Thread{
    
    private ArrayList<TimerListener> listeners = new ArrayList();
    
    public Timer(int x, int y){
        listeners.addTimerListener();
    }
    
    public void addTimerListener(TimerListener listener){
        
    }
    
    public void removeTimerListener(TimerListener listener){
        
    }
    
    public void paint(Graphics g){
        
    }
    
    public void run(){
        
    }
}
