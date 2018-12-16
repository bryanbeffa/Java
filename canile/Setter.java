/**
 * Definisco la classe Setter.
 * Il setter è una razza di cane da caccia.
 * Il setter sa ammazzare la preda.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class Setter extends CaneDaCaccia{
/******************Attributi **********************/
	/**
	 * Numero prede uccise.
	 * Valore di default 0
	 */
	private int predeUccise = 0;
/***************** Metodi Costruttori *************/
	/**
	 * Metodo costruttore vuoto
	 */
	public Setter(){
	}
/***************** Metodi setter ******************/
	/**
	 * Metodo setter dell'attributo predeUccise.
	 *
	 * @param predeUccise prede che il cane ha ucciso.
	 */
	private void setPredeUccise(int predeUccise){
		this.predeUccise = predeUccise;
	}
/***************** Metodi getter ******************/
	/**
	 * Metodo getter dell'attributo predeUccise.
	 *
	 * @return numero di prede uccise.
	 */
	private int getPredeUccise(){
		return predeUccise;
	}
/***************** Metodi generali ****************/
	/**
	 * Metodo in cui il cane ammazza la preda.
	 * Verrà stampato l'output "ARGH ARGH!"
	 */
	public void ammazza(){
		System.out.println("ARGH ARGH!");
		setPredeUccise(getPredeUccise()+1);
	}
}