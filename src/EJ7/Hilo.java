package EJ7;

import java.util.ArrayList;

public class Hilo extends Thread{
    private ArrayList<Integer> lista;
    private int total;
    public Hilo(ArrayList<Integer> lista) {
        this.lista = lista;
        this.total = 0;
    }
    public void run(){
        while (true){
            for (int i = 0; i<lista.size(); i++){
                total = total + lista.get(i);
            }
            actualizarTotal();
        }
    }

    public int actualizarTotal(){
        while(true){
            EJ7.lock.lock();
            try{
                while (EJ7.condicionOcupado){
                    EJ7.condicionLibre.await();
                }
                EJ7.total = EJ7.total + total;
                EJ7.condicionLibre.signal();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                EJ7.lock.unlock();
            }
        }
    }
}
