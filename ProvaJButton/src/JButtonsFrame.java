
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class JButtonsFrame extends JFrame{
    private JButton topJButton = new JButton("Top");
    private JButton lefJButton = new JButton("Left");
    private JButton centerJButton = new JButton("Center");
    private JButton rightJButton = new JButton("Right");
    private JButton bottomJButton = new JButton("Bottom");
    
    public JButtonsFrame(String title){
        setTitle(title);
        setSize(400, 500);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        BorderLayout bl = new BorderLayout();
        this.getContentPane().setLayout(bl);
        
        this.getContentPane().add(topJButton, BorderLayout.PAGE_START);
        this.getContentPane().add(lefJButton, BorderLayout.LINE_START);
        this.getContentPane().add(centerJButton, BorderLayout.CENTER);
        this.getContentPane().add(rightJButton, BorderLayout.LINE_END);
        this.getContentPane().add(bottomJButton, BorderLayout.PAGE_END);
        
        pack();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JButtonsFrame("JButtons").setVisible(true);
            }
        });
    }
    
}
