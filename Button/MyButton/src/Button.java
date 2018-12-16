import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe che crea un bottone. Possono essere settate le grandezze, il testo, 
 * la posizione e il colore del bottone.
 * @version 28.05.2018
 * @author Bryan Beffa
 */
public class Button implements MouseListener{
    /**
     * Attributo che indica la larghezza del bottone.
     * Valore di default 200 pixel.
     */
    private int width = 200;
    
    /**
     * Attributo che indica l'altezza del bottone.
     * Valore di default 80 pixel.
     */
    private int height = 80;
    
    /**
     * Attributo che indica la coordinata orizzontale del bottone.
     * Valore di default 0.
     */
    private int x = 0;
    
    /**
     * Attributo che indica la coordinata verticale del bottone.
     * Valore di default 0.
     */
    private int y = 0;
    
    /**
     * Attributo che indica la scritta del bottone.
     * Valore di default Button.
     */
    private String label = "Button";
    
    /**
     * Attributo che indica il colore del bottone.
     * Valore di default rosso.
     */
    private Color color = Color.red;
    
    /**
     * Lista di button listener.
     */
    private List<ButtonListener> listeners = new ArrayList();
    
    /**
     * Metodo setter dell'attributo width.
     * Controlla che la larghezza non sia inferiore a 100 pixel.
     * @param width larghezza del bottone.
     */
    private void setWidth(int width){
        if(width>= 100){
            this.width = width;
        }
    }
    
    /**
     * Metodo setter dell'attributo height.
     * Controlla che la larghezza non sia inferiore a 50 pixel.
     * @param height altezza del bottone.
     */
    private void setHeight(int height){
        if(height>= 50){
            this.width = height;
        }
    }
    
    /**
     * Metodo setter dell'attributo x.
     * Controlla che la posizione orizzontale non sia inferiore a 0.
     * @param x posizione orizzontale del bottone.
     */
    private void setX(int x){
        if(x>0){
            this.x = x;
        }
    }
    
    /**
     * Metodo setter dell'attributo y.
     * Controlla che la posizione verticale non sia inferiore a 0.
     * @param y posizione verticale del bottone.
     */
    private void setY(int y){
        if(y > 0){
            this.y = y;
        }
    }
    
    /**
     * Metodo setter dell'attributo label.
     * Il label non può essere vuota.
     * @param label scritta del bottone.
     */
    private void setLabel(String label){
       if(label != null && !label.equals("")){
           this.label = label;
       } 
    }
    
    /**
     * Metodo getter dell'attributo height.
     * @return altezza del button.
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Metodo getter dell'attributo width.
     * @return larghezza del button.
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Metodo getter dell'attributo x.
     * @return posizione orizzontale del button.
     */
    public int getX(){
        return x;
    }
    
    /**
     * Metodo getter dell'attributo y.
     * @return posizione verticale del button.
     */
    public int getY(){
        return y;
    }
    
    /**
     * Metodo getter dell'attributo color.
     * @return il colore del button.
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Metodo getter dell'attributo label.
     * @return il label del button.
     */
    public String getLabel(){
        return label;
    }
    
    /**
     * Metodo costruttore vuoto.
     */
    public Button(){
    }
    
    /**
     * Metodo costruttore del bottone che richiede sei parametri.
     * @param width larghezza del bottone.
     * @param height altezza del bottone.
     * @param label nome del bottone.
     * @param color colore del bottone.
     */
    public Button(int x, int y, int width, int height, String label, Color color){
        setWidth(width);
        setHeight(height);
        setLabel(label);
        setX(x);
        setY(y);
        this.color = color;
    }
    
    /**
     * Metodo che aggiunge il button listener.
     * @param bl button listener da aggiungere.
     */
    public void addButtonListener(ButtonListener bl)
    {
        listeners.add(bl);
    }
    
    /**
     * Metodo che disegna il bottone, centra il label.
     * Colore inoltre il background del bottone.
     * @param g parametro grafico passato dal sistema operativo.
     */
    public void paint(Graphics g){        
        //disegno il button
        g.setColor(getColor());
        g.fillRect(getX(), 
                   getY(), 
                   getWidth(), 
                   getHeight());
        
        //setto il tiolo
        String titolo = getLabel();
        g.setColor(Color.black);
        Font font = new Font("MyFont",1,12);
        FontMetrics fm = g.getFontMetrics(font);
        int width = fm.stringWidth(titolo);
        int size = font.getSize();
        g.drawString(titolo, 
                     getX() + (getWidth() - width) / 2, 
                     getY()+ (getHeight()+size)/2);        
    }
    
    /**
     * Evento che viene richiamato quando il mouse viene cliccato.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX >= x && mouseX <= (x + getWidth()) && mouseY >= y && mouseY <= (y + getHeight()))
        {
            for(ButtonListener bl : listeners)
            {
                bl.ButtonClicked(this);
            }
        }
    }
    
    /**
     * Viene invocato quando il mouse è premuto.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    @Override
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX >= x && mouseX <= (x + getWidth()) && mouseY >= y && mouseY <= (y + getHeight()))
        {
            for(ButtonListener bl : listeners)
            {
                bl.ButtonPressed(this);
            }
        }    
    }
    
    /**
     * Viene invocato quando un tasto del mouse viene rilasciato.
     * Memorzzia le coordinate del puntatore del mouse.
     * @param e evento del mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX >= x && mouseX <= (x + getWidth()) && mouseY >= y && mouseY <= (y + getHeight()))
        {
            for(ButtonListener bl : listeners)
            {
                bl.ButtonReleased(this);
            }
        }
    }

    /**
     * Viene invocato quando il mouse entra nella finestra.
     * @param e evento del mouse.
     */
    @Override
    public void mouseEntered(MouseEvent e){
    }

    /**
     * Viene invocato quando il mouse esce nella finestra.
     * @param e evento del mouse.
     */
    @Override
    public void mouseExited(MouseEvent e){
    }
}
