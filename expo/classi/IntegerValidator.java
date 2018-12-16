/**
 * È una sottoclasse di Validator specializzata nella validazione di un numero
 * intero (anno di nascita, anno scolastico frequentato, ecc.).
 * Questa classe controlla se l'anno passato è accettabile o meno.
 * Per essere accettabile il valore non deve essere nullo, non deve essere una stringa vuota.
 * Inoltre deve essere un intero ed essere compreso nell'intervallo scelto.
 *
 * @author Beffa Bryan
 * @version 23.02.2018
 */

public class IntegerValidator extends Validator{
/********************************* Attributi ******************************/
	/**
	 * Attributo che indica il minor anno accettabile del range che va da anno minimo ad anno massimo.
	 * Valore di defaul è 1990.
	 */
	private int minValue = 1990;

	/**
	 * Attributo che indica il maggior anno accettabile del range che va da anno minimo ad anno massimo.
	 * Valore di default è 2005.
	 */
	private int maxValue = 2005;
/******************************** Costruttori *****************************/
	/**
	 * Metodo costruttore che richiede due paratri. 
	 * Anno minimo e anno massimo del range per il controllo.
	 *
	 * @param minValue anno minimo del range.
	 * @param maxValue anno massimo del range.
	 */
	public IntegerValidator(int minValue, int maxValue){
		setMinValue(minValue);
		setMaxValue(maxValue);
	}
/****************************** Metodi generali ***************************/
	/**
	 * Metodo setter dell'attributo minValue.
	 * Controlla che minValue sia un valore accettabile. 
	 *
	 * @param minValue valore anno minimo da controllare.
	 */
	private void setMinValue(int minValue){
		//controllo che l'anno sia composto da 4 cifre
		if(minValue > 999 && minValue<9999){
			this.minValue = minValue;
		}
	}

	/**
	 * Metodo setter dell'attributo maxValue.
	 * Controlla che maxValue sia un valore accettabile. 
	 *
	 * @param maxValue valore anno massimo da controllare.
	 */
	private void setMaxValue(int maxValue){
		//controllo che l'anno sia composto da 4 cifre
		if(maxValue<9999 && maxValue>getMinValue()){
			this.maxValue = maxValue;
		}
	}

	/**
	 * Metodo che ritorna il valore dell'attributo minValue.
	 *
	 * @return valore dell'attributo minValue.
	 */
	private int getMinValue(){
		return minValue;
	}

	/**
	 * Metodo che ritorna il valore dell'attributo maxValue.
	 *
	 * @return valore dell'attributo maxValue.
	 */
	private int getMaxValue(){
		return maxValue;
	}

	/**
	 * Metodo che controlla se il valore passato è accettabile.
	 * Il valore non può essere nullo, non può essere una striga vuota, 
	 * deve essere un numero intero, deve essere nell'intervallo [minValue; maxValue].
	 *
	 * @param value valore da controllare la validità.
	 */
	@Override
	public boolean isValid(String value){
		//controllo che il valore non sia null
		if(value != null){
			//controllo che il valore non sia vuoto
			if(value != ""){
				//controllo che il valore sia un numero intero
				try{
					int year = Integer.parseInt(value);
					//controllo che il valore sia almeno il valore minimo
					if(year>= getMinValue()){
						//controllo che il valore sia massimo il valore massimo
						if(year <= getMaxValue()){
							errorMessage = "";
							return true;
						}else{
							errorMessage = "valore troppo grande '" + value + "'";
							return false;
						}
					}else{
						errorMessage = "valore troppo piccolo '" + value + "'";
						return false;
					}
				}catch(NumberFormatException e){
					errorMessage = "valore non valido '" + value +"'";
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