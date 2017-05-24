package sevenConcurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家问题
 * 通过ReentrantLock.tryLock避免无尽的死锁，从死锁中恢复
 * @author ChaoChao
 *
 */
public class Philosopher3 extends Thread{

	private ReentrantLock leftChopstick,rightChopstick;
	private Random random;
	public Philosopher3(ReentrantLock leftChopstick, ReentrantLock rightChopstick) {
		super();
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		random = new Random();
	}
	
	@Override
	public void run() {
		try{
			while(true){
				Thread.sleep(random.nextInt(1000));//思考一段时间
				leftChopstick.lock();
				try{
					//获取右手边的筷子
					if(rightChopstick.tryLock(1000, TimeUnit.MILLISECONDS)){
						try{
							Thread.sleep(random.nextInt(1000));//进餐一段时间
						}finally{
							rightChopstick.unlock();
						}
					}else{
						//没有获取到右手边的筷子，放弃并继续思考
					}
				}finally{
					leftChopstick.unlock();
				}
			}
		}catch(InterruptedException e){
			
		}
	}
}
