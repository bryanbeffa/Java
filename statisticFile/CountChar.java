import java.io.*;
import java.nio.file.*;
import java.lang.String;
import java.util.ArrayList;

/**
 * Questa classe riceve un file con del testo e stampa su un altro file quante 
 * volte viene usato un carattere in ordine decrescente
 * @author Bryan Beffa
 * @version 07.12.2017
 */
public class CountChar{

	/**
	 * Metodo che serve a creare il file di statistiche.
	 *
	 * @param fileName nome del file che il metodo crea.
	 */
	public static void createFile(String fileName){
		String path = fileName;
		Path p = Paths.get(path);
		try{
        	File file = new File(path);
         	if (file.exists()){
			    Files.delete(p);
        	}else if (file.createNewFile()){
            	System.out.println("Il file è stato creato con successo");
        	}else{
            	System.out.println("Il file non è stato creato");
        	}
  	 	}catch(IOException ioe){
        	System.out.println("Errore nella creazione del file");
        }
	}

	/**
	 * Metodo che scrive nel file creato le statistiche.
	 *
	 * @param caratteri array di caratteri del testo passato da linea di comando.
	 * @param fileName nome del file in cui andremo a scrivere le statistiche.
	 */
	public static void writeFile(char[] caratteri, String fileName){
		Path file = Paths.get(fileName);
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Char:\tVolte:\tPercentuale:");
		for(int i=0; i<caratteri.length; i++){
			if(countCharTimes(caratteri, i) != 0){
				lines.add(caratteri[i] + "\t\t" + countCharTimes(caratteri, i) + "\t\t" + charPercentuale(caratteri, i) + "%");
			}
		}
		

		try{
			Files.write(file, lines);
		}catch(IOException ioe){
			System.out.println("Errore nella scrittura del file");
		}	
	}

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
	 * Metodo che conta quante volte è presente un carattere nel testo.
	 * @param bytes array di char in cui si conta la frequenza di un determinato carattere.
	 * @param offset indice del carattere di cui si andrà a contare la frequenza.
	 *
	 * @return numero di volte che il carattere è presente nel testo.
	 */
	public static int countCharTimes(char[] caratteri, int offset){
		int risultato = 0;
		String off = caratteri[offset] + "";

		for(int i = 0; i<caratteri.length; i++){
			String car = caratteri[i] + "";
			int check = 0;
			for(int j = 0; j<offset; j++){
				String carControll = caratteri[j] + "";
				if(car.equalsIgnoreCase(carControll)){
					check++;
				}
			}
			if(car.equalsIgnoreCase(off) && check == 0){
				risultato++;
			}
		}

		return risultato;
	}

	/**
	 * Metodo che conta quante volte è presente un carattere nel testo in percentuale.
	 * @param bytes array di char in cui si conta la frequenza di un determinato carattere.
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
						Path filePath = Paths.get(args[0]);
						byte[] bytes = Files.readAllBytes(filePath);
						char[] caratteri = convertToChar(bytes);
						createFile("./testo_statistics.txt");
						writeFile(caratteri, "./testo_statistics.txt");
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
		System.out.println(t1-t0 + " Millisecondi");
	}
}