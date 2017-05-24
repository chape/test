package java8.interf;

public class TestInterface {

	public static void main(String[] args) {
		Formula f = new Formula() {
			
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		double x = f.calculate(100);
		double y = f.sqrt(16);
		System.out.println("x:" + x + ",y:" + y);
	}
}
