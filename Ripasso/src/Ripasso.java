
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class Ripasso extends JFrame{
    private final int MARGIN = 40;
    private final int VDEF = 9;
    private final int HDEF = 16;
    private final int VBALL = 4;
    private final int HBALL = 10;
    
    public Ripasso(String title){
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(3<4?"title":"cane");
    }
    
    public void paint(Graphics g){
        g.fillRect(0, 0, getWidth(), getHeight()); 
        
        int margin;
        double width;
        double height;
        //controllo il lato limitante
        if((getWidth()-MARGIN*2)/HDEF > (getHeight()-MARGIN*2)/VDEF){
            width = (getHeight()-MARGIN*2)/VDEF*HDEF;
            height = (getHeight()-MARGIN*2);
        }else{
            width = (getWidth()-MARGIN*2);
            height = (getWidth()-MARGIN*2)/HDEF*VDEF;
        }
        
        double marginLeft = (getWidth() - width)/2;
        double marginTop = (getHeight() - height)/2;
        
        g.setColor(Color.white);
        g.fillRect((int)marginLeft, (int)marginTop, (int)width,(int)height);
        
        int marginBall;
        double radiusBall;
        //controllo il lato limitante
        if(width/HBALL > height/VBALL){
            radiusBall = (height-MARGIN*2)/VBALL;
        }else{
            radiusBall = (width-MARGIN*2)/HBALL;
        }
        
        double marginLeftBall = (getWidth() - radiusBall*HBALL)/2;
        double marginTopBall = (getHeight() - radiusBall*VBALL)/2;
      
        g.setColor(Color.green);
        //disegno le palle
        for(int i = 0; i < VBALL; i++){
            for (int j = 0; j < HBALL; j++) {
                g.fillOval((int)radiusBall*j+(int)marginLeftBall, (int)marginTopBall+(int)radiusBall*i, (int)radiusBall, (int)radiusBall);
            }
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ripasso("Ripasso").setVisible(true);
            }
        });
    }
}
