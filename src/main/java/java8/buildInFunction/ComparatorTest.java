package java8.buildInFunction;

import java.util.Comparator;

import java8.functional.Person;

public class ComparatorTest {

	public static void main(String[] args) {
		Comparator<Person> com = (p1,p2) -> p1.firstName.compareTo(p2.firstName);
		int c1 = com.compare(new Person("li","ming"), new Person("alice","xx"));
		int c2 = com.reversed().compare(new Person("li","ming"), new Person("alice","xx"));
		System.out.println(c1);
		System.out.println(c2);
	}
}
