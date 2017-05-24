package concurrent;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * condition.await的调用者必须获取lock，await时该线程自动释放锁，当其它线程signal后重新获取锁 
 *
 */
public class ConditionTest2 {

    class Buffer {
        private final Lock lock;
        private final Condition full;
        private final Condition empty;
        private int maxSize;
        private final LinkedList<Integer> list;
        Buffer(int size) {
            lock = new ReentrantLock();
            full = lock.newCondition();
            empty = lock.newCondition();
            maxSize = size;
            list = new LinkedList<>();
        }

        public void put(Integer el) {
            lock.lock();
            try {
                while (list.size() >= maxSize) {
                    full.await(); //等待full.signal唤醒
                }
                list.add(el);
                System.out.println(Thread.currentThread() + " -put " + el);
//                Thread.sleep(1000);
                empty.signalAll();//唤醒empty.await线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
        
        public void take(){
            lock.lock();
            try {
                while (list.size() == 0) {
                    empty.await();
                }
                System.out.println(Thread.currentThread() + " -take " + list.pop());
//                Thread.sleep(1000);
                full.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
    
    class Productor implements Runnable{
        private Buffer buffer;
        private Random ran = new Random();
        Productor(Buffer buffer){
            this.buffer = buffer;
        }
        @Override
        public void run() {
            while(true){
                buffer.put(ran.nextInt(100));
            }
        }
    }
    
    class Consumer implements Runnable{
        private Buffer buffer;
        Consumer(Buffer buffer){
            this.buffer = buffer;
        }
        @Override
        public void run() {
            while(true){
                buffer.take();
            }
        }
    }
    
    public static void main(String[] args) {
        ConditionTest2 test = new ConditionTest2();
        Buffer b = test.new Buffer(10);
        Productor productor = test.new Productor(b);
        Consumer consumer = test.new Consumer(b);
        for (int i = 1; i < 4; i++) {
            new Thread(productor, "productor-"+i).start();
        }
        for (int i = 1; i < 4; i++) {
            new Thread(consumer, "consumer-"+i).start();
        }
    }
}
