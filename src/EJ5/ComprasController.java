package EJ5;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ComprasController {
    public static final Lock lock = new ReentrantLock();
    public static Condition condicionOcupado = lock.newCondition();
    public static Condition condicionlibre = lock.newCondition();
    public ArrayList<Asiento> asientos;


}
