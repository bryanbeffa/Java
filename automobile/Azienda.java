/**
 * Definisco la classe azienda.
 * Un'azienda ha delle auto.
 * Un'azienda ha degli impiegati.
 *
 * @author Bryan Beffa
 * @version 31.12.2017
 */

public class Azienda{
/*************************************** Attributi *************************************************/
	/**
	 * Attributo che indica il nome dell'azienda.
	 */
	private String nome;

	/**
	 * Attributo che indica il numero di impiegati nell'azienda
	 * Il valore di default è di 3 impiegati.
	 */
	private int numDipendenti = 3;
/*************************************** Metodi Setter *********************************************/
	/**
	 * Metodo setter dell'attributo nome.
	 * Un nome può contenere qualsiasi carattere.
	 * Un nome non può essere nullo. 
	 *
	 * @param nome nome dell'azienda.
	 */
	private void setNome(String nome){
		if(nome.equals("")){
			System.out.println("L'azienda deve avere un nome.");
		}
	}

	/**
	 * Metodo setter dell'attributo numDipendenti.
	 *
	 * @param numDipendenti numero dei dipendenti da settare.
	 */
	public void setNumDipendenti(int numDipendenti){
		if(numDipendenti >= 0){
			this.numDipendenti = numDipendenti;
		}
	}
/*************************************** Metodi Getter *********************************************/
	/**
	 * Metodo getter dell'attributo numDipendenti,
	 *
	 * @return numero di dipendenti dell'azienda.
	 */
	public int getNumeroDipendenti(){
		return numDipendenti;
	}

	/**
	 * Metodo getter dell'attributo nome.
	 *
	 * @return nome dell'azienda
	 */
	public String getNome(){
		return nome;
	}
/*************************************** Metodi Costruttori ****************************************/
	/**
	 * Metodo costruttore che necessita tutti gli attributi.
	 * Un'azienda necessita sempre di un nome.
	 *
	 * @param nome nome dell'azienda
	 * @param numDipendenti numero di dipemdemti dell'azienda.
	 */
	public Azienda(String nome, int numDipendenti){
		setNome(nome);
		setNumDipendenti(numDipendenti);
	}

/*************************************** Metodi generali *******************************************/
	/**
	 * Metodo che licenza n dipendenti.
	 *
	 * @param numLicenziati numero di persone che si desidera licenziare.
	 */
	public void licenzia(int numLicenziati){
		if(numLicenziati>0){
			if((getNumeroDipendenti()-numLicenziati) >= 0){
				setNumDipendenti((getNumeroDipendenti()-numLicenziati));
			}
		}
	}

	/**
	 * Metodo che assume n dipendenti.
	 *
	 * @param numAssunti numero di persone che si desidera assumono.
	 */
	public void assume(int numAssunti){
		if(numAssunti > 0){
			int totDipenenti = numAssunti + getNumeroDipendenti();
			setNumDipendenti(totDipenenti);
		}
	}
}