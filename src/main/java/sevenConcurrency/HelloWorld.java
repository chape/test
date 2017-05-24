package sevenConcurrency;

public class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread(){
			public void run() {
				System.out.println("-------my thread");
			};
		};
		myThread.start();
		//主线程让出CPU执行时间,之后与子线程公平竞争
		Thread.yield();
		//主线程休眠
//		Thread.sleep(1);
		System.out.println("-------main thread");
		myThread.join();
	}
}
