package java8.buildInFunction;

import java.util.function.Supplier;

import java8.functional.Person;

public class SuppliersTest {

	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();
	}
}
