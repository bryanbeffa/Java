/**
 * NameValidator è una sottoclasse di Validator specializzata nella 
 * validazione di un nome (nome, cognome, nome della scuola, ecc.).
 * Questa classe serve quindi a controllare se i nomi passati sono o meno accettabili. 
 *
 * @author Beffa Bryan
 * @version 23.02.2018
 */

public class NameValidator extends Validator{
/********************************* Attributi ******************************/
	/**
	 * Attributo che indica la lunghezza massima consentita del nome.
	 * Valore di default 255;
	 */
	private int maxLength = 255;

/******************************** Costruttori *****************************/
	/**
	 * Metodo costruttore che richiede il parametro della lunghezza massima del nome
	 *
	 * @param maxLength lunghezza massima del nome.
	 */
	public NameValidator(int maxLength){
		setValidator(maxLength);
	}

/****************************** Metodi generali ***************************/
	/**
	 * Metodo setter dell'attributo maxLength.
	 * Controlla che il valore da assegnare all'attributo maxLength sia valido.
	 * maxLength deve essere un valore superiore a 0. 
	 *
	 * @param maxLength lunghezza massima del nome.
	 */
	private void setValidator(int maxLength){
		if(maxLength>0){
			this.maxLength = maxLength;
		}
	}

	/**
	 * Metodo getter dell'attributo maxLength.
	 *
	 * @return valore dell'attributo maxLength.
	 */
	private int getMaxLength(){
		return maxLength;
	}

	/**
	 * Metodo che controlla se il nome passato è un valore accettabile.
	 *
	 * @param value valore da verificare se accettabile.
	 */
	@Override
	public boolean isValid(String value){
		if(value != null){
			if(value != ""){
				if(value.length() < getMaxLength()){
					//controllo se i caratteri sono accettabili
					//char[] accenti = {'a','à','á','e','è','é','i','ì','í','o','ò', 'ó'};
					for(int i=0; i<value.length(); i++){
						//caratteri accettabili
						if(Character.isLetter(value.charAt(i)) || value.charAt(i) == 32 || value.charAt(i) == 39){
							errorMessage = "";
						}else{
							errorMessage = "carattere non ammesso '" + value.charAt(i) + "'";
							return false;	
						}
					}
					errorMessage = "";
					return true;
				}else{
					errorMessage = "valore troppo lungo, inserire al massimo " + getMaxLength() + " caratteri";
					return false;
				}
			}else{
				errorMessage = "stringa vuota non ammessa";
				return false;
			}			
		}else{
			errorMessage = "stringa nulla non ammessa";
			return false;
		}
	}
}