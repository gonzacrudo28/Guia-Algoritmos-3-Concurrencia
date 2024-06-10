package EJ1;

import EJ1.EJ1;

public class T1 extends Thread {
    private int numero;

    public void run() {
        while (true) {
            synchronized (EJ1.lock) {
                System.out.println(EJ1.numero);
            }
        }
    }
}
