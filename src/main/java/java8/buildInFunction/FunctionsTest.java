package java8.buildInFunction;

import java.util.function.Function;

public class FunctionsTest {

	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		System.out.println(backToString.apply("123"));
	}
}
