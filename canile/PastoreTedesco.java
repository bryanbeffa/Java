/**
 * Definisco la classe PastoreTedesco.
 * Il pastore tedesco è addestrato per spaventare le persone.
 *
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class PastoreTedesco extends CaneDaGuardia{
/***************** Attributi *********************/
	/**
	 * Numero persone spaventate.
	 * Valore di default.
	 */
	private int personeSpaventate = 0;
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costrutto vuoto.
	 */
	public PastoreTedesco(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo personeSpaventate.
	 *
	 * @param personeSpaventate persone che il cane ha spaventato.
	 */
	private void setPersoneSpaventate(int personeSpaventate){
		this.personeSpaventate = personeSpaventate;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo personeSpaventate.
	 *
	 * @return numero di persone spaventate.
	 */
	private int getPersoneSpaventate(){
		return personeSpaventate;
	}
/***************** Metodi generali ***************/
	/**
	 * Metodo che mette in fuga le persone.
	 */
	public void spaventa(){
		setPersoneSpaventate(getPersoneSpaventate()+1);
	}
}