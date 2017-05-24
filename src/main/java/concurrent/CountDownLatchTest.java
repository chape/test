package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static final CountDownLatch latch = new CountDownLatch(2);
    public static void main(String[] args) {
        
        new Thread(() -> {
            System.out.println(Thread.currentThread() + " has finish");
            latch.countDown();
        }, "thread-1").start();
        
        new Thread(() -> {
            System.out.println(Thread.currentThread() + " has finish");
            latch.countDown();
        }, "thread-2").start();
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("latch interrupt exception");
        }
        System.out.println("finish all");
    }
}
