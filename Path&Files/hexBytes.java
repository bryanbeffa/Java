import java.nio.file.*;
import java.io.*;

/**
 * Definisco la classe hexBytes che converte un file binario in un file contenente i bytes espressi in esadecimale.
 *
 * @author Bryan Beffa
 * @version 01.11.2017
 */

public class hexBytes{

	public static void main(String[] args) {
		if(args.length > 0){
			String path = args[0];
			Path p = Paths.get(path);
			if(Files.exists(p)){
				if(Files.isReadable(p)){
					try{
						byte[] bytes = Files.readAllBytes(p);
						for(int i=0; i < bytes.length ; i++){
							for(int o=0 ; o <10 ; o++){
								if(o==4){
									System.out.print(" ");
								}
								//String hexByte = Integer.toHexString(bytes[i]);
								//System.out.print(hexByte);
								System.out.print(bytes[i]);
							}
							System.out.println("");
						}
					}catch (IOException ex){
						System.out.println("Errore nella lettura del file");
					}
				}else{
					System.out.println("Il file specificato nel percorso \"" + p + "\" non è leggibile");	
				}
			}else{
				System.out.println("Il file nel percorso specificato \"" + p + "\" non esiste");
			}

		}else{
			System.out.println("Errore: specificare il percorso del file da convertire");
		}
	}
}