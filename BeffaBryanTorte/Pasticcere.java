/**
 * Definisco la classe Pasticcere.
 * La classe Pasticcere contiene solo il metodo main e serve per testare il buon funzionamento delle altre classi.
 *
 * @author Bryan Beffa
 * @version 29.01.2018
 */

public class Pasticcere{
	public static void main(String[] args) {
		Forno forno = new Forno();
		TortaMargherita torta = new TortaMargherita();

		System.out.println(forno.toString());
		System.out.println(torta.toString());

		CrostataMele crostataDiMele = new CrostataMele();
		forno.accendi();
		forno.setTemperatura(190);
		forno.inforna(crostataDiMele);
		System.out.println("\n"+forno.toString());
		System.out.println(crostataDiMele.toString());

		Crostata crostata = new Crostata();
		forno.setTemperatura(250);
		forno.inforna(crostata);
		System.out.println("\n"+forno.toString());
		System.out.println(crostata.toString());

		Crostata crostataUno = new Crostata();
		forno.spegni();
		forno.setTemperatura(250);
		forno.inforna(crostataUno);
		System.out.println("\n"+forno.toString());
		System.out.println(crostataUno.toString());
	}
}