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

    public void imprimirNPrimos(){
        Thread tPrimos = new Thread(() -> {
            lock.lock();
            try{
                for (int i =0; i < maximo; i++){
                    while(!esPrimo(actual)){
                        ultimoNoPrimo.await();
                    }
                    if (actual>= maximo){
                        break;
                    }
                    System.out.println(actual);
                    actual++;
                    ultimoPrimo.signal();

                }
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
        Thread noPrimos = new Thread(() -> {
            lock.lock();
            try{
                for (int i =0; i < maximo; i++){
                    while(esPrimo(actual)){
                        ultimoPrimo.await();
                    }
                    if (actual >= maximo){
                        break;
                    }
                    actual++;
                    ultimoNoPrimo.signal();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
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
