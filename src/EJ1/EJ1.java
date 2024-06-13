package EJ1;
//prueba
public class EJ1 {
    // Escribir un programa que cree un hilo extendiendo la clase Thread y otro hilo implementando la interfaz Runnable.
    // Ambos hilos deben imprimir mensajes en la consola en un ciclo infinito. Observar el orden en que se imprimen los
    // mensajes.
    //los hilos compartan el acceso a una variable de tipo int. Ambos hilos deben, en un ciclo infinito, imprimir el
    //valor actual de la variable y luego incrementarla.
    public static int numero = 0;
    public static final Object lock = new Object();
    public void imprimir(){
        T1 t1 = new T1();
        t1.start();
        Runnable tarea = new T2();
        Thread t2 = new Thread(tarea);
        t2.start();
    }



}

