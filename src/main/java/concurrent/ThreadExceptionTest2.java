package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 异常不能跨线程传播，主线程不捕获子线程抛出的异常
 * 而future.get会抛出异常，可以在主线程中捕获
 * @author ChaoChao
 *
 */
public class ThreadExceptionTest2 {

    final static ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                singleThreadPool.execute(new ExceptionRunnable());
            }
        } catch (Exception e) {
            System.out.println("catch the execute thread exception");
        }
        
        for (int i = 0; i < 5; i++) {
            Future<?> submit = singleThreadPool.submit(new ExceptionRunnable());
            try {
                submit.get();
            } catch (Exception e) {
                System.out.println("catch the submit thread exception");
            }
        }
        singleThreadPool.shutdown();
    }
}

class ExceptionRunnable implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("hh");
    }

}
