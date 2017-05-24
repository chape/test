package concurrent;

public class AlternateTest {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if(flag){
                    System.out.println(Thread.currentThread() + "-1");
                    flag = false;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            while (true) {
                if(!flag){
                    System.out.println(Thread.currentThread() + "-2");
                    flag = true;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
