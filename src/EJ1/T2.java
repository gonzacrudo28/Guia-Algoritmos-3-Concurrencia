package EJ1;

import EJ1.EJ1;

public class T2 implements Runnable{
    public void run(){
        while (true) {
           synchronized (EJ1.lock){
               System.out.println(EJ1.numero);
           }
        }
    }
}
