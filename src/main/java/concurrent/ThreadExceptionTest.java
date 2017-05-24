package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * java线程池会捕获任务抛出的异常和错误，但不做任何处理(ThreadPoolExecutor.afterExecute空实现)
处理线程池中的异常有两种思路： 
1）提交到线程池中的任务自己捕获异常并处理，不抛给线程池(业务逻辑全try-catch)
2）由线程池统一处理
    对于execute方法提交的线程，有两种处理方式 
        1）自定义线程池并实现afterExecute方法 
        2）给线程池中的每个线程指定一个UncaughtExceptionHandler,由handler来统一处理异常。
    对于submit方法提交的任务，异常处理是通过返回的Future对象进行的。
 *
 */
public class ThreadExceptionTest {
    static final Thre th = new Thre();
    
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Runnable r = new Runnable(){
            @Override
            public void run() {
                th.setT(Thread.currentThread());
                System.out.println("first:"+Thread.currentThread().getId());
                Thread.currentThread().stop();
                throw new RuntimeException();
            }
        };
        singleThreadExecutor.submit(r);
        singleThreadExecutor.submit(() -> {
            System.out.println("second:"+Thread.currentThread().getId());
            if(Thread.currentThread() == th.getT()){
                System.out.println("ss");
            }
            System.out.println("success");
        });
        singleThreadExecutor.shutdown();
    }
    static class Thre{
        private volatile Thread t;

        public Thread getT() {
            return t;
        }

        public void setT(Thread t) {
            this.t = t;
        }
    }
}
