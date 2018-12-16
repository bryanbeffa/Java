
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame in cui viene disegnata una matrice di puntini con il metodo smart
 * painting. Frame disegnato con awt.
 *
 * @author Bryan Beffa
 * @version 07.11.2018
 */
public class SmartPaintingFrame extends Frame {

    /**
     * Attributo che indica il disegno in smart painting,
     */
    private SmartPainting smartPainting = new SmartPainting();

    /**
     * Metodo costruttore vuoto.
     */
    public SmartPaintingFrame() {
        setTitle("Smart Painting Frame");
        setSize(500, 500);

        //setto il border layout
        setLayout(new BorderLayout());
        add(smartPainting);
        this.dispose();

        //aggiungo un listener per la chiusura del programma
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartPaintingFrame().setVisible(true);
            }
        });
    }
}
