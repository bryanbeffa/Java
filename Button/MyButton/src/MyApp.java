import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 * Classe che crea un finestra con all'interno un dei bottoni. I bottoni
 * possiedono tre eventi ovvero se si cliccano, premono, rilasciano.
 * @author Bryan Beffa
 * @version 02.06.2018
 */
public class MyApp extends JFrame implements ButtonListener{
    /**
     * Bottone che viene inserito all'interno del JFrame.
     */
    private Button myFirstButton = new Button(100,100,200,100,"Start", Color.green);
    
    /**
     * Bottone che viene inserito all'interno del JFrame.
     */
    private Button mySecondButton = new Button(100,200,200,100,"Start", Color.yellow);
    
    /**
     * Metodo costruttore che richiede come parametro il titolo.
     * @param title titolo del frame.
     */
    public MyApp(String title){
        super(title);
        setSize(300, 300);
        addMouseListener(myFirstButton);
        addMouseListener(mySecondButton);
        myFirstButton.addButtonListener(this);
        mySecondButton.addButtonListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Metodo che disegna il frame e stampa i bottoni.
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g){
        //pulisco lo schermo
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(), getHeight());
        myFirstButton.paint(g);
        mySecondButton.paint(g);
    }
    
    /**
     * Metodo che stampa "bottone cliccato" se si clicca il bottone.
     * @param source bottone che viene cliccato.
     */
    public void ButtonClicked(Button source){
        System.out.println("BOTTONE CLICCATO!");
    }
    
    /**
     * Metodo che stampa "bottone premuto" se si preme il bottone.
     * @param source bottone che viene cliccato.
     */
    public void ButtonPressed(Button source){
        System.out.println("BOTTONE PREMUTO!");
    }
    
    /**
     * Metodo che stampa "bottone rilasciato" se si rilascia il bottone.
     * @param source bottone che viene rilasciato.
     */
    public void ButtonReleased(Button source){
        System.out.println("BOTTONE RILASCIATO!");
        
    }
    
    public static void main(String[] args) {
       String title = "My App "; 
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new MyApp(title).setVisible(true);
            }
        }); 
    }
}
