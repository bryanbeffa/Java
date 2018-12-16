
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Classe che serve a provare gli eventi di un round button. Quando si posiziona
 * il mouse su un round button, si clicca, mantiene premuto o si rilascia viene
 * stampato a terminale
 *
 * @version 14.09.2018
 * @author Bryan
 */
public class MyRBApp extends JFrame implements RoundButtonListener {

    /**
     * Attributo che indica il round button numero 1.
     */
    private MyRoundButton rb1 = new MyRoundButton();

    /**
     * Attributo che indica il round button numero 2.
     */
    private MyRoundButton rb2 = new MyRoundButton(300, 300, 60, "Click me please!", Color.yellow);

    /**
     * Attributo che indica il round button numero 3.
     */
    private MyRoundButton rb3 = new MyRoundButton(60, 400, 20, "Start!", Color.green);

    /**
     * Metodo costrutto che necessità il titolo del frame.
     *
     * @param title titolo del frame.
     */
    public MyRBApp(String title) {
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMouseListener(rb1);
        this.addMouseMotionListener(rb1);
        this.addMouseListener(rb2);
        this.addMouseMotionListener(rb2);
        this.addMouseListener(rb3);
        this.addMouseMotionListener(rb3);

        rb1.addRoundButtonListener(this);
        rb2.addRoundButtonListener(this);
        rb3.addRoundButtonListener(this);
    }

    /**
     * Metodo che disegna il frame e stampa i bottoni.
     *
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        rb1.paint(g);
        rb2.paint(g);
        rb3.paint(g);
    }

    /**
     * Metodo che viene invocato quando il bottone è cliccato. Stampa il testo
     * del bottone cliccato.
     *
     * @param source bottone che viene cliccato.
     */
    public void roundButtonClicked(MyRoundButton source) {
        System.out.println("Round Button " + source.getText() + " Clicked");
    }

    /**
     * Metodo che viene invocato quando il bottone è premuto. * Stampa il testo
     * del bottone premuto.
     *
     * @param source bottone che viene premuto.
     */
    public void roundButtonPressed(MyRoundButton source) {
        System.out.println("Round Button " + source.getText() + " Pressed");
    }

    /**
     * Metodo che viene invocato quando il bottone è rilasciato. * Stampa il
     * testo del bottone rilasciato.
     *
     * @param source bottone che viene rilasciato.
     */
    public void roundButtonReleased(MyRoundButton source) {
        System.out.println("Round Button " + source.getText() + " Released");
    }

    /**
     * Metodo che viene invocato quando il mouse si posiziona sul bottone. *
     * Stampa il testo del bottone su cui è posizionato il mouse.
     *
     * @param source bottone su cui è posizionato il mouse.
     */
    public void roundButtonOver(MyRoundButton source) {
        System.out.println("Round Button " + source.getText() + " Over");
    }

    public static void main(String[] args) {
        String title = "My Round Button App ";
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyRBApp(title).setVisible(true);
            }
        });
    }
}
