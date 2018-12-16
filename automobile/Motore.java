/**
 * Definisco la classe motore.
 * Un motere necessita di un tipo di carburante.
 * Un motore ha un numero di cilindri.
 *
 * @author Bryan Beffa
 * @version 26.12.2017
 */
public class Motore{
/*************************************** Costanti **************************************************/
	/**
	 * Costante che che contiene i possibili carburanti.
	 * I possibili carburanti sono benzinao diesel.
	 */
	public final String[] CARBURANTE = {"benzina", "diesel"};

/*************************************** Attributi *************************************************/
	/**
	 * Attributo che indica il tipo di carburante da utilizzare.
	 * Un motore può avere come carburante diesel o benzina.
	 * Valore di default "benzina".
	 */
	private String carburante = "benzina";

	/**
	 * Attributo che indica il numero di cilindri richiesti.
	 * Un motore può da 2 a 16 cilindri
	 * Valore di default "4".
	 */
	private int cilindro = 4;

/*************************************** Metodi Setter *********************************************/
	/**
	 * Metodo setter dell'attributo carburante.
	 * I carburanti possono essere benzina o diesel.
	 * 
	 * @param carburante il tipo di carburante desiderato. 
	 */
	private void setCarburante(String carburante){
		if(carburante.equalsIgnoreCase(CARBURANTE[0]) || carburante.equalsIgnoreCase(CARBURANTE[1])){
			this.carburante = carburante;
		}
	}

	/**
	 * Metodo setter dell'attributo cilindro.
	 * I cilindri possono variare da 2 a 16.
	 *
	 * @param numCilindri numero di cilindri richiesti per il motore.
	 */
	private void setCilindro(int numCilindri){
		if(numCilindri >= 2 && numCilindri <= 16){
			cilindro = numCilindri;
		}
	}
/*************************************** Metodi Getter *********************************************/
	/**
	 * Metodo getter dell'attributo carburante.
	 * 
	 * @return il tipo di carburante scelto. 
	 */
	public String getCarburante(){
		return carburante;
	}

	/**
	 * Metodo getter dell'attributo cilindro.
	 *
	 * @return il numero di cilindri del motore.
	 */
	public int getCilindro(){
		return cilindro;
	}

/*************************************** Metodi Costruttori ****************************************/
	/**
	 * Metodo costruttore se non vengono forniti parametri.
	 * Numero di cilindri di default è 4.
	 * Carburante di default è benzina.
	 */
	public Motore(){
	}

	/**
	 * Metodo costruttore se viene fornito il tipo di carburante.
	 * Numero di cilindri di default è 4.
	 *
	 * @param carburante tipo di carburante desiderato.
	 */
	public Motore(String carburante){
		setCarburante(carburante);
	}

	/**
	 * Metodo costruttore se viene fornito il numero di cilindri.
	 * Carburante di default è benzina.
	 *
	 * @param cilindro numero di cilindri desiderati.
	 */
	public Motore(int cilindro){
		setCilindro(cilindro);
	}

	/**
	 * Metodo costruttore se vengono forniti tutti e due i parametri.
	 *
	 * @param cilindro numero di cilindri desiderati.
	 * @param carburante tipo di carburante desiderato.
	 */
	public Motore(int cilindro, String carburante){
		setCilindro(cilindro);
		setCarburante(carburante);
	}

/*************************************** Metodi generali *******************************************/
	/**
	 * Metodo che indica quanti cilindri e il tipo di carburante.
	 *
	 * @return la descrizione del motore.
	 */
	public String descrizioneMotore(){
		return "\n\tCarburante: " + getCarburante() + "\n\tNumero cilindri: " + getCilindro();
	}
}