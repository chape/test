package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 在main函数结束后，虚拟机会自动启动一个DestroyJavaVM线程，该线程会等待所有user thread 线程结束后退出（即只剩下daemon 线程和DestroyJavaVM线程自己，整个虚拟机就退出，此时daemon线程被终止）
 *      lock -> 调用后一直阻塞到获得锁
 *      tryLock -> 尝试是否能获得锁 如果不能获得则立即返回false，否则立即返回true
 *      lockInterruptibly -> 调用后一直阻塞到获得锁 但是接受中断信号(类似线程处于sleep、wait、join，此时如果别的线程调用此线程的interrupt方法，此线程会被唤醒并被要求处理InterruptedException)
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // lock.lock();
                // System.out.println(Thread.currentThread().getName() + " interrupted.");
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "thread-1");
        
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(10000);
    }
}
