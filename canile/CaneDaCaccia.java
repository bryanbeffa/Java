import java.awt.Color;

/**
 * Definisco la classe CaneDaCaccia. 
 * Un cane da caccia possiede tutti i membri e le proprietà di un cane, ma sa anche sparare.
 *
 * @author Bryan Beffa
 * @version 13.01.2018 
 */

public class CaneDaCaccia extends Cane{
/******************Attributi **********************/
	/**
	 * Attributo che indica il numero di spari totali
	 */
	protected int shoots = 0;
/***************** Metodi Costruttori *************/
	/**
	 * Metodo costruttore vuoto
	 */
	public CaneDaCaccia(){
	}
/***************** Metodi setter ******************/
	/**
	 * Metodo setter dell'attributo shoots.
	 *
	 * @param shoots shoots che il cane ha sparato.
	 */
	protected void setShoots(int shoots){
		this.shoots = shoots;
	}
/***************** Metodi getter ******************/
	/**
	 * Metodo getter dell'attributo shoots.
	 *
	 * @return shoots che il cane ha sparato.
	 */
	protected int getShoots(){
		return shoots;
	}
/***************** Metodi generali ****************/
	/**
	 * Metodo in cui il cane da caccia spara.
	 * Stampa a terminale l'output "PAM PAM!".
	 */
	public void spara(){
		System.out.println("PUM PUM!");
		setShoots(getShoots()+1);
	}

	public static void main(String[] args) {
		CaneDaCaccia billy = new CaneDaCaccia();
		System.out.println(billy.getPeso());
		billy.abbaia();
		billy.mangia(3);
		billy.spara();
		System.out.println(billy.getPeso());
	}
}