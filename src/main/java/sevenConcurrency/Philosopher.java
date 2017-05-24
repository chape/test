package sevenConcurrency;

import java.util.Random;

/**
 * 哲学家问题
 * 所有哲学家同时进餐，同时拿起左手边的筷子，会出现死锁
 * @author ChaoChao
 *
 */
public class Philosopher extends Thread{

	private Chopstick left,right;
	private Random random;
	public Philosopher(Chopstick left, Chopstick right) {
		super();
		this.left = left;
		this.right = right;
		random = new Random();
	}
	
	@Override
	public void run() {
		try{
			while(true){
				Thread.sleep(random.nextInt(1000));//思考一段时间
				synchronized(left){//拿起筷子1
					synchronized(right){//拿起筷子2
						Thread.sleep(random.nextInt(1000));//进餐一段时间
					}
				}
			}
		}catch(InterruptedException e){
			
		}
	}
}
