import java.io.*;
import java.nio.*;

/**
 * Realizza la classe ByteDecipher utile per decodificare il codice SBRSE. 
 *
 * @author Bryan Beffa
 * @version 01.12.2017
 */

public class ByteDecipher{

	/**
	 * Metodo che ritorna il valore (0 o 1) del bit nella posizione
	 * pos nel byte value. Se la posizione specificata da pos non è valida ritorna 0.
	 * @param pos posizione del bit da leggere del byte value.
	 * @param value valore del byte da cui si andrà a leggere il bit nella posizione pos.
	 *  
	 * @return il valore del bit nella posizione pos.
	 */
	public static int getBit(int pos, byte value){
		if(pos >= 0 && pos <= 7){
			int valore=0;
			pos = 1 << pos;
			valore = value&pos;
			if(valore != 0) {
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	/**
	 * Metodo che riceve un array di 9 byte contenenti la codifica
	 * SBRSE di un byte e ritorna in valore decodificato.
	 * @param encoded byte codificato da decodificare.
	 *
	 * @return byte decodificato.
	 */
	public static byte decipherByte(byte[] encoded){
		int risultato = 0;

		for(int i = 1; i<encoded.length ; i++){
			int pos = encoded[i];
			risultato = risultato | getBit(encoded[i], encoded[0]) << (i-1);
		}

		byte ris = (byte)risultato;
		return ris;
	}


	/**
	 * Metodo che riceve un array contenente un sequenza di 	 
	 * 9 * N byte codificati e ritorna un array contenente N byte decodificati.
	 *
	 * @param data array di byte codificati.
	 */
	public static byte[] decipherBytes(byte[] data){
		byte[] valore = new byte[data.length/9];

		for(int i= 0; i<data.length/9; i++){
			byte[] bytes = new byte[9];
		
			for(int j=0; j<9; j++){
				bytes[j] = data[j+(9*i)];
			}

			valore[i] = decipherByte(bytes);
		}

		return valore;
	}
}
