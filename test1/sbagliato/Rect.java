import java.awt.Color;

/**
 * Definizione della classe dell'oggetto di tipo Rect.
 *
 * @author Bryan Beffa
 * @version 09.10.2017
 */
public class Rect{

	/**
	 * Attributo altezza del rettangolo.
	 * Valore di default "4".
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
	private Color color = Color.BLACK;

	/**
	 * Metodo costruttore vuoto.
	 */
	public Rect(){
	}

	/**
	 * Metodo costruttore se viene fornito il colore del rettangolo.
	 *
	 * @param color colore del rettangolo che viene fornito.
	 */
	public Rect(Color color){
		setColor(color);
	}

	/**
	 * Metodo costruttore se vengono fornite le dimensioni.
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

	/**
	 * Metodo setter dell'attributo height.
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

	/**
	 * Metodo che ritorna il perimetro del rettangolo
	 *
	 * @return perimetro del rettangolo
	 */
	public int getPerimeter(){
		int perimetro = (getWidth() * 2) + (getHeight()*2);
		return perimetro;
	}

	/**
	 * Metodo che ritorna il l'area del rettangolo
	 *
	 * @return area del rettangolo
	 */
	public int getSurface(){
		int area = getWidth() * getHeight();
		return area;
	}

	/**
	 * Metodo che disegna il rettangolo.
	 *
	 *
	 */
	public void paint(){
		String[][] rettangolo = new String[getHeight()][getWidth()];
		for(int i =0; i<rettangolo.length; i++){
			for (int j=0 ; j< rettangolo[i].length ; j++) {
				if(i==0){
					rettangolo[i][j] = "#";
				}else if(i== rettangolo.length-1){
					rettangolo[i][j] = "#";
				}else if(j== rettangolo[i].length-1){
					rettangolo[i][j] = "#";
				}else if(j== 0){
					rettangolo[i][j] = "#";
				}else{
					rettangolo[i][j] = " ";
				}
			}
		}
		for(int i =0; i<rettangolo.length; i++){
			for (int j=0 ; j< rettangolo[i].length ; j++) {
				System.out.print(rettangolo[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args){
		
		//viene svolto se fornisco le dimensioni.
		if(args.length == 2){
			try{
				boolean flag = true; //se vero viene passato anche un colore
				int height = Integer.parseInt(args[0]);
				int width = Integer.parseInt(args[1]);
				if(flag){
					Rect rettangolo = new Rect(width, height, Color.BLACK);
					rettangolo.paint();
					System.out.println("Perimetro = " + rettangolo.getPerimeter());
					System.out.println("Area = " + rettangolo.getSurface());
					System.out.println("R: " + rettangolo.color.getRed() + " G: " + rettangolo.color.getGreen() + " B: " + rettangolo.color.getBlue());
				}else{
					Rect rettangolo = new Rect(width, height);
					rettangolo.paint();
					System.out.println("Perimetro = " + rettangolo.getPerimeter());
					System.out.println("Area = " + rettangolo.getSurface());
					System.out.println("R: " + rettangolo.color.getRed() + " G: " + rettangolo.color.getGreen() + " B: " + rettangolo.color.getBlue());
				}
			}catch(NumberFormatException nfe){
				Rect rettangolo = new Rect();
				rettangolo.paint();
				System.out.println("Perimetro = " + rettangolo.getPerimeter());
				System.out.println("Area = " + rettangolo.getSurface());
				System.out.println("R: " + rettangolo.color.getRed() + " G: " + rettangolo.color.getGreen() + " B: " + rettangolo.color.getBlue());
			}
		}if(args.length == 0){
			
			Rect rettangolo = new Rect();
			rettangolo.paint();
			System.out.println("Perimetro = " + rettangolo.getPerimeter());
			System.out.println("Area = " + rettangolo.getSurface());
			System.out.println("R: " + rettangolo.color.getRed() + " G: " + rettangolo.color.getGreen() + " B: " + rettangolo.color.getBlue());
		}
	}

}