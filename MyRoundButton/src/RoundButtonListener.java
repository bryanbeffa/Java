
/**
 * Interfaccia che contiene gli eventi del round button.
 * C'è l'evento quando si clicca, quando si rilascia,
 * quando si tiene premuto e quando si posiziona il puntatore del mouse
 * sulla superficie del bottone.
 *
 * @version 14.09.2018
 * @author Bryan
 */
public interface RoundButtonListener {

    /**
     * Metodo che viene invocato quando il bottone è cliccato.
     *
     * @param source round button che viene cliccato.
     */
    public void roundButtonClicked(MyRoundButton source);

    /**
     * Metodo che viene invocato quando il bottone è premuto.
     *
     * @param source round button che viene premuto.
     */
    public void roundButtonPressed(MyRoundButton source);

    /**
     * Metodo che viene invocato quando il bottone è rilasciato.
     *
     * @param source round button che viene rilasciato.
     */
    public void roundButtonReleased(MyRoundButton source);

    /**
     * Metodo che viene invocato quando il bottone è rilasciato.
     *
     * @param source round button su cui vi è il cursore del mouse.
     */
    public void roundButtonOver(MyRoundButton source);
}
