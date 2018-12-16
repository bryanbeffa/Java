/**
 * Definisco la classe torta.
 *
 * @author Bryan Beffa
 * @version 29.01.2018
 */
public class Torta{
/******************************* Attributi *************************/
	/**
	 * Attributo che indica il nome della torta.
	 */
	protected String nome = "";

	/**
	 * Attributo che indica la temperatura di cottura minima.
	 * Valore di defaul 180°C.
	 */
	protected int temperaturaMinima = 180;

	/**
	 * Attributo che indica la temperatura di cottura massima.
	 * Valore di defaul 220°C.
	 */
	protected int temperaturaMassima = 220;

	/**
	 * Attributo che indica lo stato della cottura.
	 * Valore di default 10.
	 */
	protected int cottura = 10;

/*************************** Metodi setter *************************/
	/**
	 * Metodo setter dell'attributo nome.
	 *
	 * @param nome nome della torta da cucinare.
	 */
	public void setNome(String nome){
		this.nome = nome;
	}

	/**
	 * Metodo setter dell'attributo cottura.
	 *
	 * @param cottura cottura della torta.
	 */
	public void setCottura(int cottura){
		if(cottura == 10 || cottura == 20 || cottura == 30){
			this.cottura = cottura;
		}
	}

	/**
	 * Metodo setter dell'attributo temperaturaMinima.
	 *
	 * @param temperaturaMinima temperatura minima di cottura della torta.
	 */
	public void setTemperaturaMinima(int temperaturaMinima){
		if(temperaturaMinima>0){
			this.temperaturaMinima = temperaturaMinima;
		}
	}

	/**
	 * Metodo setter dell'attributo temperaturaMassima.
	 *
	 * @param temperaturaMassima temperatura massima di cottura della torta.
	 */
	public void setTemperaturaMassima(int temperaturaMassima){
		if(temperaturaMassima>getTemperaturaMinima()){
			this.temperaturaMassima = temperaturaMassima;
		}
	}

/*************************** Metodi getter *************************/
	/**
	 * Metodo getter dell'attributo nome.
	 *
	 * @return nome della torta da cucinare.
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Metodo getter dell'attributo cottura.
	 *
	 * @return cottura cottura della torta.
	 */
	public int getCottura(){
		return cottura;
	}

	/**
	 * Metodo getter dell'attributo temperaturaMinima.
	 *
	 * @return temperaturaMinima temperatura minima di cottura della torta.
	 */
	public int getTemperaturaMinima(){
		return temperaturaMinima;
	}

	/**
	 * Metodo getter dell'attributo temperaturaMassima.
	 *
	 * @return temperaturaMassima temperatura massima di cottura della torta.
	 */
	public int getTemperaturaMassima(){
		return temperaturaMassima;
	}

/***************************** Costruttori *************************/
	/**
	 * Metodo vuoto.
	 */
	public Torta(){
	}

	/**
	 * Metodo costruttore che accetta i parametri nome, temperaturaMinima, temperaturaMassima.
	 * 
	 * @param nome nome della torta che si desidera preparare.
	 * @param temperaturaMinima temperatura minima di cottura della torta.
	 * @param temperaturaMassima temperatura massima di cottura della torta.
	 */
	public Torta(String nome, int temperaturaMinima, int temperaturaMassima){
		setTemperaturaMinima(temperaturaMinima);
		setTemperaturaMassima(temperaturaMassima);
		setNome(nome);
	}
	
	/**
	 * Metodo costruttore che accetta il parametro nome.
	 * 
	 * @param nome nome della torta che si desidera preparare.
	 */
	public Torta(String nome){
		setNome(nome);
	}

/************************** Metodi generali ***********************/
	/**
	 * Metodo che modifica lo stato di cottura in base alla temperatura.
	 *
	 * @param temperatura temperatura di cottura.
	 */
	public void cuoci(int temperatura){
		if(getCottura() == 10){
			if(temperatura>getTemperaturaMassima()){
				setCottura(30);
			}else if(temperatura<=getTemperaturaMassima() && temperatura >= getTemperaturaMinima()){
				setCottura(20);
			}
		}
	}

	/**
	 * Metodo che rappresenta lo stato attuale della torta. 
	 *
	 * @return stato attuale della torta.
	 */
	public String toString(){
		String stato = "";
		if(getCottura()==10){
			stato = "cruda";
		}else if(getCottura() ==20){
			stato = "cotta";
		}else{
			stato = "bruciata";
		}
		return getNome() + " " + stato;
	}
}