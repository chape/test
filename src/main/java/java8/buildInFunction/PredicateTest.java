package java8.buildInFunction;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		Predicate<String> predicate = (s) -> s.length() > 0;
		boolean x1 = predicate.test("foo");
		boolean x2 = predicate.negate().test("foo");
		System.out.println(x1);
		System.out.println(x2);
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		boolean y1 = nonNull.test(false);
		boolean y2 = isNull.test(null);
		System.out.println(y1);
		System.out.println(y2);
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		boolean z1 = isEmpty.test("");
		boolean z2 = isNotEmpty.test("");
		System.out.println(z1);
		System.out.println(z2);
	}
}
