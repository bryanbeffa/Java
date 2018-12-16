import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 *
 * @author Bryan Beffa
 * @version 03.03.2018
 */

public class JFrameDemo extends JFrame{
	
	/**
	 * Metodo costruttore che richiede il titolo della finestra.
	 * @param title titolo della finestra.
	 */
	public JFrameDemo(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//do le dimensioni alla finestra
		this.setSize(500, 500);

		//rendo la finestra visibile
		this.setVisible(true);

		//rendo la finestra non ridimensionabile
		this.setResizable(false);

		//posiziono centralmente la finestra
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args){
		JFrameDemo frame = new JFrameDemo("Prova");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setBackground(Color.BLACK);
  	
    	frame.setVisible(true);
    	JLabel label = new JLabel("First Name");
    	label.setForeground(new Color(0,255,0));
    	label.setLocation(27,20);
		frame.add(label);
	}
}