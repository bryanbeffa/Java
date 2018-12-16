/**
 * Definisco la classe Robot.
 * Un robot ha due braccia, due gambe, una testa e un torso.
 * Ha la possibilità di possedere fino a 5 armi.
 * @author Bryan Beffa
 * @version 27.01.2018
 */
public class Robot{
	/**
	 * Attributo che indica il braccio destro del robot.
	 */
	private Arm rightArm = new Arm();

	/**
	 * Attributo che indica il braccio sinistro del robot.
	 */
	private Arm leftArm = new Arm();

	/**
	 * Attributo che indica la gamba destra del robot.
	 */
	private Leg rightLeg = new Leg();

	/**
	 * Attributo che indica la gamba sinistra del robot.
	 */
	private Leg leftLeg = new Leg();

	/**
	 * Attributo che indica la testa del robot.
	 */
	private Head head = new Head();

	/**
	 * Attributo che indica il torso del robot.
	 */
	private Torso torso = new Torso();

	/**
	 * Attributo che indica i piloti del robot.
	 */
	private Pilot[] pilots = new Pilot[2];

	/**
	 * Attributo che indica il comandante del robot.
	 */
	private Commander commander = new Commander();

	/**
	 * Attributo che indica le armi del robot.
	 */
	private Weapon[] weapons = new Weapon[5];

	/**
	 * Metodo che ritorna i piloti del robot.
	 * 
	 * @return i piloti del robot.
	 */
	public Pilot[] getPilots(){
		return pilots;
	}

	/**
	 * Metodo che ritorna il comandante del robot.
	 * 
	 * @return il comandante del robot.
	 */
	public Commander getCommander(){
		return commander;
	}

	/**
	 * Metodo setter del attributo pilots
	 * 
	 * @param pilot pilota del robot.
	 * @param index indice del pilota da inserire.
	 */
	public void setPilots(int index, Pilot pilot){
		pilots[index] = pilot;
	}

	/**
	 * Metodo setter dell'attributo commander
	 * 
	 * @param commander comandante del robot.
	 */
	public void setCommander(Commander commander){
		this.commander = commander;
	}

	/**
	 * Metodo che aggiunge un'arma al robot.
	 * 
	 * @param weapon arma da aggiungere al robot.
	 * @param index indice dell'arma da inserire.
	 */
	public void addWeapon(int index, Weapon weapon){
		weapons[index] = weapon;
	}

	/**
	 * Metodo che rimuove un'arma al robot.
	 * 
	 * @param index indice dell'arma da rimuovere.
	 */
	public void removeWeapon(int index){
		weapons[index] = null;
	}

	/**
	 * Metodo getter dell'attributo weapons.
	 *
	 * @return armi del robot.
	 */
	public Weapon[] getWeapons(){
		return weapons;
	}

	/**
	 * Meotodo costruttore della classe Robot.
	 * Non richiede parametri.
	 */
	public Robot(){
	}

	public static void main(String[] args) {
		Robot robot = new Robot();
		
		//Stampo le armi del robot
		System.out.println("\nArmi del robot:");
		for(int i=0; i<robot.weapons.length; i++){
			System.out.println(robot.weapons[i]);
		}

		//aggiungo un arma
		SwissKnife coltello = new SwissKnife();
		robot.addWeapon(1, coltello);

		PhotonicGun pistola = new PhotonicGun();
		robot.addWeapon(4, pistola);

		//Stampo le armi del robot
		System.out.println("\nArmi del robot:");
		for(int i=0; i<robot.weapons.length; i++){
			System.out.println(robot.weapons[i]);
		}

		//rimuovo un'arma
		robot.removeWeapon(4);

		//Stampo le armi del robot
		System.out.println("\nArmi del robot:");
		for(int i=0; i<robot.weapons.length; i++){
			System.out.println(robot.weapons[i]);
		}

		//setto un pilota
		Pilot pilOne = new Pilot();
		robot.setPilots(1, pilOne);

		//Stampo i piloti del robot
		System.out.println("\nPiloti del robot:");
		for(int i=0; i<robot.pilots.length; i++){
			System.out.println(robot.pilots[i]);
		}

		//setto un comandante
		Commander comandante = new Commander();
		robot.setCommander(comandante);

		//Stampo i piloti del robot
		System.out.println("\nComandante del robot:");
		System.out.println(robot.getCommander());
	}
}