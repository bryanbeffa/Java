
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Classe che serve a disegnare una matrice di pallini verdi. Quando il
 * puntatore del mouse si muove il pallino su cui e posizionato si colora di
 * rosso. Solo un pallino alla volta può essere colorato di rosso. Viene
 * utilizzata la tecnica del bouble buffering.
 *
 * @author Bryan Beffa
 * @version 08.11.2018
 */
public class DoubleBuffering extends JPanel implements MouseMotionListener {

    /**
     * Attributo che indica il diametro di un pallino.
     */
    private final int SIZE = 20;

    /**
     * Attributo che indica il numero di righe.
     */
    private int rows;

    /**
     * Attributo che indica il numero di colonne.
     */
    private int cols;

    /**
     * Attributo che indica il punto selezionato.
     */
    private Point selectedPoint = new Point(0, 0);

    /**
     * Metodo costrruttore vuoto.
     */
    public DoubleBuffering() {
        this.addMouseMotionListener(this);
    }

    /**
     * Metodo che calcola il numero di righe e di colonne del frame.
     */
    private void calculate() {
        rows = (int) getHeight() / SIZE;
        cols = (int) getWidth() / SIZE;
    }

    /**
     * Metodo utilizzato per disegnare la matrice di pallini e colorare l'ultimo
     * selezionato
     *
     * @param g parametro grafico passato dal sistema operativo
     */
    @Override
    public void paintComponent(Graphics g) {
        //cancello lo sfondo
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.green);

        //calcolo le righe e le colonne
        calculate();

        //disegno la griglia di quadretti
        for (int i = 0; i <= cols; i++) {
            for (int j = 0; j <= rows; j++) {
                g.fillOval(i * SIZE,
                        j * SIZE,
                        SIZE,
                        SIZE);
            }
        }

        //disegno il punto selezionato
        g.setColor(Color.red);
        g.fillOval(selectedPoint.x * SIZE, selectedPoint.y * SIZE, SIZE, SIZE);
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

        selectedPoint = new Point((int) col, (int) row);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        selectedOval(e);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        selectedOval(e);
        repaint();
    }
}
