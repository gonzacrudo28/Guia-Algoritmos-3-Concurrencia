package EJ7;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EJ7 {
    /*
    Crea un programa en Java que calcule la suma de un gran arreglo de números en paralelo utilizando varios hilos.
    Dividir el arreglo en partes iguales y asignar cada parte a un hilo para que calcule su suma. Luego, sumar los
    resultados parciales para obtener el resultado final.
     */
    public List<Integer> param;
    public static final Lock lock = new ReentrantLock();
    public static Condition condicionLibre = lock.newCondition();
    public static Condition condicionOcupado = lock.newCondition();
    public static int total = 0;

    public int obtenerMaximoDivisor(){
        for (int i = 10000; i > 1; i--){
            if (param.size() % i == 0){
                return i;
            }
        }
        return 1;
    }

    public int CrearThreadsYSumar(){
        int maximoDivisor = obtenerMaximoDivisor();
        int tamaño_del_arreglo = param.size() / maximoDivisor;
        ArrayList<ArrayList<Integer>> arreglo_partido = new ArrayList<>();
        int contador = 1;
        ArrayList<Integer> sublista = new ArrayList<>();
        for (int i=0; i < param.size(); i++){
            if (contador < tamaño_del_arreglo){
                sublista.add(param.get(i));
                contador ++;
            } else if (contador == tamaño_del_arreglo){
                arreglo_partido.add(sublista);
                sublista.clear();
                contador = 1;
                sublista.add(param.get(i));
            }
        }
        for (int j = 0; j < tamaño_del_arreglo; j++){
            Thread t = new Hilo(sublista.get(j));
            t.start();
        }
    }

}
