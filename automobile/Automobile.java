/**
 * Definisco la classe automobile. Un automobile è guidabile.
 *
 * @author Bryan Beffa
 * @version 24.12.2017
 */

public class Automobile{

/*************************************** Attributi *************************************************/	
	/**
	 * Attributo che indica le ruote dell'auto.
	 * Le ruote avranno i valori di default.
	 */
	private Ruota ruotaAuto = new Ruota();

	/**
	 * Attributo che indica la velocità dell'auto.
	 * Di default l'auto è ferma.
	 */
	private int velocita = 0;

	/**
	 * Attributo che indica i sedili dell'auto.
	 * Di default l'auto ha 4 sedili e sono in pelle vera.
	 */
	private Sedile sedileAuto = new Sedile(4, true);

	/**
	 * Attributo che indica il motore dell'auto.
	 * Di default il motore ha 6 cilindri ed è diesel.
	 */
	private Motore motore = new Motore(6, "diesel");

/*************************************** Metodi Setter *********************************************/
	/**
	 * Metodo setter dell'attributo velocita.
	 * La velocità non può essere negativa e non può essere maggiore di 200.
	 *
	 * @param velocita la velocità dell'auto.
	 * @param accelerazione indica se c'è un'accelerazione o no.
	 */
	private void setVelocita(int velocita, boolean accelerazione){
		if(accelerazione){
			this.velocita += velocita; 
		}else{
			if(velocita >= 0 && velocita <= 200){
				this.velocita = velocita;
			}
		}
	}
/*************************************** Metodi Getter *********************************************/
	/**
	 * Metodo che ritorna la velocità dell'automobile.
	 *
	 * @return la velocità dell'auto.
	 */
	public int getVelocita(){
		return velocita;
	}
/*************************************** Metodi Costruttori ****************************************/
	/**
	 * Metodo costruttore vuoto.
	 * L'automobile avrà tutti i valori di default.
	 */
	public Automobile(){
	}
/*************************************** Metodi generali *******************************************/	
	/**
	 * Metodo che descrive l'automobile e le sue componenti.
	 *
	 * @return la descrizione dell'automobile.
	 */
	public String descriviAuto(){
		return 	"Descrizione automobile:" + ruotaAuto.descrizioneRuote() + 
				sedileAuto.descrizioneSedili() + motore.descrizioneMotore();
	}

	/**
	 * Metodo che fa accelerare l'auto di quanto desiderato.
	 *
	 * @param velocita velocita da aggiungere alla velocita attuale.
	 */
	public void accelera(int velocita){
		if(velocita > 0){
			setVelocita(velocita, true);
			System.out.println("L'auto accelera di " + velocita);
		}else{
			System.out.println("Devi inserire un valore positivo");
		}
		System.out.println("L'auto sta andando a " + getVelocita() + " km/h");
	} 

	/**
	 * Metodo che fa fermare l'auto in movimento.
	 */
	public void frena(){
		setVelocita(0, false);
		System.out.println("L'auto si ferma");
	}

	/**
	 * Metodo che fa sterzare l'auto.
	 * Metodo che funziona solo se l'auto non è ferma.
	 *
	 * @param right l'auto gira a destra se il parametro è true, a sinistra se è false.
	 */
	public void sterzaDestra(boolean right){
		if(getVelocita()>0){
			if(right){
				System.out.println("L'auto gira a destra");
			}else{
				System.out.println("L'auto gira a sinistra");
			}
		}else{
			System.out.println("L'auto deve essere in movimento per poter sterzare");
		}
	}

	public static void main(String[] args) {
		Automobile audi = new Automobile();
		audi.sterzaDestra(true);
		audi.accelera(50);
		audi.accelera(50);
		audi.sterzaDestra(false);
		audi.frena();
		System.out.println(audi.descriviAuto());
	}
}