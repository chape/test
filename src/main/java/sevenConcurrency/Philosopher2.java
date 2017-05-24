package sevenConcurrency;

import java.util.Random;

/**
 * 哲学家问题
 * 按照全局固定的顺序获取多把锁来消除死锁的问题
 * 另外，也可以实用对象的散列值作为锁的全局顺序，System.identityHashCode(Object object),但是还是有很小的几率重复
 * @author ChaoChao
 *
 */
public class Philosopher2 extends Thread{

	private Chopstick first,second;
	private Random random;
	public Philosopher2(Chopstick left, Chopstick right) {
		super();
		if(left.getId() < right.getId()){
			this.first = left;
			this.second = right;
		}else{
			this.first = right;
			this.second = left;
		}
		random = new Random();
	}
	
	@Override
	public void run() {
		try{
			while(true){
				Thread.sleep(random.nextInt(1000));//思考一段时间
				synchronized(first){//拿起筷子1
					synchronized(second){//拿起筷子2
						Thread.sleep(random.nextInt(1000));//进餐一段时间
					}
				}
			}
		}catch(InterruptedException e){
			
		}
	}
}
