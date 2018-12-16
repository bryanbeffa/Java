import java.nio.file.*;
import java.io.*;
import java.lang.*;

/**
 * Questa classe riceve tramite percorso di un file bitmap i byte che lo compongono.
 * Stampa le proprietà del file.
 * Per ogni pixel stampa le componenti RGB e la gray scale.
 *
 * @author Bryan Beffa
 * @version 01.11.2017
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
	 * Metodo che fa little encoding dei byte passati come argomento e ritorna il numero in decimale.
	 *
	 * @param offset offset che indica il numero dell'indice da cui iniziare ad invertire i byte.
	 * @param len len indica il numero di byte da girare.
	 * @return il numero ottenuto in decimale dopo aver fatto il little encoding.
	 */
	public long getLong(int offset, int len){
		
		long value = 0;
		for(int i = offset; i< offset + len; i++){
			value = value | data[i] << (8*(i-offset));
		}
		return value;
	}

	/**
	 * Metodo che ritorna il la stringa contenente la signature del file binario.
	 *
	 * @return la signature del file binario.
	 */
	public String getSignature(){
		long[] bytes = convertDataToLongArray();
		
		long firstLetter = bytes[0];
		char firstChar = (char)firstLetter;
		long secondLetter = bytes[1];
		char seconChar = (char)secondLetter;

		String ris = firstChar + "" + seconChar;
		return ris;
	}

	/**
	 * Metodo che ritorna un numero long che indica i byte totali del file.
	 *
	 * @return numero di byte totali del file.
	 */
	public long getFileSize(){
		long[] bytes = convertDataToLongArray();
	
		long value = getLong(2, 4);
	
		return value;
	}

	/**
	 * Metodo che ritorna il codice del campo riservato1.
	 *
	 * @return il codice situato nel campo riservato1.
	 */
	public long getReserved1(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(6, 2);

		return value;		
	}

	/**
	 * Metodo che ritorna il codice del campo riservato2.
	 *
	 * @return il codice situato nel campo riservato2.
	 */
	public long getReserved2(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(8, 2);

		return value;		
	}

	/**
	 * Metodo che ritorna il numero di byte da saltare fino ad arrivare al
	 * primo byte che indica l'inizio della sequenza corrispondenti ai pixel.
	 *
	 * @return numero byte da saltare.
	 */
	public long getFileOffset(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(10, 4);

		return value;		
	}

	/**
	 * Metodo che ritorna il numero che indica la grandezza del DIB header.
	 *
	 * @return la grandezza del DIB header.
	 */
	public long getDibHeaderSize(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(14, 4);

		return value;		
	}

	/**
	 * Metodo che ritorna la larghezza del file.
	 *
	 * @return la larghezza dell'immagine.
	 */
	public long getWidth(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(18, 4);

		return value;
	}
	
	/**
	 * Metodo che ritorna l'altezza del file.
	 *
	 * @return la l'altezza dell'immagine.
	 */
	public long getHeight(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(22, 4);

		return value;
	}

	/**
	 * Metodo che ritorna la larghezza del file.
	 *
	 * @return la l'altezza dell'immagine.
	 */
	public long getPlanes(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(26, 2);

		return value;
	}

	/**
	 * Metodo che ritorna i bits per pixel del file binario.
	 *
	 * @return bits per pixel del file binario.
	 */
	public long getBitsPerPixel(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(28, 2);

		return value;
	}

	/**
	 * Metodo che ritorna il numero che indica la compressione.
	 *
	 * @return la compressione.
	 */
	public long getCompression(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(30, 4);

		return value;
	}
	

	/**
	 * Metodo che ritorna i byte che indicano la grandezza del file.
	 *
	 * @return byte che la grandeezza del file.
	 */
	public long getImageSize(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(34, 4);

		return value;
	}

	/**
	 * Metodo che ritorna il numero di pixel dell'asse x per metro.
	 *
	 * @return numero di pixel sull'asse x per metro.
	 */
	public long getXPixelsPerMeter(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(38, 4);

		return value;
	}

	/**
	 * Metodo che ritorna il numero di pixel dell'asse y per metro.
	 *
	 * @return numero di pixel sull'asse y per metro.
	 */
	public long getYPixelsPerMeter(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(42, 4);

		return value;
	}

	/**
	 * Metodo che ritorna il numero di colori presenti nella tabella del colore.
	 *
	 * @return il numero di colori presenti nella tabella del colore.
	 */
	public long getColorsInColorTable(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(46, 4);

		return value;
	}

	/**
	 * Metodo che ritorna l'important color count.
	 *
	 * @return important color count.
	 */
	public long getImportantColorCount(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(50, 4);

		return value;
	}

/*************************************** Metodi generali ***********************************************/
	
	/**
	 * Metodo che converte l'array di tipo byte in tipo long.
	 *
	 * @return array di bytes del file.
	 */
	public long[] convertDataToLongArray(){ 
		long[] byteHex = new long[data.length];
		for(int i=0; i < data.length ; i++){
			byteHex[i] = data[i]&0xFF;
		}
		return byteHex;
	}

	public void dumpPixelsRGB(){
		long[] bytes = convertDataToLongArray();
		long[][] immagine = new long[(int)getHeight()][(int)getWidth()*3];

		long numPixels = getWidth() * getHeight();
		int padding = 0;
		if(getWidth()%4 == 1){
			padding = 1;
		}else if(getWidth()%4 == 2){
			padding = 2;	
		}else if(getWidth()%4 == 3){
			padding = 3;
		}
		int totPadding = padding*(int)getHeight();
		int offset = (int)getFileOffset();

		for(int o=0 ; o< getHeight() ; o++){
			for(int j=0 ; j< getWidth()*3 ; j++){
				for(int i =0; i<3 ; i++){
					immagine[o][j+i]= bytes[offset+(2-i)];
				}
				offset += 3;
				j+=2;
			}
			offset+=padding;
		}

		for(int i= immagine.length-1; i> -1; i--){
			for(int j= 0; j< immagine[i].length; j++){
				if(immagine[i][j] < 10){
						System.out.print(" ");
				}else if(immagine[i][j] < 100){
						System.out.print(" ");
				}
				try{
					System.out.print(Long.toHexString(immagine[i][j]) + " ");
				}catch(NumberFormatException nfe){
				}
				if((j+1)%3 == 0){
					System.out.print("| ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Metodo che stampa per ogni pixel le componenti RGB.
	 */
	public void dumpPixelsGrayScale(){
		long[] bytes = convertDataToLongArray();
		int offset = (int)getFileOffset();
		long numPixels = getWidth() * getHeight();
		int padding = 0;
		int gray = 0;
		
		if(getWidth()%4 == 1){
			padding = 1;
		}else if(getWidth()%4 == 2){
			padding = 2;	
		}else if(getWidth()%4 == 3){
			padding = 3;
		}

		for(int o=0 ; o< getHeight() ; o++){
			for(int j=0 ; j< getWidth() ; j++){
				gray = 0;

				for(int i =0; i< 3; i++){
					gray += bytes[offset+i];
				}
				
				gray /=3;

				if(gray < 100){
					System.out.print("#");
				}else if(gray > 100){
					System.out.print(".");
				}

				System.out.print(" | ");
				offset += 3;
			}
			System.out.println("");
			offset+= padding;
		}
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
						BitMapModel bmp = new BitMapModel(bytes);
						
						System.out.print("Signature: ");
						System.out.println(bmp.getSignature()); //funge

						System.out.print("File size: ");
						System.out.println(bmp.getFileSize());

						System.out.print("Riservato1: ");
						System.out.println(bmp.getReserved1()); //funge

						System.out.print("Riservato2: ");
						System.out.println(bmp.getReserved2()); //funge

						System.out.print("File Offset to PixelArray: ");
						System.out.println(bmp.getFileOffset());
						
						System.out.print("DIB Header Size: ");
						System.out.println(bmp.getDibHeaderSize());

						System.out.print("Larghezza file: ");
						System.out.println(bmp.getWidth());

						System.out.print("Altezza file: ");
						System.out.println(bmp.getHeight());

						System.out.print("Planes: ");
						System.out.println(bmp.getPlanes());

						System.out.print("Bits per Pixel: ");
						System.out.println(bmp.getBitsPerPixel());

						System.out.print("Compressione: ");
						System.out.println(bmp.getCompression());

						System.out.print("Image Size: ");
						System.out.println(bmp.getImageSize());

						System.out.print("X Pixels per metro: ");
						System.out.println(bmp.getXPixelsPerMeter());

						System.out.print("Y Pixels per metro: ");
						System.out.println(bmp.getYPixelsPerMeter());
						
						System.out.print("Colors in color table: ");
						System.out.println(bmp.getColorsInColorTable());

						System.out.print("Important Color Count: ");
						System.out.println(bmp.getImportantColorCount());

						System.out.println("Pixel color RGB: ");
						bmp.dumpPixelsRGB();

						System.out.println("Gray Scale: ");
						bmp.dumpPixelsGrayScale();

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
			System.out.println("ERRORE: fornire il percorso del file binario");
		}
	}

}