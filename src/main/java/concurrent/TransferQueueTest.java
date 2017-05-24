package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
/**
 * 生产者会一直阻塞直到所添加到队列的元素被某一个消费者所消费（不仅仅是添加到队列里就完事）
 *
 */
public class TransferQueueTest {

    private static final TransferQueue<Integer> queue = new LinkedTransferQueue<Integer>();
    private static final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
  
        for (int i = 0; i < 4; i++) {
            newFixedThreadPool.submit(new ProductRunnable(queue, i));
        }
        
        newFixedThreadPool.submit(new ConsumerRunnable(queue));
        
        for (int i = 4; i < 20; i++) {
            newFixedThreadPool.submit(new TransferRunnable(queue, i));
        }
        
        newFixedThreadPool.shutdown();
    }

}

class ProductRunnable implements Runnable {

    private int element;
    private TransferQueue<Integer> queue;

    public ProductRunnable(TransferQueue<Integer> queue, int i) {
        super();
        this.queue = queue;
        this.element = i;
    }

    @Override
    public void run() {
        try {
            queue.put(element);
        } catch (InterruptedException e) {
            System.out.println("element put exception");
        }
        System.out.println("product element : " + this.element);
    }
}

class ConsumerRunnable implements Runnable {

    private TransferQueue<Integer> queue;

    public ConsumerRunnable(TransferQueue<Integer> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("consume element : " + queue.take());
            } catch (InterruptedException e) {
                System.out.println("element take exception");
            }
        }
    }
}

class TransferRunnable implements Runnable {

    private int element;
    private TransferQueue<Integer> queue;

    public TransferRunnable(TransferQueue<Integer> queue, int i) {
        super();
        this.queue = queue;
        this.element = i;
    }

    @Override
    public void run() {
        try {
            queue.transfer(element);
        } catch (InterruptedException e) {
            System.out.println("element transfer exception");
        }
        System.out.println("transfer element : " + this.element);
    }
}