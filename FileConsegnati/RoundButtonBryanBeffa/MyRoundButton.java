
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Classe che crea un bottone rotondo. Possono essere settate le grandezze, il
 * testo, la posizione e il colore del bottone.
 *
 * @version 14.09.2018
 * @author Bryan
 */
public class MyRoundButton implements MouseMotionListener, MouseListener {

    /**
     * Costante che indica il valore minimo del raggio.
     */
    private final int MIN_RADIUS = 50;

    /**
     * Attributo che indica la coordinata x del bottone. Valore di default
     * posizione 0.
     */
    private int x = 100;

    /**
     * Attributo che indica la coordinata y del bottone. Valore di default
     * posizione 0.
     */
    private int y = 100;

    /**
     * Attributo che indica il raggio del bottone. Valore di default 50 pixel.
     */
    private int radius = 50;

    /**
     * Attributo che indica il testo contenuto nel bottone
     */
    private String text = "";

    /**
     * Attributo che indica il colore del bottone Valore di default rosso.
     */
    private Color color = Color.red;

    /**
     * Lista di RoundButtonListener.
     */
    private List<RoundButtonListener> listeners = new ArrayList();

    /**
     * Metodo getter dell'attributo x.
     *
     * @return il valore dell'attributo x.
     */
    public int getX() {
        return x;
    }

    /**
     * Metodo getter dell'attributo y.
     *
     * @return il valore dell'attributo y.
     */
    public int getY() {
        return y;
    }

    /**
     * Metodo getter dell'attributo radius.
     *
     * @return il valore dell'attributo radius.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Metodo getter dell'attributo color.
     *
     * @return il valore dell'attributo color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Metodo getter dell'attributo text.
     *
     * @return il valore dell'attributo text.
     */
    public String getText() {
        return text;
    }

    /**
     * Metodo che aggiunge il round button listener passato come parametro.
     *
     * @param rbl round button listener da aggiungere.
     */
    public void addRoundButtonListener(RoundButtonListener rbl) {
        listeners.add(rbl);
    }

    /**
     * Metodo che rimuove il il round button listener passato come parametro.
     */
    public void removeRoundButtonListener(RoundButtonListener rbl) {
        listeners.remove(rbl);
    }

    /**
     * Metodo setter dell'attributo x.
     *
     * @param x posizione orizzontale del round button.
     */
    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        }
    }

    /**
     * Metodo setter dell'attributo y.
     *
     * @param y posizione verticale del round button.
     */
    public void setY(int y) {
        if (y >= 0) {
            this.y = y;
        }
    }

    /**
     * Metodo setter dell'attributo radius.
     *
     * @param radius raggio del round button.
     */
    public void setRadius(int radius) {
        if (radius >= MIN_RADIUS) {
            this.radius = radius;
        }
    }

    /**
     * Metodo setter dell'attributo text.
     *
     * @param text testo del round button.
     */
    public void setText(String text) {
        if (text != null && text != "") {
            this.text = text;
        }
    }

    /**
     * Metodo setter dell'attributo text.
     *
     * @param color testo del round button.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Metodo costruttore vuoto. Bottone di deafault.
     */
    public MyRoundButton() {
    }

    /**
     * Metodo costruttore con 5 parametri.
     *
     * @param x posizione del bottone sull'asse orizzontale.
     * @param y posizione del bottone sull'asse verticale.
     * @param radius raggio del bottone.
     * @param text testo del bottone.
     * @param color colore del bottone.
     */
    public MyRoundButton(int x, int y, int radius, String text, Color color) {
        setX(x);
        setY(y);
        setRadius(radius);
        setText(text);
        setColor(color);
    }

    /**
     * Metodo che ritorna se il puntatore del mouse è posto sulla superficie del
     * bottone.
     *
     * @param p punto contenente le coordinate del mouse.
     * @return se il bottone contiene il puntatore del mouse.
     */
    public boolean contains(Point p) {
        int centreX = getX() + getRadius();
        int centreY = getY() + getRadius();
        Point centre = new Point(centreX, centreY);
        if (p.distance(centre) <= getRadius()) {
            return true;
        }
        return false;
    }

    /**
     * Evento che viene richiamato quando il mouse viene cliccato.
     *
     * @param e evento del mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (contains(e.getPoint())) {
            for (RoundButtonListener rbl : listeners) {
                rbl.roundButtonClicked(this);
            }
        }
    }

    /**
     * Viene invocato quando il mouse è premuto.
     *
     * @param e evento del mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (contains(e.getPoint())) {
            for (RoundButtonListener rbl : listeners) {
                rbl.roundButtonPressed(this);
            }
        }
    }

    /**
     * Viene invocato quando un tasto del mouse viene rilasciato.
     *
     * @param e evento del mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (contains(e.getPoint())) {
            for (RoundButtonListener rbl : listeners) {
                rbl.roundButtonReleased(this);
            }
        }
    }

    /**
     * Viene invocato quando il mouse entra nella finestra.
     *
     * @param e evento del mouse.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Viene invocato quando il mouse esce nella finestra.
     *
     * @param e evento del mouse.
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Viene invocato quando il puntatore del mouse si muove.
     *
     * @param e evento del mouse.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        if (contains(e.getPoint())) {
            for (RoundButtonListener rbl : listeners) {
                rbl.roundButtonOver(this);
            }
        }
    }

    /**
     * Viene invocato quando il puntatore del mouse viene trascinato..
     *
     * @param e evento del mouse.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (contains(e.getPoint())) {
            for (RoundButtonListener rbl : listeners) {
                rbl.roundButtonOver(this);
            }
        }
    }

    /**
     * Metodo che disegna il bottone, centra il label. Colore inoltre il
     * background del bottone.
     *
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g) {
        //disegno il button
        g.setColor(getColor());
        g.fillOval(getX(),
                getY(),
                getRadius() * 2,
                getRadius() * 2);

        //disegno il button
        g.setColor(Color.black);
        g.drawOval(getX(),
                getY(),
                getRadius() * 2,
                getRadius() * 2);

        //setto il testo
        Font font = new Font("MyFont", 1, 12);
        FontMetrics fm = g.getFontMetrics(font);
        int width = fm.stringWidth(getText());
        int size = font.getSize();
        g.drawString(getText(),
                getX() + (getRadius() * 2 - width) / 2,
                getY() + getRadius());
    }
}
