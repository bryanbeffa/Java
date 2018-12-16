
/**
 * Classe che crea 5 runnable. Ogni runnable è identificato da un numero.
 *
 * @author Bryan Beffa
 * @version 19.11.2018
 */
public class HelloRunnable implements Runnable {

    /**
     * Attributo che indica il numero identificativo del Runnable
     */
    private int runnableId;

    /**
     * Metodo costruttore con un parametro.
     *
     * @param runnableId numero identificativo del Runnable
     */
    public HelloRunnable(int runnableId) {
        this.runnableId = runnableId;
    }

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            System.out.println("Sono il runnable numero: " + runnableId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new HelloRunnable(1)).start();
        new Thread(new HelloRunnable(2)).start();
        new Thread(new HelloRunnable(3)).start();
        new Thread(new HelloRunnable(4)).start();
        new Thread(new HelloRunnable(5)).start();
    }
}
