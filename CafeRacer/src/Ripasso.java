import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Bryan
 */
public class Ripasso extends JFrame{
    /**
     * 
     */
    private final int ROWS_BLOCKS = 8;
    
    /**
     * 
     */
    private final int COLS_BLOCKS = 10;
    
    public Ripasso(String titolo){
        super(titolo);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //salvo la dimensione massima di un blocco
        int dimensionSquare;
        if(getWidth()/COLS_BLOCKS > getHeight()/ROWS_BLOCKS){
            dimensionSquare = getHeight()/ROWS_BLOCKS;
        }else{
            dimensionSquare = getWidth()/COLS_BLOCKS;
        }
        
        //calcolo il margine superiore
        int marginTop = (getHeight()-ROWS_BLOCKS*dimensionSquare)/2;
        
        //calcolo il margine sinistro
        int marginLeft = (getWidth()-COLS_BLOCKS*dimensionSquare)/2;
        
        //disegno il cielo
        g.setColor(Color.CYAN);
        g.fillRect(marginLeft, 
                   marginTop, 
                   dimensionSquare*COLS_BLOCKS,
                   5*dimensionSquare); 
        
        //disegno l'asfalto
        g.setColor(Color.GRAY);
        g.fillRect(marginLeft, 
                   marginTop+5*dimensionSquare, 
                   dimensionSquare*COLS_BLOCKS,
                   dimensionSquare); 
        
        //disegno l'erba
        g.setColor(Color.GREEN);
        g.fillRect(marginLeft, 
                   marginTop+6*dimensionSquare, 
                   dimensionSquare*COLS_BLOCKS,
                   2*dimensionSquare);
        
        g.setColor(Color.WHITE);
        
        //disegno la parte orizzontale della griglia
        for(int i=0; i<=ROWS_BLOCKS; i++){
            g.drawLine(marginLeft, 
                       marginTop+dimensionSquare*i, 
                       marginLeft+COLS_BLOCKS*dimensionSquare, 
                       marginTop+dimensionSquare*i);
        }
        
        //disegno la parte verticale della griglia
        for(int i=0; i<=COLS_BLOCKS; i++){
            g.drawLine(marginLeft+dimensionSquare*i, 
                       marginTop, 
                       marginLeft+dimensionSquare*i, 
                       marginTop+ROWS_BLOCKS*dimensionSquare);
        }
    }
    
    public static void main(String[] args) {
        String titolo = "Ripasso Seconda";
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Ripasso(titolo).setVisible(true);
            }
        });
    }
}
