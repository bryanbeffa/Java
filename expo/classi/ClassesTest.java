/**
 * Questa è una classe in cui vengono sperimentate e testate le classi per la convalidazione dei dati.
 * Vi saranno numerosi test per ogni possibile caso-
 * Qui vengono testate le classi, NameValidator, IntegerValidator ed EmailValidator.
 *
 * @author Bryan Beffa 
 * @version 24.02.2018
 */

public class ClassesTest{
	public static void main(String[] args) {

		System.out.println("\nTest delle classi validator. Viene stampato il caso e il messaggio d'errore");
/************************* Testo la classe NameValidator *************************************/
		NameValidator name = new NameValidator(30);
		String nome;
		System.out.println("\nTest classe NameValidator:");

		//quando la stringa è nulla
		nome = null;
		name.isValid(nome);
		System.out.println("stringa nulla: " + name.getErrorMessage());

		//quando la stringa è vuota
		nome = "";
		name.isValid(nome);
		System.out.println("stringa vuota: " + name.getErrorMessage());

		//quando la stringa è troppo lunga
		nome = "qwertzuiopwesrdctfvgzbhunjimcrtvzbwqubdciwbeciubcqeiubciuqebciuoqebrciubcequobceqoub";
		name.isValid(nome);
		System.out.println("stringa troppo lunga: " + name.getErrorMessage());

		//quando la stringa contiene caratteri non consentiti
		nome = "Mario@";
		name.isValid(nome);
		System.out.println("stringa con caratteri non consentiti: " + name.getErrorMessage());

		//quando la stringa è accettabile
		nome = "Mario";
		name.isValid(nome);
		System.out.println("stringa accettabile: " + name.getErrorMessage());



/*********************** Testo la classe IntegerValidator ************************************/
		IntegerValidator year = new IntegerValidator(1990, 2003);
		String value;
		System.out.println("\nTest classe IntegerValidator:");

		//quando il valore è null
		value = null;
		year.isValid(value);
		System.out.println("Caso valore nullo: " + year.getErrorMessage());
		
		//quando il valore è vuoto
		value = "";
		year.isValid(value);
		System.out.println("Caso valore vuoto: " + year.getErrorMessage());

		//quando il valore non è un numero
		value = "Agc";
		year.isValid(value);
		System.out.println("Caso valore non numerico: " + year.getErrorMessage());
	
		//quando il valore è minore del minValue
		value = "1989";
		year.isValid(value);
		System.out.println("Caso valore troppo piccolo: " + year.getErrorMessage());	

		//quando il valore è maggiore del maxValue
		value = "2004";
		year.isValid(value);
		System.out.println("Caso valore troppo grande: " + year.getErrorMessage());

		//quando il valore è accettabile
		value = "2000";
		year.isValid(value);
		System.out.println("Caso valore accettabile: " + year.getErrorMessage());
		
/*********************** Testo la classe EmailValidator ************************************/
		System.out.println("\nTest della classe EmailValidator");
		EmailValidator email = new EmailValidator();
		String mail;

		//quando il valore è null
		mail = null;
		email.isValid(mail);
		System.out.println("Caso valore nullo: " + email.getErrorMessage());

		//quando il valore è null
		mail = "";
		email.isValid(mail);
		System.out.println("Caso valore vuoto: " + email.getErrorMessage());

		mail = "ACSDC@";
		email.isValid(mail);
		System.out.println("Local part : " + email.getErrorMessage());

		mail = "acds@";
		email.isValid(mail);
		System.out.println("local part: " + email.getErrorMessage());

		mail = "1234567890@";
		email.isValid(mail);
		System.out.println("local part numerica: " + email.getErrorMessage());

		//quando c'è il carattere '.' ripetuto consecutivamente nella local part
		mail = "ciao..aa@";
		email.isValid(mail);
		System.out.println("quando viene ripetuto consecutivamente il carattere '.': " + email.getErrorMessage());

		//quando la local part inizia per il carattere '.'
		mail = ".ciaoaa@";
		email.isValid(mail);
		System.out.println("local part che inizia per '.': " + email.getErrorMessage());
	
		//quando la local part finisce per il carattere '.'
		mail = "ciaoaa.@";
		email.isValid(mail);
		System.out.println("local part che finisce per '.': " + email.getErrorMessage());

		//quando la local part è troppo lunga
		mail = "1234567890123456789012345678901234567890123456789012345678901234567890@";
		email.isValid(mail);
		System.out.println("local part troppo lunga '.': " + email.getErrorMessage());

		//quando è presente un carattere non ammesso nella local part
		mail = "ciao+@dsd";
		email.isValid(mail);
		System.out.println("local part con carattere non ammesso: " + email.getErrorMessage());

		//quando il dominio è vuoto
		mail = "luigi.bernasconi-_1988@";
		email.isValid(mail);
		System.out.println("dominio vuoto: " + email.getErrorMessage());

		//quando non contiene almeno il dominio di secondo e primo livello
		mail = "luigi.bernasconi-_1988@hotmail";
		email.isValid(mail);
		System.out.println("mancanza primo e secondo livello: " + email.getErrorMessage());

		//quando il dominio contiene un carattere non ammesso
		mail = "luigi.bernasconi-_1988@hotmail.com+";
		email.isValid(mail);
		System.out.println("carattere non ammesso: " + email.getErrorMessage());

		//quando il dominio contiene livelli troppo lunghi 
		mail = "luigi.bernasconi-_1988@ciaociaociciaociaociciaociaociciaociaociciaociaociciaociaociciaociaoci.com";
		email.isValid(mail);
		System.out.println("dominio troppo lungo: " + email.getErrorMessage());

		//quando un livelli inzia per '-' 
		mail = "luigi.bernasconi-_1988@-hotmail.com";
		email.isValid(mail);
		System.out.println("livello inizia per '-': " + email.getErrorMessage());

		//quando un livelli finisce per '-' 
		mail = "luigi.bernasconi-_1988@hotmail-.com";
		email.isValid(mail);
		System.out.println("livello finisce per '-': " + email.getErrorMessage());

		//quando il dominio di primo livello contiene solo numeri 
		mail = "luigi.bernasconi-_1988@hotmail.123";
		email.isValid(mail);
		System.out.println("dominio di primo livello con soli numeri: " + email.getErrorMessage());

		//quando è tutto accettabile
		mail = "luigi.bernasconi-_1988@hotmail.com";
		email.isValid(mail);
		System.out.println("email valida: " + email.getErrorMessage());
	}
}
