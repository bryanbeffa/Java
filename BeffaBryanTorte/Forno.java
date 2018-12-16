/**
 * Definisco la classe Forno.
 * La classe Forno rappresenta il modello astratto di forno da cucina e serve per cuocere le torte.
 *
 * @author Bryan Beffa
 * @version 29.01.2018
 */
public class Forno{
/******************************* Attributi *************************/
	/**
	 * Attributo che indica se il forno è acceso.
	 * true = acceso, false = spento.
	 * Valore di default "spento".
	 */
	private boolean acceso = false;

	/**
	 * Attributo che indica la temperatura del forno.
	 * Valore di defaul è 0°C.
	 */
	private int temperatura = 0;
/*************************** Metodi setter *************************/
	/**
	 * Metodo setter dell'attributo acceso.
	 * 
	 * @param acceso se vero accende il forno, se falso lo spegne.
	 */
	public void setAcceso(boolean acceso){
		this.acceso = acceso;
	}

	/**
	 * Metodo setter dell'attributo temperatura.
	 * 
	 * @param temperatura temperatura del forno.
	 */
	public void setTemperatura(int temperatura){
		if(temperatura>=0 && temperatura<= 300){
			this.temperatura = temperatura;
		}
	}
/*************************** Metodi getter *************************/
	/**
	 * Metodo getter dell'attributo acceso.
	 * 
	 * @return se il forno è acceso o spento.
	 */
	public boolean getAcceso(){
		return acceso;
	}

	/**
	 * Metodo getter dell'attributo temperatura.
	 * 
	 * @return temperatura del forno.
	 */
	public int getTemperatura(){
		return temperatura;
	}
/***************************** Costruttori *************************/
	/**
	 * Metodo costruttore vuoto.
	 */
	public Forno(){
	}

/************************** Metodi generali ***********************/
	/**
	 * Metodo che serve ad accendere il forno.
	 */
	public void accendi(){
		setAcceso(true);
	}

	/**
	 * Metodo che serve a spegnere il forno.
	 */
	public void spegni(){
		setAcceso(false);
	}

	/**
	 * Metodo che descrive lo stato attuale del forno.
	 */
	public String toString(){
		if(getAcceso()){
			return "Forno ON T: " + getTemperatura() + "°C";
		}else{
			return "Forno OFF T: " + getTemperatura() + "°C";
		}
	}

	/**
	 * Metodo che serve a infornare le torte.
	 *
	 * @param torta torta da infornare.
	 */
	public void inforna(Torta torta){
		if(getAcceso()){
			torta.cuoci(getTemperatura());
		}
	}
}