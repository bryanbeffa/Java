
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
public class SuperCiuc extends JPanel{
    /**
     * Costante che indica il numero di blocchi orizzontali. 
     */
    private final int HORIZONTAL_BLOCKS = 7;
    
    /**
     * Costante che indica il numero di blocchi verticali
     */
    private final int VERTICAL_BLOCKS = 8;
    
    public SuperCiuc(){
    }
    
    /**
     * Metodo che disegna la moto.
     * @param g 
     */
    @Override
    public void paint(Graphics g){  
        //larghezza della finestra togliendo la taskbar
        int widthImg = getWidth();
        int heightImg = getHeight();
        
        //pulisco la finestra
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        int dimensionSquare;
        //controllo quale lato è il lato limitante
        if(getWidth()/HORIZONTAL_BLOCKS > getHeight()/VERTICAL_BLOCKS){
            dimensionSquare = (getHeight())/VERTICAL_BLOCKS;
        }else{
            dimensionSquare = getWidth()/HORIZONTAL_BLOCKS;
        }
        
        //centro l'immagine
        int verticalAlign = (heightImg-dimensionSquare*VERTICAL_BLOCKS)/2;
        int horizontalAlign = (widthImg-dimensionSquare*HORIZONTAL_BLOCKS)/2;
        
        //disegno i capelli
        g.setColor(Color.darkGray);
        for (int i = 1; i < 6; i++) {
            g.fillOval(horizontalAlign+dimensionSquare*i,
                   verticalAlign+dimensionSquare,
                   dimensionSquare, 
                   dimensionSquare*2
                );
        }
        
        //disegno l'orecchio sinistro
        g.setColor(Color.yellow);
        g.fillOval(horizontalAlign,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare*2, 
                   dimensionSquare*2
        );
        
        //disegno l'orecchio destro
        g.fillOval(horizontalAlign+dimensionSquare*5,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare*2, 
                   dimensionSquare*2
        );
        
        //disegno il mento^
        g.fillOval(horizontalAlign+dimensionSquare*3,
                   verticalAlign+dimensionSquare*6,
                   dimensionSquare, 
                   dimensionSquare*2
        );
        
        //disegno la faccia
        g.fillRect(horizontalAlign+dimensionSquare,
                   verticalAlign+dimensionSquare*2,
                   dimensionSquare*5, 
                   dimensionSquare*5
        );
       
        //disegno la bocca
        g.setColor(Color.red);
        g.fillOval(horizontalAlign+dimensionSquare*2,
                   verticalAlign+dimensionSquare*5,
                   dimensionSquare*3, 
                   dimensionSquare*2
        );

        //disegno l'occhio sinistro
        g.setColor(Color.white);
        g.fillOval(horizontalAlign+dimensionSquare*2,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare, 
                   dimensionSquare
        );
        
        //disegno la parte bianca dell'occhio destro
        g.setColor(Color.black);
        g.drawOval(horizontalAlign+dimensionSquare*2,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare, 
                   dimensionSquare
        );

        //disegno l'occhio destro
        g.setColor(Color.white);
        g.fillOval(horizontalAlign+dimensionSquare*4,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare, 
                   dimensionSquare
        );
        
        //disegno la parte bianca dell'occhio destro
        g.setColor(Color.black);
        g.drawOval(horizontalAlign+dimensionSquare*4,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare, 
                   dimensionSquare
        );
        
        //disegno il naso
        g.setColor(Color.orange);
        g.fillOval(horizontalAlign+dimensionSquare*3,
                   verticalAlign+dimensionSquare*3,
                   dimensionSquare, 
                   dimensionSquare*2
        );
        
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

