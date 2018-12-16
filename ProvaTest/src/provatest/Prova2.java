/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatest;

import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

/**
 *
 * @author Bryan
 */
public class Prova2 extends JFrame  {
    private final int MARGIN = 30;
    private final int BORDER = 40;
    
    private int cols = 16;
    private int rows = 9;
    
    public Prova2(int cols, int rows){
        super((cols>0?cols:16)+"x"+(rows>0?rows:9));
        setSize(300, 300);
        setCols(cols);
        setRows(rows);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void setCols(int cols){
        if(cols>0){
            this.cols = cols;
        }
    }
    
    private void setRows(int rows){
        if(rows>0){
            this.rows = rows;
        }
    }
    
    public void paint(Graphics g){
        //pulisco lo schermo
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //disegno il bordo nero
        g.setColor(Color.black);
        g.fillRect(MARGIN, MARGIN, getWidth()-2*MARGIN, getHeight()-2*MARGIN);
        
        //disegno lo schermo utilizzabile
        g.setColor(Color.white);
        g.fillRect(MARGIN+BORDER, MARGIN+BORDER, getWidth()-2*MARGIN-2*BORDER, getHeight()-2*MARGIN-2*BORDER);
        
        double availWidth = getWidth()-2*BORDER-2*MARGIN;
        double availHeight = getHeight()-2*BORDER-2*MARGIN;
        
        int circleRadius;
        int width = (int)availWidth/cols;
        int height = (int)availHeight/rows;
        
        if(width>height){
            circleRadius = height;
        }else{
            circleRadius = width;
        }
        
        int margineLeft = (int)(availWidth - circleRadius * cols) /2;
        int margineTop = (int)(availHeight - circleRadius * rows) / 2;
        
        g.setColor(Color.red);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g.fillOval(margineLeft + MARGIN+BORDER+circleRadius*j, 
                           margineTop+MARGIN+BORDER+circleRadius*i,
                           circleRadius,
                           circleRadius
                           );
            }
        }
    }
    
    public static void main(String[] args) {
        if(args.length == 2){
            try{
                java.awt.EventQueue.invokeLater(new Runnable(){
                    public void run(){
                         new Prova2(Integer.parseInt(args[0]),Integer.parseInt(args[1])).setVisible(true);
                    }
                });
            }catch(NumberFormatException nfe){
            }
        }else{
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new Prova2(2,5).setVisible(true);
                }
            });
        }
    }
}
