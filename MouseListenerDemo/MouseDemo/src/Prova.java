
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Bryan
 */
public class Prova extends JFrame implements MouseListener {
    private final int MARGIN = 40;
    
    private final int NUM_SQUARE = 5;
    
    private int mouse_x = 0;
    private int mouse_y = 0;
    
    private int[][] coordinate = new int[NUM_SQUARE*NUM_SQUARE][3];
    
    
    /**
     * Metodo costruttore con un parametro che indica il titolo.
     * @param title titolo della finestra
     */
    public Prova(String title){
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }
    
    /**
     * Metodo che disegna un cerchio rosso dove è avvenuto l'ultimo evento del mouse.
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g){
        //disegno il margine
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        int marginTop;
        int marginLeft;
        int latoDisplay;
        
        //controllo quale lato è limitante e disegno il display
        if(getWidth()-MARGIN*2>getHeight()-MARGIN*2){
            latoDisplay = getHeight()-MARGIN*2;
            
        }else{
            latoDisplay = getWidth()-MARGIN*2;
        }

        marginLeft = (getWidth()-latoDisplay)/2;  
        marginTop = (getHeight()-latoDisplay)/2;  
        
        g.setColor(Color.white);
        g.fillRect(marginLeft, marginTop, latoDisplay, latoDisplay);
        
        //disegno i bottoni e li coloro
        g.setColor(Color.red);
        int numSquare = 0;
        for (int i = 0; i < NUM_SQUARE; i++) {
            
            for (int j = 0; j < NUM_SQUARE; j++) {
                //controllo se è stato cliccato il bottone
                if(mouse_x >= marginLeft+j*latoDisplay/NUM_SQUARE &&
                mouse_x <= marginLeft+(j*latoDisplay/NUM_SQUARE)+latoDisplay && 
                mouse_y >= marginTop+i*latoDisplay/NUM_SQUARE &&
                mouse_y <= marginTop+(i*latoDisplay/NUM_SQUARE)+latoDisplay){
                    g.fillRect(marginLeft+j*latoDisplay/NUM_SQUARE, 
                               marginTop+i*latoDisplay/NUM_SQUARE, 
                               latoDisplay/NUM_SQUARE, 
                               latoDisplay/NUM_SQUARE);
                    coordinate[numSquare][0] = marginLeft+j*latoDisplay/NUM_SQUARE;
                    coordinate[numSquare][1] = marginTop+i*latoDisplay/NUM_SQUARE;
                }else{
                    g.drawRect(marginLeft+j*latoDisplay/NUM_SQUARE, 
                               marginTop+i*latoDisplay/NUM_SQUARE, 
                               latoDisplay/NUM_SQUARE, 
                               latoDisplay/NUM_SQUARE);
                    coordinate[numSquare][0] = marginLeft+j*latoDisplay/NUM_SQUARE;
                    coordinate[numSquare][1] = marginTop+i*latoDisplay/NUM_SQUARE;
                    numSquare++;
                }
            }
        }
    }
    
    /**
     * Evento che viene richiamato quando il mouse viene cliccato.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseClicked(MouseEvent e){
        mouse_x = e.getX();
        mouse_y = e.getY();
        repaint();
    }
    
    /**
     * Viene invocato quando il mouse è premuto.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mousePressed(MouseEvent e){
    }
    
    /**
     * Viene invocato quando un tasto del mouse viene rilasciato.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseReleased(MouseEvent e){
    }
    
    /**
     * Viene invocato quando il puntatore del mouse entra nella finestra.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseEntered(MouseEvent e){
    }
    
    /**
     * Viene invocato quando il puntatore del mouse esce dalla finestra.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseExited(MouseEvent e){
    }
    
    public static void main(String[] args) {
       String title = "Prova"; 
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Prova(title).setVisible(true);
            }
        }); 
    }
}
