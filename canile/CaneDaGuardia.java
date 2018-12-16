/**
 * Definisco la classe CaneDaGuardia.
 * Il cane da guardia è addestrato per tenere lontano le persone indesiderate.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class CaneDaGuardia extends Cane{
/***************** Attributi *********************/
	/**
	 * Numero persone messe in fuga.
	 * Valore di default.
	 */
	protected int personeFuggite = 0;
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costrutto vuoto.
	 */
	public CaneDaGuardia(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo personeFuggite.
	 *
	 * @param personeFuggite persone che il cane ha fatto fuggire.
	 */
	protected void setPersoneFuggite(int personeFuggite){
		this.personeFuggite = personeFuggite;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo personeFuggite.
	 *
	 * @return numero di persone fuggite.
	 */
	protected int getPersoneFuggite(){
		return personeFuggite;
	}
/***************** Metodi generali ***************/
	/**
	 * Metodo che mette in fuga le persone.
	 */
	public void mettiInFuga(){
		setPersoneFuggite(getPersoneFuggite()+1);
	}
}