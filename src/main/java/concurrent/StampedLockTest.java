package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;
/**
 * 改进ReentrantReadWriterLock，将锁细分为悲观写，悲观读，乐观读。乐观锁用来验证乐观读期间是否有写锁执行，如果有写锁执行则转换为悲观读锁
 * @author ChaoChao
 *
 */
public class StampedLockTest {
    private static final Point p = new Point();
    private static final ExecutorService tpool = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            tpool.submit(() -> {
                p.moveIfOrigin(1.0, 2.0);
            });
        }
        for (int i = 0; i < 5; i++) {
            tpool.submit(() -> {
                System.out.println(p.distanceFromOrigin());
            });
        }
        tpool.shutdown();
    }
}

class Point {
    private double x, y;
    private final StampedLock lock = new StampedLock();

    public void move(double deltaX, double deltaY) {
        long stamp = lock.readLock();
        try {
            x = x + deltaX;
            y = y + deltaY;
        } finally {
            lock.unlock(stamp);
        }
    }

    /**
     * 乐观读锁转换为悲观读锁
     * @return
     */
    public double distanceFromOrigin() {
        long stamp = lock.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                lock.unlock(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
    /**
     * 悲观读转换为写锁
     * @param newX
     * @param newY
     */
    public void moveIfOrigin(double newX, double newY){
        long stamp = lock.readLock();
        try{
            while(x == 0.0 && y == 0.0){
                long wstamp = lock.tryConvertToWriteLock(stamp);
                if(wstamp != 0){
                    stamp = wstamp;
                    x = newX;
                    y = newY;
                    break;
                }else{
                    lock.unlockRead(stamp);
                    stamp = lock.writeLock();
                }
            }
        }finally{
            lock.unlock(stamp);
        }
    }
    
}