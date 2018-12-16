import java.awt.Color;

/**
 * La classe che rappresenta un modello di rettangolo.
 * Il rettangolo ha tre attributi: larghezza, altezza e colore. 
 *
 * @author Bryan Beffa
 * @version 21.10.2017
 */

public class Rect{

/*************************************** Attributi *****************************************************/

	/**
	 * Attributo che definisce l'altezza del rettangolo. 
	 * Il valore di default è 4.
	 */
	private int height = 4; 

	/**
	 * Attributo larghezza del rettangolo.
	 * Valore di default "6".
	 */
	private int width = 6;

	/**
	 * Attributo colore del rettangolo.
	 * Valore di default rgb [100,90,32].
	 */
	private Color color = new Color(100,90,32);

/*************************************** Metodi costruttori ********************************************/

	/**
	 * Metodo costruttore vuoto.
	 */
	public Rect(){
	}

	/**
	 * Metodo costruttore se viene fornito il colore del rettangolo.
	 * Altezza e larghezza possiedono il valore di default. 
	 *
	 * @param color colore del rettangolo che viene fornito.
	 */
	public Rect(Color color){
		setColor(color);
	}

	/**
	 * Metodo costruttore se vengono fornite le dimensioni.
	 * Colore impostato al valore di default.
	 *
	 * @param width larghezza del rettangolo che viene fornita.
	 * @param height altezza del rettangolo che viene fornita.
	 */
	public Rect(int width, int height){
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Metodo costruttore se vengono forniti tutti gli attributi.
	 *
	 * @param width larghezza del rettangolo che viene fornita.
	 * @param height altezza del rettangolo che viene fornita.
	 * @param color colore del rettangolo che viene fornito.
	 */
	public Rect(int width, int height, Color color){
		setWidth(width);
		setHeight(height);
		setColor(color);
	}

/*************************************** Metodi setter *************************************************/

	/**
	 * Metodo setter dell'attributo height.
	 * Il valore passato deve essere tra 4 compreso e 30 compreso.
	 * Controllo se il valore passato rispetta le condizioni.
	 *
	 * @param height altezza che vogliamo settare.
	 */
	public void setHeight(int height){
		if( height >= 4 && height <= 30){
			this.height = height;
		}
	}

	/**
	 * Metodo setter dell'attributo width.
	 * Il valore passato deve essere compreso tra 3 e 42.
	 * Controllo se il valore rispetta le condizioni.
	 *
	 * @param width larghezza che vogliamo settare.
	 */
	public void setWidth(int width){
		if( width >= 3 && width <= 42){
			this.width = width;
		}
	}

	/**
	 * Metodo setter dell'attributo color.
	 *
	 * @param color colore che vogliamo settare.
	 */
	private void setColor(Color color){
		this.color = color;
	}

/*************************************** Metodi getter **************************************************/

	/**
	 * Metodo getter dell'attributo height.
	 *
	 * @return altezza del rettangolo.
	 */
	public int getHeight(){
		return height;
	}

	/**
	 * Metodo getter dell'attributo width.
	 *
	 * @return larghezza del rettangolo.
	 */
	public int getWidth(){
		return width;
	}

	/**
	 * Metodo getter dell'attributo color.
	 *
	 * @return colore del rettangolo.
	 */
	public Color getColor(){
		return color;
	}

/*************************************** Altri metodi ***************************************************/

	/**
	 * Metodo che ritorna il perimetro del rettangolo.
	 *
	 * @return perimetro del rettangolo.
	 */
	public int getPerimeter(){
		int perimetro = (getWidth() * 2) + (getHeight()*2);
		return perimetro;
	}

	/**
	 * Metodo che ritorna il l'area del rettangolo.
	 *
	 * @return area del rettangolo.
	 */
	public int getSurface(){
		int area = getWidth() * getHeight();
		return area;
	}

	/**
	 * Metodo che disegna il rettangolo.
	 *
	 */
	public void paint(){
		for (int i = 0; i< this.height ; i++){
			if(i == 0 || i == this.height-1){
				for(int j= 0; j<this.width; j++){
					System.out.print("*");
				}
			}else{
				System.out.print("*");
				for(int j= 0; j<this.width-2; j++){
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("R: " + this.color.getRed() + " G: " + this.color.getGreen() + " B: " + this.color.getBlue());
	}

	public static void main(String[] args) {
		
		/**
		 * Se vengono passati i valori dell'altezza e larghezza.
		 * Stampa prima il rettangolo in cui viene passato anche il colore.
		 * Stampa anche il rettengolo dove non viene fornito il colore.
		 */
		if(args.length == 2){
			try{
				//primo rettangolo
				System.out.println("RETTANGOLO DI CON TUTTI I VALORI FORNITI:");
				int height = Integer.parseInt(args[1]);
				int width = Integer.parseInt(args[0]);
				Rect rettUno = new Rect(width, height, Color.BLACK);
				rettUno.paint();
				System.out.println("Perimetro = " + rettUno.getPerimeter());
				System.out.println("Area = " + rettUno.getSurface() + "\n");
								System.out.println(rettUno.getWidth());

				//secondo rettangolo
				System.out.println("RETTANGOLO CON LE DIMENSIONI FORNITE:");
				Rect rettDue = new Rect(width, height);
				rettDue.paint();
				System.out.println("Perimetro = " + rettDue.getPerimeter());
				System.out.println("Area = " + rettDue.getSurface() + "\n");
			}catch(NumberFormatException nfe){
			}
		}
		//rettangolo con i valori di default
		System.out.println("RETTANGOLO CON I VALORI DI DEFAULT:");
		Rect rettDefault = new Rect();
		rettDefault.paint();
		System.out.println("Perimetro = " + rettDefault.getPerimeter());
		System.out.println("Area = " + rettDefault.getSurface() + "\n");

		//rettangolo fornendo il colore e basta
		System.out.println("RETTANGOLO FORNENDO IL COLORE CON DIMENSIONI DI DEFAULT:");
		Rect rettColor = new Rect(Color.WHITE);
		rettColor.paint();
		System.out.println("Perimetro = " + rettColor.getPerimeter());
		System.out.println("Area = " + rettColor.getSurface() + "\n");

		//
		System.out.println("RETTANGOLO FORNENDO VALORI NON ACCETTABILI:");
		Rect rettError = new Rect(1,1 ,Color.WHITE);
		rettError.paint();
		System.out.println("Perimetro = " + rettError.getPerimeter());
		System.out.println("Area = " + rettError.getSurface() + "\n");
	}
}