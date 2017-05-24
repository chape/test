package sevenConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counting2 {

	public static void main(String[] args) throws InterruptedException {
		class Counter{
			//原子类型
			private AtomicInteger count = new AtomicInteger(0);
			public synchronized void increment(){ count.incrementAndGet();}
			public int getCount(){ return count.get();}
		}
		
		final Counter counter = new Counter();
		
		class CountingThread extends Thread{
			public void run(){
				for (int i = 0; i < 10000; i++) {
					counter.increment();
				}
			}
		}
		
		CountingThread ct1 = new CountingThread();
		CountingThread ct2 = new CountingThread();
		ct1.start();
		ct2.start();
		ct1.join();
		ct2.join();
		System.out.println(counter.getCount());
	}
}
