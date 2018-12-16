import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 * Classe che disegna all'interno di un frame un cerchio rosso nell'ultimo punto
 * in cui è avvenuto un evento del mouse.
 * Il colore del cerchio varia in base all'evento.
 * @author Bryan 
 * @version 04.05.2018
 */
public class MouseMotionDemo extends JFrame implements MouseMotionListener {
    
    /**
     * Array di colori utilizzati per disegnare il cerchio.
     */
    private final Color[] COLORS = {Color.red, 
                                    Color.yellow, 
                                    Color.green, 
                                    Color.blue,
                                    Color.orange,
                                    Color.magenta,
                                    Color.cyan
    };
    /**
     * Costante che indica le dimensioni del cerchio.
     */
    private final int radius = 30; 
    
    /**
     * Attributo che indica la posizione orizzontale del mouse
     */
    private int x;
    
    /**
     * Attributo che indica la posizione verticale del mouse.
     */
    private int y;
    
    /**
     * Attributo che indica l'indice del colore colore.
     * Varia in base all'evento del mouse scatenato.
     */
    private int colorIndex;
    
    /**
     * Attributo che indica se cancellare o meno il frame.
     */
    private boolean cleanFrame = false;
    
    /**
     * Metodo costruttore con un parametro che indica il titolo.
     * @param title titolo della finestra
     */
    public MouseMotionDemo(String title){
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(this);
    }
    
    
    /**
     * Metodo che disegna un cerchio rosso dove è avvenuto l'ultimo evento del mouse.
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g){
        g.setColor(COLORS[colorIndex]);
        g.fillOval(x-radius/2, y-radius/2, radius, radius);
    }
    
    /**
     * Evento che viene richiamato quando il mouse viene cliccato.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseClicked(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 0;
        repaint();
    }
    
    /**
     * Viene invocato quando il mouse è premuto.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 1;
        repaint();
    }
    
    /**
     * Viene invocato quando un tasto del mouse viene rilasciato.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseReleased(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 2;
        repaint();
    }
    
    /**
     * Viene invocato quando il puntatore del mouse entra nella finestra.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseEntered(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 3;
        repaint();
    }
    
    /**
     * Viene invocato quando il puntatore del mouse esce dalla finestra.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseExited(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 4;
        repaint();
    }
    
    /**
     * Viene invocato quando il puntatore del mouse entra nella finestra.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseDragged(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 5;
        repaint();
    }
    
    /**
     * Viene invocato quando il puntatore del mouse esce dalla finestra.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    public void mouseMoved(MouseEvent e){
        x = e.getX();
        y = e.getY();
        colorIndex = 6;
        repaint();
    }
    
    
    public static void main(String[] args) {
       String title = "Mouse Motion Demo"; 
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new MouseMotionDemo(title).setVisible(true);
            }
        }); 
    }
}
