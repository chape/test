package concurrent;

import java.util.concurrent.CyclicBarrier;
/**
 * CyclicBarrier可循环使用的屏障
 * CountDownLatch的计数器只能使用一次,而CyclicBarrier的计数器可以使用reset()方法重置
 *
 */
public class CyclicBarrierTest {

    private static final CyclicBarrier barrier = new CyclicBarrier(2, new FinalExecutor());
    public static void main(String[] args) {
        new Thread(() -> {
           try {
            barrier.await();
        } catch (Exception e) {
            System.out.println("barrier await exception");
        } 
        },"thread-1").start();
        
        System.out.println("waiting for the second thread");
        
        try {
            barrier.await();
        } catch (Exception e) {
            System.out.println("barrier await exception");
        } 
        System.out.println("finish all");
    }
}

class FinalExecutor implements Runnable{

    @Override
    public void run() {
        System.out.println("reach 2 thread");
    }
    
}
