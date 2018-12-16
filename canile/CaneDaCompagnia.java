/**
 * Definisco la classe CaneDaCompagnia.
 * Il cane da compagnia è addestrato per aiutare le persone.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */
public class CaneDaCompagnia extends Cane{
/***************** Attributi *********************/
	/**
	 * Numero persone aiutate.
	 * Valore di default.
	 */
	protected int personeAiutate = 0;
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costrutto vuoto.
	 */
	public CaneDaCompagnia(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo personeAiutate.
	 *
	 * @param personeAiutate persone che il cane ha aiutato.
	 */
	protected void setPersoneAiutate(int personeAiutate){
		this.personeAiutate = personeAiutate;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo personeAiutate.
	 *
	 * @return numero di persone aiutate.
	 */
	protected int getPersoneAiutate(){
		return personeAiutate;
	}
/***************** Metodi generali ***************/
	/**
	 * Metodo che mette aiuta le persone.
	 */
	public void aiuta(){
		System.out.println(getPersoneAiutate());
		setPersoneAiutate(getPersoneAiutate()+1);
		System.out.println(getPersoneAiutate());
	}
}