import java.nio.file.*;
import java.io.*;

public class prova{
	
	public long[] convertDataToLongArray(){ 
		long[] byteHex = new long[data.length];
		for(int i=0; i < data.length ; i++){
			byteHex[i] = data[i]&0xFF;
		}
		return byteHex;
	}
	public static void main(String[] args) {
		
	}

}