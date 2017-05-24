package concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 将任务执行结果放到CompletionService BlockingQueue中 然后循环获取结果。请求任务顺序与读取结果顺序可能不同 
 *
 */
public class CompletionServiceTest {

    private static final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
    private static final CompletionService<Integer> completionService = new ExecutorCompletionService<>(newFixedThreadPool);
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            completionService.submit(new ComputeCallable(i));
        }
        for (int i = 0; i < 10; i++) {
            try {
                Future<Integer> future = completionService.take();
                System.out.println(future.get());
            } catch (InterruptedException e) {
                System.out.println("interrupt exception");
            } catch (ExecutionException e) {
                System.out.println("future get exception");
            }
        }
        newFixedThreadPool.shutdown();
    }
    static class ComputeCallable implements Callable<Integer>{

        private int element;
        public ComputeCallable(int element) {
            this.element = element;
        }
        @Override
        public Integer call() throws Exception {
            Thread.sleep(new Random().nextInt(5000));
            return element * 2;
        }
        
    }
}
