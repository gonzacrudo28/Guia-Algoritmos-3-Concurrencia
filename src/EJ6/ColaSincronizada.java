package EJ6;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ColaSincronizada {
    /*
    Implementar una clase ColaSincronizada, que recibe como parámetro un número entero N indicando su capacidad máxima.
    Si la cola está llena, el método encolar debe bloquear hasta que haya lugar y el elemento haya sido encolado
    satisfactoriamente. Si la cola está vacía, desencolar debe bloquear hasta que haya un elemento para desencolar.
     */
    private int capacidad_maxima;
    private List<Integer> elementos;
    public ColaSincronizada(int N) {
        this.capacidad_maxima = N;
        this.elementos = new LinkedList<>();
    }
    public static final Lock lock = new ReentrantLock();
    public static Condition condicionLlenable = lock.newCondition();
    public static Condition condicionNoLlenable = lock.newCondition();

    public void encolar(Integer elemento){
        lock.lock();
        try {
           while(elementos.size() == capacidad_maxima){
                condicionLlenable.await();
            }
            elementos.add(elemento);
            if (elementos.size() == capacidad_maxima) {
                condicionNoLlenable.signalAll();
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public Integer desencolar() {
        lock.lock();
        try {
            while (elementos.isEmpty()) {
                condicionLlenable.await();
            }
            Integer desencolado = elementos.remove(0);
            condicionLlenable.signalAll();
            return desencolado;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
