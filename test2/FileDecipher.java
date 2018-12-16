import java.io.*;
import java.nio.file.*;

/**
 * L’applicativo FileDecipher serve per decifrare un file di testo cifrato in SBRSE. 
 * Riceve il percorso del file
 * cifrato come argomento e ne stampa a terminale il contenuto decifrato
 *
 * @author Bryan Beffa
 * @version 27.11.2017
 */

public class FileDecipher{
	

	/**
	 * Questo metodo converte da array di byte a array di char.
	 * @param bytes array di bytes da convertire in array di char.
	 *
	 * @return array di caratteri.
	 */
	public static char[] convertToChar(byte[] bytes){
		char[] caratteri = new char[bytes.length];

		for(int i = 0; i< caratteri.length; i++){
			caratteri[i] = (char)bytes[i];
		}

		return caratteri;
	}

	/**
	 * Metodo che serve a stampare l'array di caratteri.
	 * @param bytes array di caratteri da stampare.
	 */
	public static void printArray(char[] bytes){
		for(int i =0; i< bytes.length; i++){
			System.out.print(bytes[i]);
		}
	}

	public static void main(String[] args) {
		if(args.length > 0){
			Path p = Paths.get(args[0]);
			if(!Files.notExists(p) && !Files.exists(p)){
				System.out.println("Lettura sorgente impossibile");
			}else if(Files.exists(p)){
				if(Files.isReadable(p)){
					try{
						byte[] bytes = Files.readAllBytes(p);
						ByteDecipher prova = new ByteDecipher();
						byte[] decoded =ByteDecipher.decipherBytes(bytes);
						char[] caratteri = convertToChar(decoded);
						printArray(caratteri);
					}catch(IOException ioe){
						System.out.println("Lettura sorgente fallita");
					}
				}else{
					System.out.println("Lettura sorgente impossibile");
				}
			}else{
				System.out.println("Lettura sorgente impossibile");
			}
		}else{
			System.out.println("Utilizzo: java FileDecipher <sorgente>");
		}
	}
}