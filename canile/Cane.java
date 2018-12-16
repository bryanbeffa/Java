import java.awt.Color;

/**
 * Definisco la classe cane.
 * Un cane ha una razza, un peso e il colore del pelo. 
 * 
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class Cane{

/********************* Attributi ******************/
	/**
	 * Attributo che indica la razza del cane.
	 */
	protected String razza = "Alano";

	/**
	 * Attributo che indica il peso del cane.
	 * Valore di default 10 kg.
	 */
	protected int peso = 10;

/***************** Metodi Costruttori *************/
	/**
	 * Metodo costruttore vuoto.
	 */
	public Cane(){
	}

	/**
	 * Metodo costruttore che necessita tutti i parametri.
	 *
	 * @param razza razza del cane.
	 * @param peso peso del cane.
	 */
	public Cane(String razza, int peso){
		setRazza(razza);
		setPeso(peso);
	}

/***************** Metodi setter ******************/
	/**
	 * Metodo setter dell'attributo razza.
	 *
	 * @param razza razza del cane.
	 */
	public void setRazza(String razza){
		this.razza = razza;
	}

	/**
	 * Metodo setter dell'attributo peso.
	 *
	 * @param peso peso del cane.
	 */
	public void setPeso(int peso){
		if(peso > 0 && peso < 100){
			this.peso = peso;
		}
	}

/***************** Metodi getter ******************/
	/**
	 * Metodo getter dell'attributo razza.
	 *
	 * @return razza del cane.
	 */
	public String getRazza(){
		return razza;
	}

	/**
	 * Metodo getter dell'attributo peso.
	 *
	 * @return peso del cane.
	 */
	public int getPeso(){
		return peso;
	}
/**************** Metodi generali ****************/

	/**
	 * Metodo che fa abbaiare il cane.
	 * Verrà stampato "BAU BAU!" 
	 */
	public void abbaia(){
		System.out.println("BAU BAU!");
	}

	/**
	 * Metodo che fa mangiare il cane.
	 * Il cane ingrassa.
	 *
	 * @param kgCibo kg di cibo che mangia e quindi di cui ingrasserà
	 */
	public void mangia(int kgCibo){
		if(kgCibo > 0){
			int newPeso = getPeso()+kgCibo;
			setPeso(newPeso);
		}
	}
}	




