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
public class RectangleProva extends JFrame{
    /**
     *
     */
    public RectangleProva(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
    }
    
    @Override
    public void paint(Graphics g){
        g.draw3DRect(100, 100, 200, 200, false);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new RectangleProva("Window").setVisible(true);
            }
        });
    }
}
