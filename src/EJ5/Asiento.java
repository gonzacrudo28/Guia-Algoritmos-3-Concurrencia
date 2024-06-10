package EJ5;

public class Asiento {
    public static int numeroAsiento;
    public static boolean ocupado;

    public Asiento(int numero){
        numeroAsiento = numero;
        ocupado = false;
    }
    public void setOcupado(){
        ocupado = true;
    }
}
