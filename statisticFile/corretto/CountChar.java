import java.io.*;
import java.nio.file.*;
import java.lang.String;
import java.util.*;

/**
 * Questa classe riceve un file con del testo e stampa su un altro file quante 
 * volte viene usato un carattere in ordine decrescente
 * @author Bryan Beffa
 * @version 14.12.2017
 */
public class CountChar{

	/**
	 * Metodo che serve a creare il file di statistiche.
	 *
	 * @param fileName nome del file che il metodo crea.
	 */
	public static void createFile(String fileName){
		String path = fileName + "_statistic.txt";
		Path p = Paths.get(path);
		
        File file = new File(path);
	}

	/**
	 * Metodo che scrive nel file creato le statistiche.
	 *
	 * @param caratteri array di caratteri del testo passato da linea di comando.
	 * @param fileName nome del file in cui andremo a scrivere le statistiche.
	 */
	public static void writeFile(byte[] caratteri, String fileName){
		Path pathFile = Paths.get(fileName);
		int[] contatore = countCharTimes(caratteri);
		//long t0= System.currentTimeMillis(); 
		StringBuilder risultato = new StringBuilder();
		ArrayList<String> lines = new ArrayList<String>();

		for(int i =0; i<contatore.length;i++){
			risultato.append((char)('a'+i) + ": " + contatore[i] + "\n");
		}

		

		String ris = risultato.toString();
		lines.add(ris);

		System.out.println(ris);
		try{
			Files.write(pathFile ,lines);
		}catch(IOException ioe){
			System.out.println("Errore nella scrittura del file");
		}
		//long t1= System.currentTimeMillis(); 
		//System.out.println(t1-t0 + " Millisecondi per scrivere nel file");
	}

	/**
	 * Metodo che conta quante volte è presente un carattere nel testo.
	 * @param bytes array di char in cui si conta la frequenza di un determinato carattere.
	 *
	 * @return numero di volte che il carattere è presente nel testo.
	 */
	public static int[] countCharTimes(byte[] bytes){
		//long t0= System.currentTimeMillis(); 
		int[] risultato = new int[26];

		for(int i=0; i<bytes.length; i++){
			if((bytes[i]> 64 && bytes[i] < 91) || (bytes[i] > 96 && bytes[i] < 123)){
				byte noCase = bytes[i];
				if(noCase > 64 && noCase < 91){
					noCase += 32;
				}

				risultato[noCase-(byte)'a']++;
			}
		}
		//long t1= System.currentTimeMillis(); 
		//System.out.println(t1-t0 + " Millisecondi per calcolare la frequenza delle lettere"); 
		return risultato;
	}

	/**
	 * Metodo che conta quante volte è presente un carattere nel testo in percentuale.
	 * @param caratteri array di char in cui si conta la frequenza di un determinato carattere.
	 * @param offset indice del carattere di cui si andrà a contare la frequenza.
	 *
	 * @return percentuale del carattere presente nel testo.
	 */
	public static double charPercentuale(char[] caratteri, int offset){
		double numeratore = 0.0;
		double denominatore = caratteri.length;
		String off = caratteri[offset] + "";

		for(int i = 0; i<caratteri.length; i++){
			String car = caratteri[i] + "";
			if(car.equalsIgnoreCase(off)){
				numeratore += 1.0;
			}
		}

		double risultato = (numeratore/denominatore*100.0)+0.05;
		risultato *= 10;
		int ris = (int)risultato;
		risultato = ris/10.0;
		return risultato;
	}

	public static void main(String[] args) {
		long t0= System.currentTimeMillis(); 
		if(args.length > 0){
			Path p = Paths.get(args[0]);
			if(!Files.notExists(p) && !Files.exists(p)){
				System.out.println("Lettura sorgente impossibile");
			}else if(Files.exists(p)){
				if(Files.isReadable(p)){
					try{
						String fileName = "testo_statistic.txt";
						Path filePath = Paths.get(args[0]);
						
						//long t2= System.currentTimeMillis(); 
						byte[] bytes = Files.readAllBytes(filePath);
						//long t3= System.currentTimeMillis();
						//System.out.println(t3-t2 + " Millisecondi per la lettura del file");

						createFile(fileName);
						
						writeFile(bytes, fileName);

					}catch(IOException ioe){

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
		long t1= System.currentTimeMillis(); 
		System.out.println(t1-t0 + " Millisecondi per l'secuzione dell'intero programma");
	}
}