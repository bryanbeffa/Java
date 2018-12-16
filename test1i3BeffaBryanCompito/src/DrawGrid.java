
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Classe che serve a disegnare una griglia composta da celle quadrate. Le celle
 * mantengono la dimensione massima consentita e non possono essere di lato
 * superiore a 2 pixel. Se il puntatore del mouse è su una cella della griglia
 * quest'ultima diventa nera.
 *
 * @author Bryan Beffa
 * @version 19.10.2018
 */
public class DrawGrid extends JPanel implements MouseMotionListener {

    /**
     * Attributo che indica la coordinata della cella orizzontale selezionata.
     * Se il valore è -1 significa che il puntatore non si trova su nessuna
     * cella. Valore di defaulf è -1.
     */
    private int xCoordSelected = -1;

    /**
     * Attributo che indica la coordinata della cella verticale selezionata. Se
     * il valore è -1 significa che il puntatore non si trova su nessuna cella.
     * Valore di defaulf è -1.
     */
    private int yCoordSelected = -1;

    /**
     * Attributo che indica il numero di colonne.
     */
    private int cols = 10;

    /**
     * Attributo che indica il numero di righe.
     */
    private int rows = 10;

    /**
     * Attributo che indica la lunghezza del lato di una cella.
     */
    private int squareSide = 10;

    /**
     * Attributo che indica il margine della griglia.
     */
    private int margin = 10;

    /**
     * Metodo costruttore vuoto
     */
    public DrawGrid() {
        this.addMouseMotionListener(this);
    }

    /**
     * Metodo che serve a disegnare la griglia e a centrarla nel panel.
     *
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g) {
        //pulisco lo schermo
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        double marginLeft;
        double marginTop;

        //controllo quale lato è limitante
        if ((getWidth() - getMargin() * 2) / getCols() > (getHeight() - getMargin() * 2) / getRows()) {
            double side = (getHeight() - getMargin() * 2) / getRows();
            setSquareSide((int) side);
        } else {
            double side = (getWidth() - getMargin() * 2) / getCols();
            setSquareSide((int) side);
        }

        marginTop = (getHeight() - getSquareSide() * getRows() - getMargin() * 2) / 2;
        marginLeft = (getWidth() - getSquareSide() * getCols() - getMargin() * 2) / 2;

        //disegno la griglia
        g.setColor(Color.black);
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                g.drawRect(getMargin() + getSquareSide() * j + (int) marginLeft,
                        getMargin() + getSquareSide() * i + (int) marginTop,
                        getSquareSide(),
                        getSquareSide());
            }
        }

        //controllo che il mouse si trova in una posizione dentro la griglia
        if (xCoordSelected >= 0 && yCoordSelected >= 0) {
            g.fillRect((int) marginLeft + xCoordSelected * getSquareSide() + getMargin(),
                    (int) marginTop + yCoordSelected * getSquareSide() + getMargin(),
                    getSquareSide(),
                    getSquareSide());
        }

    }

    /**
     * Metodo getter dell'attributo cols.
     *
     * @return numero di colonne della griglia.
     */
    private int getCols() {
        return this.cols;
    }

    /**
     * Metodo getter dell'attributo margin.
     *
     * @return margine della griglia.
     */
    private int getMargin() {
        return this.margin;
    }

    /**
     * Metodo getter dell'attributo rows.
     *
     * @return numero di righe della griglia.
     */
    private int getRows() {
        return this.rows;
    }

    /**
     * Metodo setter dell'attributo squareSide. Il lato della cella non può
     * essere inferiore a 2 pixel.
     *
     * @param squareSide lunghezza del lato di una cella.
     */
    private void setSquareSide(int squareSide) {
        if (squareSide > 2) {
            this.squareSide = squareSide;
        }
    }

    /**
     * Metodo getter dell'attributo squareSide.
     *
     * @return la lunghezza del lato di una cella.
     */
    private int getSquareSide() {
        return this.squareSide;
    }

    /**
     * Metodo che serve ad aggiungere una colonna.
     */
    public void addCols() {
        this.cols = getCols() + 1;
        repaint();
    }

    /**
     * Metodo che serve a rimuovere una colonna.
     */
    public void removeCols() {
        if ((getCols() - 1) >= 5) {
            this.cols = (getCols() - 1);
            repaint();
        }
    }

    /**
     * Metodo che serve ad aggiungere una riga.
     */
    public void addRows() {
        this.rows = getRows() + 1;
        repaint();
    }

    /**
     * Metodo che serve a rimuovere una riga.
     */
    public void removeRows() {
        if ((getRows() - 1) >= 5) {
            this.rows = (getRows() - 1);
            repaint();
        }
    }

    /**
     * Metodo che serve ad aggiungere 10 pixel al margine. La dimensione del
     * lato di una cella deve rimanere superiore a 2 pixel.
     */
    public void addMargin() {
        double side;
        //controllo quale lato è limitante
        if ((getWidth() - getMargin() * 2) / getCols() > (getHeight() - getMargin() * 2) / getRows()) {
            side = (getHeight() - getMargin() * 2) / getRows();
        } else {
            side = (getWidth() - getMargin() * 2) / getCols();
        }

        //se side è maggiore a due pixel aumento il margine
        if (side > 2) {
            setSquareSide((int) side);
            setMargin(getMargin() + 10);
            repaint();
        }
    }

    /**
     * Metodo che serve a rimuovere 10 pixel al margine.
     */
    public void removeMargin() {
        if (getMargin() - 10 >= 0) {
            setMargin(getMargin() - 10);
            repaint();
        }
    }

    /**
     * Metodo setter dell'attributo margin.
     *
     * @param margin margine della griglia.
     */
    private void setMargin(int margin) {
        this.margin = margin;
    }

    /**
     * Metodo che salva le coordinate delle celle su cui è il mouse dopo
     * l'evento drag e controlla che siano all'interno dell'area della griglia.
     *
     * @param e evento del mouse
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        selectCell(e);

        repaint();
    }

    /**
     * Metodo che salva le coordinate delle celle su cui è il mouse dopo
     * l'evento moved e controlla che siano all'interno dell'area della griglia.
     *
     * @param e evento del mouse
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        selectCell(e);

        repaint();
    }

    /**
     * Metodo che controlla che il puntatore del mouse sia all'interno della
     * griglia sull'asse delle x.
     *
     * @param e evento del mouse
     */
    public void selectedColCell(MouseEvent e) {
        //controllo che la coordinata x sia dentro alla griglia
        int gridWidth = getCols() * getSquareSide();
        double marginLeft = (getWidth() - gridWidth) / 2;
        //controllo che il puntatore del mouse sia all'interno della griglia (asse x)
        if (e.getX() > (int) marginLeft && e.getX() < (int) marginLeft + gridWidth) {
            double column = (e.getX() - marginLeft) / getSquareSide();
            //salvo la coordinata x nell'attributo xCoordSelected
            xCoordSelected = (int) column;
        } else {
            //il puntatore del mouse non si trova all'interno della griglia sull'asse x
            xCoordSelected = -1;
        }
    }

    /**
     * Metodo che controlla che il puntatore del mouse sia all'interno della
     * griglia sull'asse delle y.
     *
     * @param e evento del mouse
     */
    public void selectedRowCell(MouseEvent e) {
        int gridHeight = getRows() * getSquareSide();
        double marginTop = (getHeight() - gridHeight) / 2;
        //controllo che il puntatore del mouse sia all'interno della griglia (asse y)
        if (e.getY() > (int) marginTop && e.getY() < (int) marginTop + gridHeight) {
            double row = (e.getY() - marginTop) / getSquareSide();
            //salvo la coordinata y nell'attributo yCoordSelected
            yCoordSelected = (int) row;
        } else {
            //il puntatore del mouse non si trova all'interno della griglia sull'asse y
            yCoordSelected = -1;
        }
    }

    /**
     * Metodo che salva la cella in cui è posizionato il cursore del mouse.
     *
     * @param e evento del mouse
     */
    public void selectCell(MouseEvent e) {
        selectedColCell(e);
        selectedRowCell(e);
    }
}
