/**
 * Definisco la classe sedile.
 * Un sedile può essere il pelle o no.
 * Si possono avere da 2 a 7 seidili.
 *
 * @author Bryan Beffa
 * @version 26.12.2017
 */

public class Sedile{
/*************************************** Attributi *************************************************/
	/**
	 * Attributo che indica se il materiale è pelle vere on no.
	 * Di default il materiale non è pelle.
	 */
	private boolean isRealSkin = false;
	
	/**
	 * Attributo che indica il numero di sedili richiesti.
	 * Da 2 a 7 posti.
	 * Numero di default è 5.
	 */
	private int numSedili = 5;
/*************************************** Metodi Setter *********************************************/
	/**
	 * Metodo setter dell'attributo isRealSkin.
	 *
	 * @param isSkin parametro che indica se il materiale deve essere pelle.
	 */
	private void setIsRealSkin(boolean isSkin){
		isRealSkin = isSkin;
	}

	/**
	 * Metodo setter dell'attributo numSedili.
	 * Il numero di sedili deve essere compreso tra 3 e 7.
	 *
	 * @param numSedili numero di sedili richiesto per automobile.
	 */
	public void setNumSedili(int numSedili){
		if(numSedili >= 3 && numSedili <= 7){
			this.numSedili = numSedili;
		}
	}
/*************************************** Metodi Getter *********************************************/
	/**
	 * Metodo getter dell'attributo isRealSkin.
	 *
	 * @return se i sedili sono stati richiesti in pelle o no.
	 */
	public boolean getIsRealSkin(){
		return isRealSkin;
	}

	/**
	 * Metodo getter dell'attributo numSedili.
	 *
	 * @return il numero di sedili che è stato richiesto per automobile.
	 */
	public int getNumSedili(){
		return numSedili;
	}

/*************************************** Metodi Costruttori ****************************************/
	/**
	 * Metodo costruttore se non vengono passati parametri.
	 * Materiale di default non in pelle.
	 * Numero di sedili di default è 5.
	 */
	public Sedile(){
	}

	/**
	 * Metodo costruttore se viene fornito solo il materiale dei sedili.
	 *
	 * @param isSkin parametro che indica se i sedili sono o no in pelle.
	 */	
	public Sedile(boolean isSkin){
		setIsRealSkin(isSkin);
	}

	/**
	 * Metodo costruttore se viene fornito solo il materiale dei sedili.
	 *
	 * @param numSedili numero di sedili richiesti.
	 */	
	public Sedile(int numSedili){
		setNumSedili(numSedili);
	}

	/**
	 * Metodo costruttore se vengono forniti il materiale e il numero dei sedili.
	 *
	 * @param numSedili numero di sedili richiesti.
	 * @param isSkin parametro che indica se i sedili sono o no in pelle.
	 */	
	public Sedile(int numSedili, boolean isSkin){
		setNumSedili(numSedili);
		setIsRealSkin(isSkin);
	}

/*************************************** Metodi generali *******************************************/
	/**
	 * Metodo che ritorna la descrizione dei sedili.
	 * Indica il materiale e i numero di sedili.
	 *
	 * @return la descrizione dei sedili richiesti.
	 */
	public String descrizioneSedili(){
		String pelle = getIsRealSkin()?"SI":"NO";
		return "\n\tSedili in pelle: " + pelle + "\n\tNumero sedili: " + getNumSedili();
	}
}
