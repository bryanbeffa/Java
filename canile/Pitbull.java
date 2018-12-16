/**
 * Definisco la classe Pitbull.
 * Il pastore pitbull è addestrato per intimidire le persone.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class Pitbull extends CaneDaGuardia{
/***************** Attributi *********************/
	/**
	 * Numero persone intimidite.
	 * Valore di default.
	 */
	private int personeIntimidite = 0;
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costrutto vuoto.
	 */
	public Pitbull(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo personeIntimidite.
	 *
	 * @param personeIntimidite persone che il cane ha intimidito.
	 */
	private void setPersoneIntimidite(int personeIntimidite){
		this.personeIntimidite = personeIntimidite;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo personeIntimidite.
	 *
	 * @return numero di persone intimidite.
	 */
	private int getPersoneIntimidite(){
		return personeIntimidite;
	}
/***************** Metodi generali ***************/
	/**
	 * Metodo che mette in fuga le persone.
	 */
	public void intimidisci(){
		setPersoneIntimidite(getPersoneIntimidite()+1);
	}
}