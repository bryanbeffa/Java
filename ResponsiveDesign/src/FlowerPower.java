
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Classe che disegna su una finestra un fiore.
 * Ridimensionando la finestra il fiore adatta le dimensioni senza perdere
 * le proporzioni.
 *
 * @author Bryan Beffa
 * @version 22.04.2018
 */
public class FlowerPower extends JPanel{
    /**
     * Costante che indica il numero di blocchi orizzontali. 
     */
    private final int HORIZONTAL_BLOCKS = 3;
    
    /**
     * Costante che indica il numero di blocchi verticali
     */
    private final int VERTICAL_BLOCKS = 9;
    
    /**
     * Metodo costruttore con un paramentro.
     * @param title titolo della finestra
     */
    public FlowerPower(){
    }
    
    /**
     * Metodo che disegna la moto.
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        
        //larghezza e altezza della finestra 
        int widthImg = getWidth();
        int heightImg = getHeight();
        
        //pulisco la finestra
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        int dimensionSquare;
        //controllo quale lato è il lato limitante
        if(getWidth()/HORIZONTAL_BLOCKS> getHeight()/VERTICAL_BLOCKS){
            dimensionSquare = (getHeight())/VERTICAL_BLOCKS;
        }else{
            dimensionSquare = getWidth()/HORIZONTAL_BLOCKS;
        }
        
        //centro l'immagine
        int verticalAlign = (heightImg-dimensionSquare*VERTICAL_BLOCKS)/2;
        int horizontalAlign = (widthImg-dimensionSquare*HORIZONTAL_BLOCKS)/2;
        
        //disegno lo sfondo di color cyan
        g.setColor(Color.cyan);
        g.fillRect(horizontalAlign,
                   verticalAlign,
                   dimensionSquare*HORIZONTAL_BLOCKS, 
                   dimensionSquare*VERTICAL_BLOCKS);
        
        //disegno il gambo del fiore
        g.setColor(Color.green);
        g.fillRect(horizontalAlign+dimensionSquare,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare,
                   dimensionSquare*6
        );
        
        //disegno l'erba
        g.fillRect(horizontalAlign,
                   verticalAlign+dimensionSquare*8,
                   dimensionSquare*3,
                   dimensionSquare
        );
        
        //disegno la foglia sinistra
        g.fillOval(horizontalAlign,
                   verticalAlign+dimensionSquare*4,
                   dimensionSquare,
                   dimensionSquare*2
        );
        
        //disegno la foglia destra
        g.fillOval(horizontalAlign+dimensionSquare*2,
                   verticalAlign+dimensionSquare*5,
                   dimensionSquare,
                   dimensionSquare*2
        );
        
        //disegno il cerchio giallo
        g.setColor(Color.yellow);
        g.fillOval(horizontalAlign,
                   verticalAlign+dimensionSquare,
                   dimensionSquare*3, 
                   dimensionSquare*3);
        
        //disegno i petalo nella posizione top
        g.setColor(Color.orange);
        g.fillOval(horizontalAlign+dimensionSquare,
                   verticalAlign+dimensionSquare,
                   dimensionSquare, 
                   dimensionSquare);
        
        //disegno i petalo nella posizione left
        g.fillOval(horizontalAlign,
                   verticalAlign+dimensionSquare*2,
                   dimensionSquare, 
                   dimensionSquare);
        
        //disegno i petalo nella posizione right
        g.fillOval(horizontalAlign+dimensionSquare*2,
                   verticalAlign+dimensionSquare*2,
                   dimensionSquare, 
                   dimensionSquare);
        
        //disegno i petalo nella posizione top
        g.fillOval(horizontalAlign+dimensionSquare,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare, 
                   dimensionSquare);
        
        //disegno il centro del fiore
        g.setColor(Color.white);
        g.fillOval(horizontalAlign+dimensionSquare,
                   verticalAlign+dimensionSquare*2,
                   dimensionSquare, 
                   dimensionSquare);
        
        //disegno la griglia, parte orizzontale
        g.setColor(Color.lightGray);
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
}
