import java.nio.file.*;
import java.io.*;

public class Prova{

/*************************************** Attributi *****************************************************/
	private byte[] data;

	
/*************************************** Metodi costruttori ********************************************/
	public Prova(byte[] data){
		this.data = data;
	}

/*************************************** Metodi getter *************************************************/

	public long getLong(int offset, int len){
		
		long value = 0;
		for(int i = offset; i< offset + len; i++){
			value = value | data[i] << (8*(i-offset));
		}
		return value;
	}

	public void stampArray(){
		long[] bytes = convertDataToLongArray();
		for(int i = 0; i< bytes.length; i++){
			System.out.print(bytes[i] + " ");

		}
	}

	//funge
	public String getSignature(){
		long[] bytes = convertDataToLongArray();
		
		long firstLetter = bytes[0];
		char firstChar = (char)firstLetter;
		long secondLetter = bytes[1];
		char seconChar = (char)secondLetter;

		String ris = firstChar + "" + seconChar;
		return ris;
	}

	//funge
	public long getFileSize(){
		long[] bytes = convertDataToLongArray();
	
		long value = getLong(2, 4);
	
		return value;
	}

	//funge
	public long getReserved1(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(6, 2);

		return value;		
	}

	//funge
	public long getReserved2(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(8, 2);

		return value;		
	}

	//funge
	public long getFileOffset(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(10, 4);

		return value;		
	}

	//funge
	public long getDibHeaderSize(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(14, 4);

		return value;		
	}

	

	//funge
	public long getWidth(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(18, 4);

		return value;
	}
	
	//funge
	public long getHeight(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(22, 4);

		return value;
	}

	//funge
	public long getPlanes(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(26, 2);

		return value;
	}

	//funge
	public long getBitsPerPixel(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(28, 2);

		return value;
	}


	public long getCompression(){
		long[] bytes = convertDataToLongArray();


		long value = getLong(30, 4);

		return value;
	}

	public long getImageSize(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(34, 4);

		return value;
	}

	public long getXPixelsPerMeter(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(38, 4);

		return value;
	}

	public long getYPixelsPerMeter(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(42, 4);

		return value;
	}

	//funge
	public long getColorsInColorTable(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(46, 4);

		return value;
	}

	//funge
	public long getImportantColorCount(){
		long[] bytes = convertDataToLongArray();

		long value = getLong(50, 4);

		return value;
	}




/*************************************** Metodi generali ***********************************************/
	//funge
	public void dumpPixelsRGB(){
		long[] bytes = convertDataToLongArray();
		int offset = (int)getFileOffset();
		long numPixels = getWidth() * getHeight();
		int padding = 0;
		
		if(getWidth()%4 == 1){
			padding = 1;
		}else if(getWidth()%4 == 2){
			padding = 2;	
		}else if(getWidth()%4 == 3){
			padding = 3;
		}

		for(int o=0 ; o< getHeight() ; o++){
			for(int j=0 ; j< getWidth() ; j++){

				for(int i =2; i> -1; i--){
					System.out.print(bytes[offset+i] + " ");
				}
				System.out.print("| ");
				offset += 3;
			}
			System.out.println("");
			offset+= padding;
		}
	}

	public void dumpPixelsGrayScale(){
		long[] bytes = convertDataToLongArray();
		int offset = (int)getFileOffset();
		long numPixels = getWidth() * getHeight();
		int padding = 0;
		
		if(getWidth()%4 == 1){
			padding = 1;
		}else if(getWidth()%4 == 2){
			padding = 2;	
		}else if(getWidth()%4 == 3){
			padding = 3;
		}

		for(int o=0 ; o< getHeight() ; o++){
			for(int j=0 ; j< getWidth() ; j++){
				int gray = 0;

				for(int i =2; i> -1; i--){
					gray += bytes[offset+i];
				}
				System.out.print(gray);

				System.out.print(" | ");
				offset += 3;
			}
			System.out.println("");
			offset+= padding;
		}
	}


	public long[] convertDataToLongArray(){ 
		long[] byteHex = new long[data.length];
		for(int i=0; i < data.length ; i++){
			byteHex[i] = data[i]&0xFF;
		}
		return byteHex;
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
						Prova bmp = new Prova(bytes);

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

						System.out.println("Pixel RGB: ");
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