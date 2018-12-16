/**
 * Questa classe serve alla covalidazione delle email.
 * Il valore passato come indirizzo email non può essere nullo,
 * non può essere una stringa vuota.
 *
 * @author Beffa Bryan
 * @version 24.02.2018
 */

public class EmailValidator extends Validator{
/******************************** Costruttori *****************************/
	/**
	 * Metodo costruttore vuoto.
	 * Non richiede parametri.
	 */
	public EmailValidator(){
	}

/****************************** Metodi generali ***************************/
	/**
	 * Metodo che controlla se la local-part è valida.
	 * La local part per essere valida deve essere lunga al massimo 64 caratteri.
	 * Non iniziare o finire per il carattere '.'.
	 * Non contere '.' ripetuto consecutivamente.
	 * Può contenere lettere, numeri, '.', '-' e '_'.
	 *
	 * @param value valore che contine la local-part.
	 */
	private boolean checkLocalPart(String value){
		//controllo che la local-part non sia nulla.
		if(value != ""){
			//controllo che la local part non sia troppo lunga.
			if(value.length() <= 64){
				//controllo che la local part non inizi o finisca con il carattere '.'.
				if(value.charAt(0) != '.' ){
					//controllo che la local part non finisca con il carattere '.'.
					if(value.charAt(value.length()-1) != '.'){
						//controllo che la local-part contenga solo caratteri ammessi.
						for(int i=0; i<value.length(); i++){
							int numChar = value.charAt(i);
							if(numChar >= 65 && numChar <= 90 || numChar >= 97 && numChar <= 122 || numChar >= 48 && numChar <= 57 || numChar == 46 ||	numChar == 45 || numChar == 95){
								//controllo se c'è due volte di fila il carattere '.'.
								if(value.charAt(i) == '.'){
									if(value.charAt(i+1) == '.'){
										errorMessage = "il carattere '.' non può essere ripetuto";
										return false;
									}
								}
							}else{
								errorMessage = "carattere non ammesso '" + value.charAt(i) + "'";
								return false;
							}
						}
						errorMessage = "";
						return true;
					}else{
						errorMessage = "il carattere '.' non è ammesso alla fine dell’indirizzo";
						return false;
					}
				}else{
					errorMessage = "il carattere '.' non è ammesso all’inizio dell’indirizzo";
					return false;
				}
			}else{
				errorMessage = "local part troppo lunga";
				return false;
			}
		}else{
			errorMessage = "local part vuota non ammessa";
			return false;
		}
	}

	/**
	 * Metodo che serve a controllare il singolo livello.
	 *
	 * @param value valore del livello di dominio da controllare.
	 */
	private boolean checkDomainLevel(String value, boolean isFirstLevel){
		//controllo che il livello del domain non sia vuoto
		if(value != ""){
			//controllo che il livello non sia troppo lungo
			if(value.length() <= 63){
				//controllo che il carattere '-' non sia all'inizio del livello
				if(value.charAt(0) != '-'){
					//controllo che il carattere '-' non sia alla fine del livello
					if(value.charAt(value.length()-1) != '-'){
						//controllo se è un dominio di livello 1
						if(isFirstLevel){
							boolean areAllNumbers = true;
							//controllo che ci siano solo caratteri consentiti
							for(int i=0; i<value.length(); i++){
								if(!(value.charAt(i)>= 65 && value.charAt(i) <= 90 || value.charAt(i)>= 48 && value.charAt(i) <= 57 || value.charAt(i)>= '-')){
									errorMessage = "carattere non ammesso '" + value.charAt(i) + "'";
									return false;
								}else{
									if(!(value.charAt(i)>= 48 && value.charAt(i) <= 57)){
										areAllNumbers = false;
									}
								}
							}
							if(areAllNumbers){
								errorMessage = "il dominio di primo livello non può contenere solo numeri '" + value + "'";
								return false;
							}else{
								return true;
							}
						}else{
							//controllo che ci siano solo caratteri consentiti
							for(int i=0; i<value.length(); i++){
								if(!(value.charAt(i)>= 65 && value.charAt(i) <= 90 || value.charAt(i)>= 48 && value.charAt(i) <= 57 || value.charAt(i)>= '-')){
									errorMessage = "carattere non ammesso '" + value.charAt(i) + "'";
									return false;
								}
							}
							return true;
						}
					}else{
						errorMessage = "il carattere '-' non è ammesso alla fine del dominio";
						return false;
					}
				}else{
					errorMessage = "il carattere '-' non è ammesso all’inizio del dominio";
					return false;
				}
			}else{
				errorMessage = "domain part troppo lunga";
				return false;
			}
		}else{
			errorMessage = "il carattere '.' non può essere ripetuto";
			return false;
		}
	}


	/**
	 * Metodo che controlla il dominio dell'indirizzo.
	 *
	 * @param value valore del dominio da controllare.
	 */
	private boolean checkDomain(String value){
		//controllo che il dominio non sia vuoto
		if(value != ""){
			//controllo che il dominio non sia troppo lungo
			if(value.length()<= 255){
				//controllo che il dominio non inizi o finisca con il carattere '.'
				if(value.charAt(0) == '.' || value.charAt(value.length()-1) == '.'){
					errorMessage = "il dominio non può iniziare o finire con il carattere '.'";
					return false;
				}else{
					String domainLevel = "";
					boolean isFirstLevel = false;
					int numLevels = 0;
					for (int i=0; i<value.length(); i++){
						if(value.charAt(i) == '.'){
							//controllo se il domain leve è accettabile
							if(checkDomainLevel(domainLevel, isFirstLevel)){
								domainLevel = "";
								numLevels++;
							}else{
								return false;
							}
						}else if(i == value.length()-1){
							isFirstLevel = true;
							domainLevel += value.charAt(i);
							//controllo se il primo livello è accettabile
							if(!checkDomainLevel(domainLevel, isFirstLevel)){
								return false;
							}
							numLevels++;
						}else{
							domainLevel += value.charAt(i);
						}
					}
					//controllo se il domain aveva almeno due livelli
					if(numLevels>=2){
						return true;
					}else{
						errorMessage = "domain di primo livello mancante";
						return false;
					}
				}
			}else{
				errorMessage = "domain part troppo lunga";
				return false;
			}
		}else{
			errorMessage = "dominio vuoto non ammesso";
			return false;
		}
	}


	/**
	 * Metodo che controlla se la struttura dell'indirizzo email 
	 * passato come parametro è accettabile.
	 *
	 * @param value indirizzo email da verificarne la struttura.
	 */
	public boolean isValid(String value){
		//controllo se il valore passato non null.
		if(value != null){
			//controllo che la stringa non sia vuota.
			if(value != ""){
				String localPart = "";
				String domain = "";
				int check = 0;

				for (int i=0; i<value.length(); i++){
					if(value.charAt(i) == '@'){
						check++;
						for(int o=i+1; o<value.length(); o++){
							domain += value.charAt(o);
						}
						break;
					}
					localPart += value.charAt(i);
				}
				//controllo se è presente il carattere '@'.
				if(check != 0){
					//controllo se la local-part è accettabile.
					if(checkLocalPart(localPart)){
						//controllo il domain
						if(checkDomain(domain)){
							return true;	
						}else{
							return false;	
						}
					}else{
						return false;
					}
				}else{
					errorMessage = "carattere '@' non presente";
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