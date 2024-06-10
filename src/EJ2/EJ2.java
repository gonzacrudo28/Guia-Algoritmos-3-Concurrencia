package EJ2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EJ2 {
    /*
    Escribir un programa que utiliza 2 threads, uno imprimiendo números pares y el otro números impares, alternándose
    desde 1 hasta un número dado. Implementar sincronización utilizando Locks y Conditions para asegurar que los números
    se imprimen en el orden correcto.
     */
    public static int limite = 100000000;
    public static final Lock lock = new ReentrantLock();
    public static final Condition condicionPar = lock.newCondition();
    public static final Condition condicionImpar = lock.newCondition();

    public static int actual = 0;

    public void Imprimir(){
        Thread t1 = new T1();
        t1.start();
        Thread t2 = new T2();
        t2.start();
    }

}
