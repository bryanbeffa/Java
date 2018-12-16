
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Classe che definisce un triangolo. Possiede metodi basilari che permettono di
 * gestire il triangolo.
 *
 * @author Bryan Beffa
 * @version 1.10.2018
 */
public class MyTrianglePanel extends JPanel {

    /**
     * Costante che indica il numero di pixel di spostamento
     */
    private final int STEP = 10;

    /**
     * Attributo che indica la lunghezza del lato del triangolo in pixel. Valore
     * di default 50.
     */
    private int triangleSide = 50;

    /**
     * Array di interi che indica le coordinate x dei 3 vertici del triangolo.
     */
    private int[] xPoints;

    /**
     * Array di interi che indica le coordinate y dei 3 vertici del triangolo.
     */
    private int[] yPoints;

    /**
     * Attributo che indica la coordinata x del vertice sinistro. Valore di
     */
    private int leftXCoord;

    /**
     * Attributo che indica la coordinata y del vertice in alto. Valore di
     */
    private int topYCoord;

    /**
     * Attributo che indica il colore del background del triangolo.
     */
    private Color color = Color.black;

    /**
     * Metodo setter dell'attributo triangleSide.
     *
     * @param triangleSide lunghezza del lato del triangolo.
     */
    public void setTriangleSide(int triangleSide) {
        if (triangleSide > 0) {
            this.triangleSide = triangleSide;
        }
    }

    /**
     * Metodo setter dell'array che indicano le coordinate x dei vertici del
     * triangolo. In base alla coordinata iniziale calcola le coordinate x degli
     * altri vertici.
     *
     * @param xLeftStartCoord coordinata x del vertice più asinistra.
     */
    public void setXPoints(int xLeftStartCoord) {
        int[] xPoints = new int[3];
        double xDistancePoint = getTriangleSide() / 2.0;
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] = xLeftStartCoord + (int) (xDistancePoint * i);
        }

        this.xPoints = xPoints;
        setLeftXCoord(xLeftStartCoord);
    }

    /**
     * Metodo setter dell'array che indica le coordinate y dei vertici del
     * triangolo. In base alla coordinata iniziale calcola le coordinate y degli
     * altri vertici.
     *
     * @param yTopStartCoord coordinata y del vertice in alto .
     */
    public void setYPoints(int yTopStartCoord) {
        int[] yPoints = new int[3];
        double yDistancePoint = getTriangleSide() * (Math.sqrt(3) / 2);
        yPoints[0] = yTopStartCoord + (int) (yDistancePoint);
        yPoints[1] = yTopStartCoord;
        yPoints[2] = yTopStartCoord + (int) (yDistancePoint);

        this.yPoints = yPoints;
        setTopYCoord(yTopStartCoord);
    }

    /**
     * Metodo setter dell'attributo leftXCoord.
     *
     * @param leftXCoord coordinata x del vertice più a sinistra del triangolo.
     */
    public void setLeftXCoord(int leftXCoord) {
        this.leftXCoord = leftXCoord;
    }

    /**
     * Metodo setter dell'attributo topYCoord.
     *
     * @param topYCoord coordinata y del vertice in alto del triangolo.
     */
    public void setTopYCoord(int topYCoord) {
        this.topYCoord = topYCoord;
    }

    /**
     * Metodo setter dell'attributo color.
     *
     * @param color colore del background del triangolo.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Metodo getter dell'attributo triangleSide.
     *
     * @return lunghezza del lato del triangolo.
     */
    public int getTriangleSide() {
        return this.triangleSide;
    }

    /**
     * Metodo getter dell'attributo leftXCoord.
     *
     * @return coordinata x del vertice più a sinistra del triangolo.
     */
    public int getLeftXCoord() {
        return this.leftXCoord;
    }

    /**
     * Metodo getter dell'attributo topYCoord.
     *
     * @return coordinata x del vertice più a sinistra del triangolo.
     */
    public int getTopYCoord() {
        return this.topYCoord;
    }

    /**
     * Metodo getter dell'attributo xPoints.
     *
     * @return array contenente le coordinate x dei vertici del triangol.
     */
    public int[] getXPoints() {
        return this.xPoints;
    }

    /**
     * Metodo getter dell'attributo yPoints.
     *
     * @return array contenente le coordinate y dei vertici del triangol.
     */
    public int[] getYPoints() {
        return this.yPoints;
    }

    /**
     * Metodo getter dell'attributo color.
     *
     * @return colore del background del triangolo.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Metodo costruttore vuoto.
     */
    public MyTrianglePanel() {
        setXPoints(leftXCoord);
        setYPoints(topYCoord);
    }

    /**
     * Metodo che modifica la posizione del triangolo.
     *
     * @param xDistance spostamento orizzontale in pixel.
     * @param yDistance spostamento verticale in pixel.
     */
    public void moveTriangle(int xDistance, int yDistance) {
        //controllo se il triangolo spostandosi orizzontalmente non esce ai lati
        if ((getLeftXCoord() + xDistance) >= 0 && (getLeftXCoord() + getTriangleWidth() + xDistance) <= getWidth()) {
            //setto i nuovi vertici del triangolo
            setXPoints(getLeftXCoord() + xDistance);
        }

        //controllo se il triangolo spostandosi verticalmente non esce ai lati
        if ((getTopYCoord() + yDistance) >= 0 && (getTopYCoord() + getTriangleHeight() + yDistance) <= getHeight()) {
            setYPoints(getTopYCoord() + yDistance);
        }

        repaint();
    }

    /**
     * Metodo che serve a muovere il triangolo verso l'alto senza uscire dal
     * lato.
     */
    public void moveToTop() {
        if ((getTopYCoord() - STEP) >= 0) {
            setYPoints(getTopYCoord() - STEP);
        }

        repaint();
    }

    /**
     * Metodo che serve a muovere il triangolo verso il basso senza uscire dal
     * lato.
     */
    public void moveToBottom() {
        if ((getTopYCoord() + getTriangleHeight() + STEP) <= getHeight()) {
            setYPoints(getTopYCoord() + STEP);
        }

        repaint();
    }

    /**
     * Metodo che serve a muovere il triangolo verso sinistra senza uscire dal
     * lato.
     */
    public void moveToLeft() {
        if ((getLeftXCoord() - STEP) >= 0) {
            setXPoints(getLeftXCoord() - STEP);
        }

        repaint();
    }

    /**
     * Metodo che serve a muovere il triangolo verso destra senza uscire dal
     * lato.
     */
    public void moveToRight() {
        if ((getLeftXCoord() + getTriangleWidth() + STEP) <= getWidth()) {
            setXPoints(getLeftXCoord() + STEP);
        }

        repaint();
    }

    /**
     * Metodo che calcola l'altezza del triangolo.
     *
     * @return altezza del triangolo.
     */
    public int getTriangleHeight() {
        return (int) (getTriangleSide() * (Math.sqrt(3) / 2));
    }

    /**
     * Metodo che ritorna la larghezza del triangolo.
     *
     * @return larghezza del triangolo.
     */
    public int getTriangleWidth() {
        return getTriangleSide();
    }

    /**
     * Metodo che serve a centrare il triangolo nel panel.
     */
    public void center() {
        //centro orizzontalmente il triangolo
        double centerX = (getWidth() - getTriangleWidth()) / 2;
        setXPoints((int) centerX);

        //centro il triangolo verticalmente
        double centerY = (getHeight() - getTriangleHeight()) / 2;
        setYPoints((int) centerY);
    }

    /**
     * Metodo che disegna il triangolo nel panel.
     *
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g) {
        //pulisco lo schermo
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        //setto il colore nero
        g.setColor(Color.black);
        //disegno il triangolo
        g.setColor(getColor());
        g.fillPolygon(getXPoints(), getYPoints(), 3);
        g.setColor(Color.black);
        g.drawPolygon(getXPoints(), getYPoints(), 3);
    }
}
