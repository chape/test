package java8.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import java8.entity.Person;

public class PersonSupplier implements Supplier<Person> {

    private int index = 0;
    private Random random = new Random();

    @Override
    public Person get() {
        return new Person(index++, "StormTestUser" + index, random.nextInt(100));
    }
    
    public static void main(String[] args) {
        Stream.generate(new PersonSupplier())
        .limit(10)
        .forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));
    }
}
