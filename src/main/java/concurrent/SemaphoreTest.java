package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。比作是控制流量的红绿灯
 * @author ChaoChao
 *
 */
public class SemaphoreTest {

    static final Semaphore sem = new Semaphore(4, false);
    static final ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            newCachedThreadPool.submit(() -> {
                try {
                    sem.acquire();
                } catch (Exception e) {
                    System.out.println("semaphore acquire exception"+e);
                }
                System.out.println(Thread.currentThread() + " is get semaphore");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(Thread.currentThread() + " sleep exception"+e);
                }
                sem.release();
                System.out.println("semaphore remain " + sem.availablePermits());
            });
        }
        newCachedThreadPool.shutdown();
    }
}
