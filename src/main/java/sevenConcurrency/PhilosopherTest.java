package sevenConcurrency;

public class PhilosopherTest {

	public static void main(String[] args) throws InterruptedException {
		Chopstick c1 = new Chopstick();
		Chopstick c2 = new Chopstick();
		Chopstick c3 = new Chopstick();
		Chopstick c4 = new Chopstick();
		Chopstick c5 = new Chopstick();
		Philosopher p1 = new Philosopher(c1,c2);
		Philosopher p2 = new Philosopher(c2,c3);
		Philosopher p3 = new Philosopher(c3,c4);
		Philosopher p4 = new Philosopher(c4,c5);
		Philosopher p5 = new Philosopher(c5,c1);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}
}
