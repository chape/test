package javaslang;

public class Hello {

	public static void main(String[] args) {
		Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
		System.out.println(java8._1);
		System.out.println(java8._2);
		Tuple2<String, Integer> transfered = java8.map(a1 -> a1 + "xx", a2 -> a2/2);
		System.out.println(transfered._1);
		System.out.println(transfered._2);
	}
}
