package concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriterLock内部使用AbstractQueuedSynchronizer实现
 * AQS的状态(int state)是32位的，读锁用高16位，表示持有读锁的线程数(sharedCount);写锁低16位，表示写锁的重入次数(exclusiveCount)
 * state为0表示锁空闲，sharedCount不为0表示分配了读锁，exclusiveCount不为0表示分配了写锁,sharedCount和exclusiveCount肯定不会同时不为0
 * @author ChaoChao
 *
 */
public class ReentrantReadWriterLockTest {
    public static void main(String[] args) {
        PriceInfo pricesInfo = new PriceInfo(1, 2);
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}

class Reader implements Runnable {

    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        super();
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), priceInfo.getPrice1());
            System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), priceInfo.getPrice2());
        }
    }
}

class Writer implements Runnable {

    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        super();
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            priceInfo.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("writer thread exception");
            }
        }
    }

}

class PriceInfo {
    private double price1;
    private double price2;
    private ReentrantReadWriteLock lock;

    public PriceInfo(double price1, double price2) {
        super();
        this.price1 = price1;
        this.price2 = price2;
        this.lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        try{
            return price1;
        }finally{
            lock.readLock().unlock();
        }
    }

    public void setPrices(double price1, double price2) {
        lock.writeLock().lock();
        try{
            this.price1 = price1;
            this.price2 = price2;
        }finally{
            lock.writeLock().unlock();
        }
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

}