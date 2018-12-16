/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Bryan
 */
public class ProvaTest extends JFrame{
    
    int BORDER_WIDTH = 30;
    int MARGIN = 50;
    
    private int cols = 16;
    private int rows = 9;

    public void setCols(int cols) {
        if(cols > 0){
            this.cols = cols;
        }
    }

    public void setRows(int rows) {
        if(rows>0){        
            this.rows = rows;
        }
    }
    
    
    
    public ProvaTest(int cols,int rows){
        super( (cols<0?16:cols) +"x"+(rows<0?9:rows));
        setCols(cols);
        setRows(rows);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        //pulisco lo schermo
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(),this.getHeight());
        
        //disegno il bordo nero
        g.setColor(Color.BLACK);
        g.fillRect(MARGIN, MARGIN, this.getWidth()-MARGIN*2,this.getHeight()-MARGIN*2);
        
        //disegno lo schermo bianco
        g.setColor(Color.WHITE);
        g.fillRect(MARGIN+BORDER_WIDTH, MARGIN+BORDER_WIDTH, this.getWidth()-MARGIN*2-BORDER_WIDTH*2, this.getHeight()-MARGIN*2-BORDER_WIDTH*2);
        
        double usableWidth = this.getWidth()-MARGIN*2-BORDER_WIDTH*2;
        double usableHeight = this.getHeight()-MARGIN*2-BORDER_WIDTH*2;
        
        int lato;
        int lato1 = (int)usableWidth / cols;
        int lato2 = (int)usableHeight / rows;
        if(lato1 > lato2)
            lato = lato2;
        else 
            lato = lato1;
        
        int margineSinistro = (int)(usableWidth - lato * cols) /2;
        int margineTop = (int)(usableHeight - lato * rows) / 2;
        
        
        
        g.setColor(Color.RED);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                g.fillOval(margineSinistro + MARGIN + BORDER_WIDTH + lato * i,margineTop + MARGIN + BORDER_WIDTH + lato * j, lato, lato);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length == 2){
            try {
                java.awt.EventQueue.invokeLater(new Runnable(){
                    public void run(){
                        new ProvaTest(Integer.parseInt(args[0]),Integer.parseInt(args[1])).setVisible(true);
                    }
                });
            } catch (Exception e) {
            }
        }else{
            String title = "Cafe Racer"; 
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new ProvaTest(10,10).setVisible(true);
                }
            });
        }
    }
}
