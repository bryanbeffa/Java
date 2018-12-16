/**
 * Definisco la classe bracco.
 * Il bracco è una razza di cane da caccia.
 * Il bracco sa stordire la preda.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class Bracco extends CaneDaCaccia{
/******************Attributi **********************/
	/**
	 * Numero prede stordite.
	 * Valore di default 0
	 */
	private int predeStordite = 0;
/***************** Metodi Costruttori *************/
	/**
	 * Metodo costruttore vuoto
	 */
	public Bracco(){
	}
/***************** Metodi setter ******************/
	/**
	 * Metodo setter dell'attributo predeStordite.
	 *
	 * @param predeStordite prede che il cane ha stordito.
	 */
	private void setPredeStordite(int predeStordite){
		this.predeStordite = predeStordite;
	}
/***************** Metodi getter ******************/
	/**
	 * Metodo getter dell'attributo predeStordite.
	 *
	 * @return numero di prede stordite.
	 */
	private int getPredeStordite(){
		return predeStordite;
	}
/***************** Metodi generali ****************/
	/**
	 * Metodo che permette al cane di stordire la preda.
	 */
	public void stordisciPreda(){
		setPredeStordite(getPredeStordite()+1);
	}
}