package EJ5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EJ5 {
    /*
    Diseñar un sistema donde múltiples usuarios pueden reservar asientos en un cine, en forma concurrente.
    Sincronizar correctamente para garantizar que dos usuarios no reserven el mismo asiento al mismo tiempo.
     */
    public static final Lock lock = new ReentrantLock();
    public static Condition condicionOcupado = lock.newCondition();
    public static Condition condicionlibre = lock.newCondition();

}
