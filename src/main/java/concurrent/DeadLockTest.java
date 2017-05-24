package concurrent;

public class DeadLockTest {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    private static Object obj3 = new Object();
    
    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(new TwoSourceThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new TwoSourceThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new TwoSourceThread(obj3, obj1), "t3");
        
        t1.start();
//        Thread.sleep(1000);
        t2.start();
//        Thread.sleep(1000);
        t3.start();
        
    }
    
    static class TwoSourceThread implements Runnable{
        private Object obj1;
        private Object obj2;

        public TwoSourceThread(Object obj1, Object obj2) {
            super();
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " acquiring lock on " + obj1);
            synchronized(obj1){
                System.out.println(Thread.currentThread().getName() + " acquired lock on " + obj1);
                work();
                System.out.println(Thread.currentThread().getName() + " acquiring lock on " + obj2);
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on " + obj2);
                    work();
                }
                System.out.println(Thread.currentThread().getName() + " released lock on " + obj2);
            }
            System.out.println(Thread.currentThread().getName() + " released lock on " + obj1);
        }
        
        private void work(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " sleep exception");
            }
        }
    }
}
