
/**
 * Classe che crea 5 thread. Ogni thread è identificato da un numero.
 *
 * @author Bryan Beffa
 * @version 19.11.2018
 */
public class HelloThread extends Thread {

    /**
     * Attributo che indica il numero identificativo del Thread
     */
    private int threadId;

    /**
     * Metodo costruttore con un parametro.
     *
     * @param threadId numero identificativo del Thread
     */
    public HelloThread(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            System.out.println("Sono il thread numero: " + threadId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void main(String[] args) {
        (new HelloThread(1)).start();
        (new HelloThread(2)).start();
        (new HelloThread(3)).start();
        (new HelloThread(4)).start();
        (new HelloThread(5)).start();

    }
}
