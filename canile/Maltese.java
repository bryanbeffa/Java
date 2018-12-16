/**
 * Definisco la classe Maltese.
 * Il maletese è un cane da compagnia ed è addestrato per saltare nelle borsette.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */
public class Maltese extends CaneDaCompagnia{
/***************** Attributi *********************/
	/**
	 * Numero di salti fatti.
	 * Valore di default.
	 */
	private int salti = 0;
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costrutto vuoto.
	 */
	public Maltese(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo salti.
	 *
	 * @param salti salti che il cane ha fatto.
	 */
	private void setSalti(int salti){
		this.salti = salti;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo salti.
	 *
	 * @return numero di salti fatti.
	 */
	private int getSalti(){
		return salti;
	}
/***************** Metodi generali ***************/
	/**
	 * Metodo che fa saltare il cane.
	 */
	public void salta(){
		setSalti(getSalti()+1);
	}
}