/**
 * La classe validator è la super classe di tutte le classi per la convalidazione dei dati.
 *
 * @author Beffa Bryan
 * @version 23.02.2018
 */

public class Validator{
/********************************* Attributi ******************************/
	/**
	 * Variabile in cui viene memorizzato il messaggio di errore.
	 */
	protected String errorMessage = "";

/******************************** Costruttori *****************************/
	/**
	 * Metodo costruttore vuoto.
	 * Non non richiede parametri.
	 */
	public Validator(){
	}
/****************************** Metodi generali ***************************/
	
	public boolean isValid(String value){
		return true;
	}

	/**
	 * Metodo che ritorna il messaggio di errore contenuto nell'attributo errorMessage.
	 *
	 * @return il messaggio di errore contenuto nell'attributo errorMessage.
	 */
	public String getErrorMessage(){
		return errorMessage;
	}
}