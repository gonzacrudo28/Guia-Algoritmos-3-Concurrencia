package EJExtra;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mian {
    // Imprimir los primeros N numeros primos
    private int maximo;
    private int actual;
    final Lock lock = new ReentrantLock();
    final Condition ultimoPrimo = lock.newCondition();
    final Condition ultimoNoPrimo = lock.newCondition();
    public Mian(int numero){
        this.maximo = numero;
        this.actual = 0;
    }

    public void imprimirPrimerosNPrimos(){
        for (int i = 0; i <= maximo; i++ ){
            int finalI = i;
            new Thread(() -> {
                try{
                    lock.lock();
                    while(!esPrimo(actual)){
                        ultimoNoPrimo.await();
                    }
                    System.out.println(finalI);
                    ultimoPrimo.signal();
                    actual ++;

                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
    public void verPrimerosNNoPrimos(){
        for (int i = 0; i <= maximo; i++ ){
            int finalI = i;
            new Thread(() -> {
                try{
                    lock.lock();
                    while(esPrimo(actual)){
                        ultimoPrimo.await();
                    }
                    System.out.println(finalI);
                    ultimoNoPrimo.signal();
                    actual ++;

                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }

    public boolean esPrimo(int n){
        if (n <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return  true;
    }

}
