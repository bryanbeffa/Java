/**
 * Definisco la classe canile.
 * All'interno di un canile ci sono diversi tipi di cani.
 * Ci sono più razze di tipi di cane.
 * @author Bryan Beffa
 * @version 13.01.2018
 */

public class Canile{
/***************** Attributi *********************/
	/**
	 * Attributo che indica i cani del canile.
	 * Il canile ha 10 cani.
	 */
	private Cane[] cani = new Cane[9];
/***************** Metodi Costruttori ************/
	/**
	 * Metodo costruttore vuoto.
	 */
	public Canile(){
	}
/***************** Metodi setter *****************/
	/**
	 * Metodo setter dell'attributo cani.
	 * @param index indice del canile in cui verrà inserito il cane.
	 * @param cane cane da inserire nel array di cani.
	 */
	private void setCani(int index, Cane cane){
		cani[index] = cane;
	}
/***************** Metodi getter *****************/
	/**
	 * Metodo getter dell'attributo cani.
	 * 
	 * @return cani presenti nel canile.
	 */
	public Cane[] getCani(){
		return cani;
	}
/***************** Metodi generali ***************/
	public static void main(String[] args) {
		Canile canile = new Canile();
		Bracco gimmy = new Bracco();
		
		gimmy.setPeso(40);
		gimmy.setRazza("Bracco");
		gimmy.stordisciPreda();
		canile.setCani(0, gimmy);

		Setter fufy = new Setter();

		fufy.setPeso(36);
		fufy.setRazza("Setter");
		fufy.ammazza();
		canile.setCani(1, fufy);

		PastoreTedesco rex = new PastoreTedesco();
		
		rex.setPeso(50);
		rex.setRazza("Pastore tedesco");
		rex.spaventa();
		canile.setCani(2, rex);
		
		Pitbull jhonny = new Pitbull();
		
		jhonny.setPeso(36);
		jhonny.setRazza("Pitbull");
		jhonny.intimidisci();
		canile.setCani(3, jhonny);
		
		Labrador finny = new Labrador();

		finny.setPeso(32);
		finny.setRazza("Labrador");
		finny.riporta();
		canile.setCani(4, finny);
		
		Maltese bobby = new Maltese();
		
		bobby.setPeso(5);
		bobby.setRazza("Maltese");
		bobby.salta();
		canile.setCani(5, bobby);

		Cane luis = new Cane("Beagle", 10);
		luis.mangia(2);

		CaneDaCaccia jason = new CaneDaCaccia();
		jason.setPeso(32);
		jason.setRazza("Sconosciuta");
		canile.setCani(6, jason);

		CaneDaGuardia sam = new CaneDaGuardia();
		sam.setPeso(23);
		sam.setRazza("Sconosciuta");
		canile.setCani(7, sam);

		CaneDaCompagnia fuffy = new CaneDaCompagnia();
		fuffy.setPeso(3);
		fuffy.setRazza("Sconosciuta");
		canile.setCani(8, fuffy);
	}
}