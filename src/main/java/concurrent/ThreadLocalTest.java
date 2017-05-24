package concurrent;
/**
 * ThreadLocal内部维护着一个HashMap<Thread,T>对象
 * @author ChaoChao
 *
 */
public class ThreadLocalTest {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {

            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("interrupt exception");
            }

            System.out.println(Thread.currentThread().getName()+" value:"+threadLocal.get());

        }

    }

    public static void main(String[] args) throws InterruptedException {

        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance,"thread1");

        Thread thread2 = new Thread(sharedRunnableInstance,"thread2");

        thread1.start();
        thread2.start();

        thread1.join(); // wait for thread 1 to terminate
        thread2.join(); // wait for thread 2 to terminate
    }
}
