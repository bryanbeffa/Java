import java.awt.Color;

/**
 * Definisco la classe ruota per automobili. 
 * Una ruota può essere da gara, invernale, estiva e normale.
 * Il cerchione può essere di qualsiasi colore.
 *
 * @author Bryan Beffa
 * @version 24.12.2017
 */

public class Ruota{
/*************************************** Attributi *************************************************/	
	/**
	 * Attributo che indica il colore dei cerchioni delle ruote.
	 * Il colore di default "nero".
	 */
	private Color colorCerchioni = new Color(0,0,0);

	/**
	 * Attributo che indica il tipo di ruota.
	 * Il tipo di ruota di default è "normale".
	 */
	private String tipoRuota = "normale";

/*************************************** Metodi Setter *********************************************/
	/**
	 * Metodo che setta il colore dei cerchioni.
	 * I cerchioni possono essere di qualsiasi colore.
	 *
	 * @param cerchi colore dei cerchioni desiderato.
	 */
	private void setColorCerchioni(Color cerchi){
		colorCerchioni = cerchi;
	}

	/**
	 * Metodo setter del tipo di ruota.
	 * I tipi di ruota accettabili sono "normale", "gara", "estiva" e "invernale"
	 *
	 * @param type tipo di ruota che si vuole avere.
	 */
	private void setTipoRuota(String type){
		if(type.equalsIgnoreCase("normale") || type.equalsIgnoreCase("invernale") || type.equalsIgnoreCase("estiva") || type.equalsIgnoreCase("gara")){
			tipoRuota = type;
		}
	}

/*************************************** Metodi Getter *********************************************/
	/**
	 * Metodo che ritorna il valore dell'attributo colorCerchioni.
	 *
	 * @return valore dell'attributo colorCerchioni.
	 */
	public String getColorCerchioni(){
		return "R: " + colorCerchioni.getRed() + " G: " + colorCerchioni.getGreen() + " B: " + colorCerchioni.getBlue();
	}

	/**
	 * Metodo che ritorna il valore dell'attributo tipoRuota.
	 *
	 * @return valore dell'attributo tipoRuota.
	 */
	public String getTipoRuota(){
		return tipoRuota;
	}

/*************************************** Metodi Costruttori ****************************************/
	/**
	 * Metodo costruttore vuoto.
	 * Se non vengono passati dei valori la ruota avrà i valori di default.
	 */
	public Ruota(){
	}	

	/**
	 * Metodo costruttore se viene fornito solo il colore dei cerchioni.
	 *
	 * @param colorCerchioni colore dei cerchioni desiderato.
	 */
	public Ruota(Color colorCerchioni){
		setColorCerchioni(colorCerchioni);
	}	

	/**
	 * Metodo costruttore se viene fornito solo il tipo di ruota.
	 *
	 * @param tipoRuota tipo di ruota desiderato.
	 */
	public Ruota(String tipoRuota){
		setTipoRuota(tipoRuota);
	}	


	/**
	 * Metodo costruttore se vengono forniti entrambi i parametri.
	 *
	 * @param tipoRuota tipo di ruota desiderato.
	 * @param colorCerchioni colore dei cerchioni desiderato.
	 */
	public Ruota(Color colorCerchioni, String tipoRuota){
		setColorCerchioni(colorCerchioni);
		setTipoRuota(tipoRuota);
	}	

/*************************************** Metodi generali *******************************************/
	/**
	 * Metodo che indica il materiale e i numero di sedili.
	 *
	 * @return la descrizione dei sedili richiesti.
	 */
	public String descrizioneRuote(){
		return "\n\tTipo ruote: " + getTipoRuota() + "\n\tColore cerchioni: " + getColorCerchioni();
	}
}