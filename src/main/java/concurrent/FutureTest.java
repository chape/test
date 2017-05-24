package concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * future.get方法是堵塞的，主线程会等待子线程直到完成结果返回
 * @author ChaoChao
 *
 */
public class FutureTest {

    static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return new Random().nextInt(100);
            }
        };
        Future<Integer> future = executor.submit(callable);
        try {
            Integer integer = future.get();
            System.out.println("future result :" + integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end");
        executor.shutdown();
        if (null != executor) {
            try {
                while(!executor.awaitTermination(1, TimeUnit.SECONDS)){
                    System.out.println("pool is alive");
                }
                System.out.println("pool is terminated"); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
