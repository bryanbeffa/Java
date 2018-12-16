
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe che disegna in un jframe una matrice di bottoni. Quando un bottone
 * viene cliccato vengono stampate le coordinate del bottone cliccato.
 *
 * @author Bryan
 * @version 15.10.2018
 */
public class GridFrame extends JFrame implements ActionListener {

    /**
     * Matrice di jbutton
     */
    private JButton[][] jButtons;

    /**
     * Attributo che indica il numero di righe. Valore di default 10.
     */
    private int rows = 10;

    /**
     * Attributo che indica il numero di colonne. Valore di default 10.
     */
    private int cols = 10;

    /**
     * Metodo getter dell'attributo rows.
     *
     * @return numero di righe
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Metodo getter dell'attributo cols.
     *
     * @return il numero di colonne
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Metodo setter dell'attributo rows
     *
     * @param rows numero di righe
     */
    public void setRows(int rows) {
        if (rows > 0) {
            this.rows = rows;
        }
    }

    /**
     * Metodo setter dell'attributo cols
     *
     * @param cols numero di colonne
     */
    public void setCols(int cols) {
        if (cols > 0) {
            this.cols = cols;
        }
    }

    /**
     * Metodo costruttore con due parametri
     *
     * @param rows numero di righe
     * @param cols numero di colonne
     */
    public GridFrame(int rows, int cols) {
        setTitle("GridFrame");
        setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setto il numero di righe e di colonne
        setRows(rows);
        setCols(cols);

        //setto il layout
        this.setLayout(new GridLayout(getRows(), getCols()));

        //creo la matrice di JButton
        jButtons = new JButton[getRows()][getCols()];

        //creo i bottoni
        for (int i = 0; i < jButtons.length; i++) {
            for (int j = 0; j < jButtons[i].length; j++) {
                jButtons[i][j] = new JButton(i + ":" + j);
                this.getContentPane().add(jButtons[i][j]);
                //aggiungo il gestore degli eventi
                jButtons[i][j].addActionListener(this);
            }
        }

        pack();
    }

    /**
     * Metodo che stampa a le coordinate del bottone cliccato.
     *
     * @param e evento del muouse.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Bottone cliccato: \"" + ((JButton) e.getSource()).getText() + "\"");

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridFrame(4, 12).setVisible(true);
            }
        });
    }
}
