package EJ2;

public class T1 extends Thread{
    public void run(){
        while(true){
            EJ2.lock.lock();
            try {
                while (EJ2.actual % 2 != 0){
                    EJ2.condicionPar.await();
                }
                if (EJ2.actual < EJ2.limite){
                    System.out.println(EJ2.actual);
                    EJ2.actual ++;
                    EJ2.condicionImpar.signal();
                } else{
                    break;
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                EJ2.lock.unlock();
            }
        }
    }
}
