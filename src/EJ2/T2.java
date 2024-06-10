package EJ2;

public class T2 extends Thread{
    public void run(){
        while(true){
            try{
                EJ2.lock.lock();
                while (EJ2.actual % 2 == 0){
                    EJ2.condicionImpar.await();
                }
                if (EJ2.actual < EJ2.limite){
                    System.out.println(EJ2.actual);
                    EJ2.actual ++;
                    EJ2.condicionPar.signal();
                }else{
                    break;
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                EJ2.lock.unlock();
            }
        }
    }
}
