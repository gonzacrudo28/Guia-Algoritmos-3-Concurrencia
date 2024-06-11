package EJ5;

import java.util.HashMap;

public class Asiento {
    public static int numeroAsiento;
    public boolean ocupado;
    public Asiento(int numero){
        numeroAsiento = numero;
        ocupado = false;

    }
    public void setOcupado(){
        ocupado = true;
    }
    public void comprarAsiento(Asiento asiento) throws Exception{
        if (!asiento.ocupado){
            throw new Exception("El asiento esta ocupado");
        } else{
            asiento.setOcupado();
        }
    }

}
