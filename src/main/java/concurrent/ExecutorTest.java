package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 线程池shutdown会等待线程池中任务执行完才将线程池关闭，shutdownNow直接关闭
 * awaitTermination在超时时间内判断线程池关闭状态
 * @author ChaoChao
 *
 */
public class ExecutorTest {

    static final ExecutorService executor = new ThreadPoolExecutor(0, 4, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(4));
    public static void main(String[] args) {
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();//让caller线程运行任务，推迟该线程继续提交新任务
        new ThreadPoolExecutor.AbortPolicy();//直接抛出RejectedExecutionException runtime异常
        new ThreadPoolExecutor.DiscardOldestPolicy();//丢弃最老，即队列头的线程
        new ThreadPoolExecutor.DiscardPolicy();//直接丢弃
        ((ThreadPoolExecutor)executor).setRejectedExecutionHandler(handler);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println("exe");
            });
        }
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
