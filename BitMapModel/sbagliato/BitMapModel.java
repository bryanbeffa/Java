import java.nio.file.*;
import java.io.*;

/**
 * Questa classe riceve il percorso in cui è situato un file e ne ricava i suoi byte in esadecimale.
 * Stampa i dati dei vari header del file. 
 *
 * @author Bryan Beffa
 * @version 07.11.2017
 */

public class BitMapModel{

/*************************************** Attributi *****************************************************/
	
	/**
	 * Array di byte che ricaviamo da un file binario.
	 */
	private byte[] data;

/*************************************** Metodi costruttori ********************************************/

	/**
	 * Metodo costruttore se viene fornito l'array di byte del file binario.
	 *
	 * @param data data è l'array di byte del file binario.
	 */
	public BitMapModel(byte[] data){
		this.data = data;
	}

/*************************************** Metodi getter *************************************************/
	
	/**
	 * Metodo che ritorna il numero di byte da saltare da inizio file per ricavare 
	 * l'inizio dei byte riferiti ai pixel.
	 *
	 * @return numero di byte da saltare per iniziare a leggere i byte dei pixel dell'immagine.
	 */
	public String getSignature(){

		long[] bytes = convertDataToLongArray();
		String risultato = "";

		//trasformo il numero in una stringa esadecimale
		for(int i =0; i < 2; i++){

			try{
				risultato += Long.toHexString(bytes[i]) ;
	
				}catch(NumberFormatException nfe){
					System.out.println("ERRORE: impossibile convertire in un numero intero");
			}
		}

		return risultato;
	}

	/**
	 * Metodo che ritorna un numero long che indica i byte totali del file.
	 *
	 * @return numero di byte totali del file.
	 */
	public String getFileSize(){

		String risultato = "";

		long ris = getBytesAsLong(2, 4);

		try{
			risultato = Long.toHexString(ris);
		}catch(NumberFormatException nfe){
			System.out.println("ERRORE: impossibile convertire in un numero intero");
		}

		return risultato;
	}

	/**
	 * Metodo che ritorna il codice del campo riservato1.
	 *
	 * @return il codice situato nel campo riservato1.
	 */
	public String getReserved1(){
		String risultato = "";

		long ris = getBytesAsLong(6, 2);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna il codice del campo riservato2.
	 *
	 * @return il codice situato nel campo riservato2.
	 */
	public String getReserved2(){
		String risultato = "";

		long ris = getBytesAsLong(8, 2);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna il numero di byte da saltare fino ad arrivare al
	 * primo byte che indica l'inizio della sequenza corrispondenti ai pixel.
	 *
	 * @return numero byte da saltare.
	 */
	public long getFileOffset(){

		long ris = getBytesAsLong(10, 4);

		return ris;
	}

	/**
	 * Metodo che ritorna la larghezza del file.
	 *
	 * @return la larghezza dell'immagine.
	 */
	public String getWidth(){
		String risultato = "";

		long ris = getBytesAsLong(18, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna la larghezza del file.
	 *
	 * @return la l'altezza dell'immagine.
	 */
	public String gethHeight(){
		String risultato = "";

		long ris = getBytesAsLong(22, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna i planes del file binario.
	 *
	 * @return i byte che indicano i planes.
	 */
	public String getPlanes(){
		String risultato = "";

		long ris = getBytesAsLong(26, 2);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna i bits per pixel del file binario.
	 *
	 * @return bits per pixel del file binario.
	 */
	public String getBitsPerPixel(){
		String risultato = "";

		long ris = getBytesAsLong(28, 2);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna i byte che indicano la compressione.
	 *
	 * @return byte che indicano la compressione.
	 */
	public String getCompression(){
		String risultato = "";

		long ris = getBytesAsLong(30, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna i byte che indicano la grandezza del file.
	 *
	 * @return byte che la grandeezza del file.
	 */
	public String getImageSize(){
		String risultato = "";

		long ris = getBytesAsLong(34, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna il numero di pixel dell'asse x per metro.
	 *
	 * @return numero di pixel sull'asse x per metro.
	 */
	public String getXPixelsPerMeter(){
		String risultato = "";

		long ris = getBytesAsLong(38, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna il numero di pixel dell'asse y per metro.
	 *
	 * @return numero di pixel sull'asse y per metro.
	 */
	public String getYPixelsPerMeter(){
		String risultato = "";

		long ris = getBytesAsLong(42, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna il numero di colori presenti nella tabella del colore.
	 *
	 * @return il numero di colori presenti nella tabella del colore.
	 */
	public String getColorsInColorTable(){
		String risultato = "";

		long ris = getBytesAsLong(46, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}

	/**
	 * Metodo che ritorna l'important color count.
	 *
	 * @return important color count.
	 */
	public String getImportantColorCount(){
		String risultato = "";

		long ris = getBytesAsLong(50, 4);
		risultato = Long.toHexString(ris);

		return risultato;
	}
/*************************************** Metodi generali ***********************************************/

	/**
	 * Metodo che converte l'array di tipo byte in tipo long.
	 *
	 * @return array di bytes del file.
	 */
	public long[] convertDataToLongArray(){ 
		long[] byteHex = new long [data.length];
		for(int i=0; i < byteHex.length; i++){
			byteHex[i] = data[i]&0xFF;
		}
		return byteHex;
	}



	/**
	 * Metodo che fa little encoding dei byte passati come argomento e ritorna il numero in decimale.
	 *
	 * @param offset offset che indica il numero dell'indice da cui iniziare ad invertire i byte.
	 * @param length lenght che indica quanti sono i byte da girare.
	 * @return il numero ottenuto in decimale dopo aver fatto il little encoding.
	 */
	public long getBytesAsLong(int offset, int lenght){
		
		//converto l'array di byte in un array di tipo long
		long[] bytes = convertDataToLongArray();
		
		//eseguo il little encoding
		for(int i=0; i<lenght/2; i++){
			long memoria = bytes[offset+i];
			bytes[offset+i] = bytes[offset+(lenght-1)-i];
			bytes[offset+lenght-1-i] = memoria;
		}

		String num = "";
		
		//trasformo il numero in una stringa esadecimale
		for(int i =0; i < lenght; i++){

			try{
				num += Long.toHexString(bytes[offset+i]) ;
	
				}catch(NumberFormatException nfe){
					System.out.println("ERRORE: impossibile convertire in un numero intero");
			}
		}

		Long risultato = (long)0;

		//trasformo la stringa nel risultato finale
		try{
				risultato = Long.parseLong(num, 16);
	
		}catch(NumberFormatException nfe){
					System.out.println("ERRORE: impossibile convertire in un numero intero");
		} 

		
		return risultato;
	}


	public static void main(String[] args) {
		if(args.length > 0){
			String path = args[0];
			Path p = Paths.get(path);
			if(!Files.exists(p) && !Files.notExists(p)){
				System.out.println("Errore: file irriconoscibile");
			}else if(Files.exists(p)){
				if(Files.isReadable(p)){

					try{
						byte[] bytes = Files.readAllBytes(p);
						BitMapModel bmpFile = new BitMapModel(bytes);
						System.out.print("Signature: ");
						System.out.println(bmpFile.getSignature());
						System.out.print("File size: ");
						System.out.println(bmpFile.getFileSize());
						System.out.print("Riservato1: ");
						System.out.println(bmpFile.getReserved1());
						System.out.print("Riservato2: ");
						System.out.println(bmpFile.getReserved2());
						System.out.print("File offset: ");
						System.out.println(bmpFile.getFileOffset());
						System.out.print("Larghezza immagine: ");
						System.out.println(bmpFile.getWidth());
						System.out.print("Altezza immagine: ");
						System.out.println(bmpFile.gethHeight());
						System.out.print("Planes: ");
						System.out.println(bmpFile.getPlanes());
						System.out.print("Bits per pixel: ");
						System.out.println(bmpFile.getBitsPerPixel());
						System.out.print("Compression: ");
						System.out.println(bmpFile.getCompression());
						System.out.print("Image Size: ");
						System.out.println(bmpFile.getImageSize());
						System.out.print("X pixels per meter: ");
						System.out.println(bmpFile.getXPixelsPerMeter());
						System.out.print("Y pixels per meter: ");
						System.out.println(bmpFile.getYPixelsPerMeter());
						System.out.print("Colors in color table: ");
						System.out.println(bmpFile.getColorsInColorTable());
						System.out.print("Important color count: ");
						System.out.println(bmpFile.getImportantColorCount());
					}catch (IOException ex){
						System.out.println("Errore nella lettura del file");
					}
				}else{
					System.out.println("Il file specificato nel percorso \"" + p + "\" non è leggibile");	
				}

			}else{
				System.out.println("Errore Il file non esiste");
			}
		}else{
			System.out.println("Errore: specificare il percorso del file da convertire");
		}
	}
}