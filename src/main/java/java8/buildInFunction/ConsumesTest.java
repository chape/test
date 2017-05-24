package java8.buildInFunction;

import java.util.function.Consumer;

import java8.functional.Person;

public class ConsumesTest {

	public static void main(String[] args) {
		Consumer<Person> consume = (p) -> System.out.println(p.firstName);;
		consume.accept(new Person("li","ming"));
	}
}
