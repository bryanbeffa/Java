import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Classe che disegna su una finestra una moto.
 * Ridimensionando la finestra la moto adatta la dimensione senza perdere
 * le proporzioni.
 *
 * @author Bryan Beffa
 * @version 17.04.2018
 */
public class CafeRacer extends JFrame{
    /**
     * Costante che indica il numero di blocchi orizzontali. 
     */
    private final int HORIZONTAL_BLOCKS = 27;
    
    /**
     * Costante che indica il numero di blocchi verticali
     */
    private final int VERTICAL_BLOCKS = 18;
    
    /**
     * Metodo costruttore con un paramentro.
     * @param title titolo della finestra
     */
    public CafeRacer(String title){
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Metodo che disegna la moto.
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        //altezza della taskbar
        int taskBar = 15;
        
        //larghezza della finestra togliendo la taskbar
        int widthImg = getWidth();
        int heightImg = getHeight();
        
        //pulisco la finestra
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        int dimensionSquare;
        //controllo quale lato è il lato limitante
        if(getWidth()/HORIZONTAL_BLOCKS> getHeight()/VERTICAL_BLOCKS){
            dimensionSquare = (getHeight()-taskBar)/VERTICAL_BLOCKS;
        }else{
            dimensionSquare = getWidth()/HORIZONTAL_BLOCKS;
        }
        
        //centro l'immagine
        int verticalAlign = (heightImg-dimensionSquare*VERTICAL_BLOCKS)/2+taskBar;
        int horizontalAlign = (widthImg-dimensionSquare*HORIZONTAL_BLOCKS)/2;
        
        //disegno la prima parte color cyan
        g.setColor(Color.cyan);
        g.fillRect(horizontalAlign,verticalAlign,dimensionSquare*27, dimensionSquare*5);
        
        //disegno la seconda parte color green
        g.setColor(Color.green);
        g.fillRect(horizontalAlign,verticalAlign+dimensionSquare*5,dimensionSquare*27, dimensionSquare*5);
        
        //disegno la terza parte color grigio chiaro
        g.setColor(Color.lightGray);
        g.fillRect(horizontalAlign,verticalAlign+dimensionSquare*10,dimensionSquare*27, dimensionSquare*8);
        
        //disegno la ruota posteriore
        g.setColor(Color.black);
        g.fillOval(horizontalAlign+dimensionSquare ,verticalAlign+dimensionSquare*8, dimensionSquare*9, dimensionSquare*9);
        g.setColor(Color.lightGray);
        g.fillOval(horizontalAlign+dimensionSquare*3, verticalAlign+dimensionSquare*10, dimensionSquare*5, dimensionSquare*5);
        
        //disegno la ruota anteriore
        g.setColor(Color.black);
        g.fillOval(horizontalAlign+dimensionSquare*16 ,verticalAlign+dimensionSquare*8, dimensionSquare*9, dimensionSquare*9);
        g.setColor(Color.lightGray);
        g.fillOval(horizontalAlign+dimensionSquare*18, verticalAlign+dimensionSquare*10, dimensionSquare*5, dimensionSquare*5);
        
        //disegno la carena rossa
        g.setColor(Color.red);
        g.fillRect(horizontalAlign+dimensionSquare*5, verticalAlign+dimensionSquare*5, dimensionSquare*15, dimensionSquare*1);
        g.fillOval(horizontalAlign+dimensionSquare*12, verticalAlign+dimensionSquare*2, dimensionSquare*9, dimensionSquare*6);
        
        //disegno la sella
        g.setColor(Color.black);
        g.fillRect(horizontalAlign+dimensionSquare*5, verticalAlign+dimensionSquare*3, dimensionSquare*2, dimensionSquare*2);
        g.fillRect(horizontalAlign+dimensionSquare*5, verticalAlign+dimensionSquare*4, dimensionSquare*7, dimensionSquare);
        
        //disegno manubrio
        g.fillOval(horizontalAlign+dimensionSquare*19, verticalAlign+dimensionSquare, dimensionSquare, dimensionSquare);
        
        //disegno il telaio grigio
        g.setColor(Color.gray);
        g.fillRect(horizontalAlign+dimensionSquare*12, verticalAlign+dimensionSquare*6, dimensionSquare*8, dimensionSquare*2);
        g.fillRect(horizontalAlign+dimensionSquare*12, verticalAlign+dimensionSquare*6, dimensionSquare*3, dimensionSquare*7);
        
        //disegno il forcellone posteriore
        g.setColor(Color.yellow);
        g.fillRect(horizontalAlign+dimensionSquare*5, verticalAlign+dimensionSquare*12, dimensionSquare*8, dimensionSquare);
        
        //disegno il forcellone anteriore
        g.setColor(Color.yellow);
        g.fillRect(horizontalAlign+dimensionSquare*20, verticalAlign+dimensionSquare*2, dimensionSquare*1, dimensionSquare*11);
        
        //disegno la griglia, parte orizzontale
        g.setColor(Color.white);
        for (int i = 0; i <= VERTICAL_BLOCKS; i++) {
            g.drawLine(horizontalAlign,
                       verticalAlign+dimensionSquare*i,
                       horizontalAlign+dimensionSquare*HORIZONTAL_BLOCKS,
                       verticalAlign+dimensionSquare*i
            );
        }
        
        //disegno la griglia, parte verticale
        for (int i = 0; i <= HORIZONTAL_BLOCKS; i++) {
            g.drawLine(horizontalAlign+dimensionSquare*i,
                       verticalAlign,
                       horizontalAlign+dimensionSquare*i,
                       verticalAlign+dimensionSquare*VERTICAL_BLOCKS
            );
        }
    }
    
    public static void main(String[] args) {
        String title = "Cafe Racer"; 
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new CafeRacer(title).setVisible(true);
            }
        });
    }
}
