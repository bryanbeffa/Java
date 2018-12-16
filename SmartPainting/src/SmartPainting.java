
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe che disegna una matrice di pallini. Con l'utilizzo dello smart
 * painting quando un pallino viene cliccato si colora di rosso. Solo un pallino
 * può essere acceso.
 *
 * @author Bryan Beffa
 * @version 07.11.2018
 */
public class SmartPainting extends Panel implements MouseListener {

    /**
     * Attributo che indica il numero di righe.
     */
    private int rows;

    /**
     * Attributo che indica il numero di colonne.
     */
    private int cols;

    /**
     * Attributo che indica il diametro di un pallino.
     */
    private final int SIZE = 20;

    /**
     * Attributo che indica il pallino da ripristinare allo stato originale.
     */
    private Point oldPoint = new Point(0, 0);
    
    /**
     * Attributo che indica il pallino selezionato.
     */
    private Point newPoint;

    /**
     * Metodo costruttore vuoto.
     */
    public SmartPainting() {
        this.addMouseListener(this);
        
        newPoint = new Point(getWidth()/SIZE, getHeight()/SIZE);
    }

    /**
     * Metodo che disegna una matrice di pallini. Se selezionato un pallino
     * quest'ultimo viene colorato di rosso
     *
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g) {
        long start = System.nanoTime();
        
        //disegno lo sfondo
        g.setColor(Color.blue);
        g.fillRect(g.getClipBounds().x, g.getClipBounds().y, g.getClipBounds().width, g.getClipBounds().height);
        
        int deltaX = Math.abs(newPoint.x - oldPoint.x);
        int deltaY = Math.abs(newPoint.y - oldPoint.y);
        
        //System.out.println("newPoint x: " + newPoint.x*SIZE);
        //System.out.println("newPoint y: " + newPoint.y*SIZE);
        
        //System.out.println("oldPoint x: " + oldPoint.x*SIZE);
        //System.out.println("oldPoint y: " + oldPoint.y*SIZE);
        
        //System.out.println("delta x: " + deltaX);

        //disegno la matrice di pallini
        g.setColor(Color.red);
        //for (int i = 0; i < deltaX; i++) {
          //  for (int j = 0; j < deltaY; j++) {
                g.fillOval(newPoint.x*SIZE, newPoint.y*SIZE, SIZE, SIZE);
                //System.out.println("x: " + i + " y: " + j);
            //}
        //}
        
        oldPoint = newPoint;
        
        long end = System.nanoTime();
        System.out.println("Tempo in nanosecondi: " + (end - start));
    }

    /**
     * Metodo che ritorna le coordinate del punto selezionato.
     *
     * @param e evento del mouse
     * @return coordinate punto selezionato
     */
    private void selectedOval(MouseEvent e) {
        double col = e.getX() / SIZE;
        double row = e.getY() / SIZE;

        newPoint = new Point((int) col, (int) row);
    }

    /**
     * Metodo che al click del mouse passa come parametri al metodo repaint la
     * clipping area.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        selectedOval(e);
        repaint(newPoint.x * SIZE, newPoint.y * SIZE, SIZE, SIZE);
        repaint(oldPoint.x * SIZE, oldPoint.y *SIZE, SIZE, SIZE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
