/**
 * Interfaccia che contiene gli eventi del bottone.
 * C'è l'evento quando si clicca il bottone, quando si rilascia il bottone,
 * quando si tiene premuto il bottone
 * @version 30.05.2018
 * @author Bryan
 */
public interface ButtonListener {
    /**
     * Metodo che viene invocato quando il bottone è cliccato.
     * @param source buttone che viene cliccato.
     */
    public void ButtonClicked(Button source);
    
    /**
     * Metodo che viene invocato quando il bottone è premuto.
     * @param source buttone che viene premuto.
     */
    public void ButtonPressed(Button source);
    
    /**
     * Metodo che viene invocato quando il bottone è rilasciato.
     * @param source buttone che viene rilasciato.
     */
    public void ButtonReleased(Button source);
}
