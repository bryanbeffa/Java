
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe che disegna su un JPanel una moto (classe CafeRacer)
 *
 * @author Bryan
 * @version 26.09.2018
 */
public class MyPanel extends JPanel {

    /**
     * Costante che indica il numero di blocchi orizzontali.
     */
    private final int HORIZONTAL_BLOCKS = 27;

    /**
     * Costante che indica il numero di blocchi verticali
     */
    private final int VERTICAL_BLOCKS = 18;

    public MyPanel() {
    }

    /**
     * Metodo che disegna la moto.
     *
     * @param g parametro grafico passato dal sistema operativo.
     */
    @Override
    public void paint(Graphics g) {
        //pulisco la finestra
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        double dimensionSquare;
        //controllo quale lato è il lato limitante
        if (getWidth() / HORIZONTAL_BLOCKS > getHeight() / VERTICAL_BLOCKS) {
            dimensionSquare = (getHeight()) / VERTICAL_BLOCKS;
        } else {
            dimensionSquare = getWidth() / HORIZONTAL_BLOCKS;
        }

        //centro l'immagine
        double verticalAlign = (getHeight() - dimensionSquare * VERTICAL_BLOCKS) / 2;
        double horizontalAlign = (getWidth() - dimensionSquare * HORIZONTAL_BLOCKS) / 2;

        //disegno la prima parte color cyan
        g.setColor(Color.cyan);
        g.fillRect((int) horizontalAlign,
                (int) verticalAlign,
                (int) (dimensionSquare * 27),
                (int) dimensionSquare * 5);

        //disegno la seconda parte color green
        g.setColor(Color.green);
        g.fillRect((int) horizontalAlign,
                (int) verticalAlign + (int) (dimensionSquare * 5),
                (int) (dimensionSquare * 27), (int) (dimensionSquare * 5));

        //disegno la terza parte color grigio chiaro
        g.setColor(Color.lightGray);
        g.fillRect((int) horizontalAlign,
                (int) verticalAlign + (int) (dimensionSquare * 10),
                (int) (dimensionSquare * 27),
                (int) (dimensionSquare * 8));

        //disegno la ruota posteriore
        g.setColor(Color.black);
        g.fillOval((int) horizontalAlign + (int) dimensionSquare,
                (int) verticalAlign + (int) (dimensionSquare * 8),
                (int) (dimensionSquare * 9),
                (int) (dimensionSquare * 9));
        g.setColor(Color.lightGray);
        g.fillOval((int) horizontalAlign + (int) (dimensionSquare * 3),
                (int) verticalAlign + (int) (dimensionSquare * 10),
                (int) (dimensionSquare * 5),
                (int) (dimensionSquare * 5));

        //disegno la ruota anteriore
        g.setColor(Color.black);
        g.fillOval((int) horizontalAlign + (int) (dimensionSquare * 16),
                (int) verticalAlign + (int) (dimensionSquare * 8),
                (int) (dimensionSquare * 9),
                (int) (dimensionSquare * 9));
        g.setColor(Color.lightGray);
        g.fillOval((int) horizontalAlign + (int) (dimensionSquare * 18),
                (int) verticalAlign + (int) (dimensionSquare * 10),
                (int) (dimensionSquare * 5),
                (int) (dimensionSquare * 5));

        //disegno la carena rossa
        g.setColor(Color.red);
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 5),
                (int) verticalAlign + (int) (dimensionSquare * 5),
                (int) (dimensionSquare * 15),
                (int) (dimensionSquare * 1));
        g.fillOval((int) horizontalAlign + (int) (dimensionSquare * 12),
                (int) verticalAlign + (int) (dimensionSquare * 2),
                (int) (dimensionSquare * 9),
                (int) (dimensionSquare * 6));

        //disegno la sella
        g.setColor(Color.black);
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 5),
                (int) verticalAlign + (int) (dimensionSquare * 3), (int) (dimensionSquare * 2),
                (int) (dimensionSquare * 2));
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 5),
                (int) verticalAlign + (int) (dimensionSquare * 4),
                (int) (dimensionSquare * 7),
                (int) dimensionSquare);

        //disegno manubrio
        g.fillOval((int) horizontalAlign + (int) (dimensionSquare * 19),
                (int) verticalAlign + (int) dimensionSquare,
                (int) dimensionSquare,
                (int) dimensionSquare);

        //disegno il telaio grigio
        g.setColor(Color.gray);
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 12),
                (int) verticalAlign + (int) (dimensionSquare * 6),
                (int) (dimensionSquare * 8),
                (int) dimensionSquare * 2);
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 12),
                (int) verticalAlign + (int) (dimensionSquare * 6),
                (int) (dimensionSquare * 3),
                (int) (dimensionSquare * 7));

        //disegno il forcellone posteriore
        g.setColor(Color.yellow);
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 5),
                (int) verticalAlign + (int) (dimensionSquare * 12),
                (int) (dimensionSquare * 8),
                (int) dimensionSquare);

        //disegno il forcellone anteriore
        g.setColor(Color.yellow);
        g.fillRect((int) horizontalAlign + (int) (dimensionSquare * 20),
                (int) verticalAlign + (int) (dimensionSquare * 2),
                (int) dimensionSquare,
                (int) (dimensionSquare * 11));

        //disegno la griglia, parte orizzontale
        g.setColor(Color.white);
        for (int i = 0; i <= VERTICAL_BLOCKS; i++) {
            g.drawLine((int) horizontalAlign,
                    (int) verticalAlign + (int) (dimensionSquare * i),
                    (int) horizontalAlign + (int) (dimensionSquare * HORIZONTAL_BLOCKS),
                    (int) verticalAlign + (int) (dimensionSquare * i));
        }

        //disegno la griglia, parte verticale
        for (int i = 0; i <= HORIZONTAL_BLOCKS; i++) {
            g.drawLine((int) horizontalAlign + (int) (dimensionSquare * i),
                    (int) verticalAlign,
                    (int) horizontalAlign + (int) (dimensionSquare * i),
                    (int) verticalAlign + (int) (dimensionSquare * VERTICAL_BLOCKS));
        }
    }
}
