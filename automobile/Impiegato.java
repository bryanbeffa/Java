/**
 * Definisco la classe impiegato.
 * Un impiegato ha un nome, un cognome.
 * Un impiegato lavora per un azienda.
 * L'impiegato può guidare l'auto.
 *
 * @author Bryan Beffa
 * @version 29.12.2017
 */
public class Impiegato{
/*************************************** Attributi *************************************************/
	/**
	 * Attributo che indica il nome dell'impiegato.
	 */
	private String nome;

	/**
	 * Attributo che indica il cognome dell'impiegato.
	 */
	private String cognome;

/*************************************** Metodi Setter *********************************************/
	/**
	 * Metodo setter dell'attributo nome.
	 * Un nome può contenere solo lettere e non altri simboli.
	 *
	 * @param nome nome dell'impiegato da settare.
	 */
	private void setNome(String nome){
		boolean check = true;
		for(int i =0; i<nome.length(); i++){
			if((int)nome.charAt(i)<65 || ((int)nome.charAt(i)>90 && (int)nome.charAt(i)<97) || (int)nome.charAt(i)>122){
				check =false;
			}
		}
		if(check){
			this.nome = nome;
		}else{
			System.out.println("Il nome " + nome + " non è valido, un nome contiene solo lettere.");
		}
	}

	/**
	 * Metodo setter dell'attributo cognome.
	 * Un cognome può contenere solo lettere e non altri simboli.
	 * Un cognome può contenere spazi.
	 *
	 * @param cognome cognome dell'impiegato da settare.
	 */
	private void setCognome(String cognome){
		boolean check = true;
		for(int i =0; i<cognome.length(); i++){
			if((int)cognome.charAt(i)<65 || ((int)cognome.charAt(i)>90 && (int)cognome.charAt(i)<97) || (int)cognome.charAt(i)>122){
				if((int)cognome.charAt(i)!=32){
					check =false;
				}
			}
		}
		if(check){
			this.cognome = cognome;
		}else{
			System.out.println("Il cognome " + cognome + " non è valido, un cognome contiene solo lettere.");
		}
	}

/*************************************** Metodi Getter *********************************************/
	/**
	 * Metodo getter dell'attributo nome.
	 *
	 * @return nome dell'impiegato.
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Metodo getter dell'attributo cognome.
	 *
	 * @return cognome dell'impiegato.
	 */
	public String getCognome(){
		return cognome;
	}
/*************************************** Metodi Costruttori ****************************************/
	/**
	 * Unico metodo costruttore.
	 * Un impiegato ha un nome e un cognome.
	 * Quindi non ci sono valori di default.
	 *
	 * @param nome nome dell'impiegato.
	 * @param cognome cognome dell'impiegato.
	 */

	public Impiegato(String nome, String cognome){
		setNome(nome);
		setCognome(cognome);
	}

/*************************************** Metodi generali *******************************************/
	/**
	 * Metodo che ritorna il nome e cognome dell'impiegato.
	 *
	 * @return la descrizione dell'impiegato.
	 */
	public String descrizioneImpiegato(){
		return "\n\tNome: " + getNome() + "\n\tCognome: " + getCognome();
	}
}