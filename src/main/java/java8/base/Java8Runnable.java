package java8.base;

public class Java8Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {System.out.println(Thread.currentThread().getName() + "-execute");}, "java8");
        t.start();
    }
}
