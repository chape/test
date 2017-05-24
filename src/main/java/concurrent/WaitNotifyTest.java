package concurrent;

import java.util.LinkedList;
import java.util.Random;

public class WaitNotifyTest {

    class Buffer {
        final LinkedList<Integer> list;
        final int maxSize;

        Buffer(int size) {
            list = new LinkedList<>();
            this.maxSize = size;
        }

        public void put(Integer ele) {
            try {
                synchronized (list) {
                    while (list.size() >= maxSize) {
                        list.wait();
                    }
                    list.add(ele);
                    System.out.println(Thread.currentThread() + " -put" + ele);
                    list.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        public void take() {
            try {
                synchronized (list) {
                    while (list.size() <= 0) {
                        list.wait();
                    }
                    System.out.println(Thread.currentThread() + " -put" + list.pop());
                    list.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    class Productor implements Runnable{
        private Buffer buffer;
        Random ran = new Random();
        public Productor(Buffer b) {
            this.buffer = b;
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
        Random ran = new Random();
        public Consumer(Buffer b) {
            this.buffer = b;
        }
        @Override
        public void run() {
            while(true){
                buffer.take();
            }
        }
    }
    
    public static void main(String[] args) {
        WaitNotifyTest test = new WaitNotifyTest();
        Buffer buffer = test.new Buffer(10);
        Productor productor = test.new Productor(buffer);
        Consumer consumer = test.new Consumer(buffer);
        for (int i = 1; i < 4; i++) {
            new Thread(productor,"productor" + i).start();
        }
        for (int i = 1; i < 4; i++) {
            new Thread(consumer,"consumer" + i).start();
        }
    }
}
