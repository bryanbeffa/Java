/**
 * Definisco la classe Labrador.
 * Il labrador è un cane da compagnia ed è addestrato per riportare gli oggetti alle persone.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */
public class Labrador extends CaneDaCompagnia{
/***************** Attributi *********************/
	/**
	 * Numero di oggetti riportati.
	 * Valore di default.
	 */
	private int oggettiRiportati = 0;
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costrutto vuoto.
	 */
	public Labrador(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo oggettiRiportati.
	 *
	 * @param oggettiRiportati oggetti che il cane ha riportato.
	 */
	private void setOggettiRiportati(int oggettiRiportati){
		this.oggettiRiportati = oggettiRiportati;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo oggettiRiportati.
	 *
	 * @return numero di oggetti riportati.
	 */
	private int getOggettiRiportati(){
		return oggettiRiportati;
	}
/***************** Metodi generali ***************/
	/**
	 * Metodo che riporta gli oggetti alle persone.
	 */
	public void riporta(){
		setOggettiRiportati(getOggettiRiportati()+1);
	}
}