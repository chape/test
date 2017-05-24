package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import java8.entity.User;

public class ComplexStream {

    public class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + age;
        }
    }

    List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Jack", 23), new Person("David", 12));

    @Test
    public void filter() {

        List<Person> filtered = persons.stream().filter(p -> p.name.startsWith("P")).collect(Collectors.toList());
        System.out.println(filtered);
    }

    @Test
    public void group() {
        Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
    }

    @Test
    public void partition(){
        Map<Boolean, List<Person>> children = persons.stream()
               .collect(Collectors.partitioningBy(p -> p.getAge() < 18));
               System.out.println("Children number: " + children.get(true).size());
               System.out.println("Adult number: " + children.get(false).size());
    }
    
    @Test
    public void average() {
        Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge); // 19.0
    }

    @Test
    public void summaryStat() {
        IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
    }

    @Test
    public void join() {
        String phrase = persons.stream().filter(p -> p.age >= 18).map(p -> p.name).collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
        // In Germany Max and Peter and Pamela are of legal age.
    }

    @Test
    public void collectMap() {
        Map<Integer, String> map = persons.stream().collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
        // {18=Max, 23=Peter;Pamela, 12=David}
    }

    @Test
    public void defineColletor() {
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | "), // supplier
                (j, p) -> j.add(p.name.toUpperCase()), // accumulator
                (j1, j2) -> j1.merge(j2), // combiner
                StringJoiner::toString); // finisher

        String names = persons.stream().collect(personNameCollector);

        System.out.println(names); // MAX | PETER | PAMELA | DAVID
    }

    @Test
    public void reduce() {
        persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println); // Pamela
    }

    @Test
    public void reduce2() {
        Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
            p1.age += p2.age;
            p1.name += p2.name;
            return p1;
        });

        System.out.format("name=%s; age=%s", result.name, result.age);
        // name=MaxPeterPamelaDavid; age=76
    }

    @Test
    public void reduce3() {
        Integer ageSum = persons.stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum); // 76
    }

    @Test
    public void detailReduce3() {
        Integer ageSum = persons.stream().reduce(0, (sum, p) -> {
            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
            return sum += p.age;
        }, (sum1, sum2) -> {
            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
            return sum1 + sum2;
        });
        Optional.of(ageSum).ifPresent(System.out::print);
        // accumulator: sum=0; person=Max
        // accumulator: sum=18; person=Peter
        // accumulator: sum=41; person=Pamela
        // accumulator: sum=64; person=David
    }

    @Test
    public void detailParallelReduce3() {
        Integer ageSum = persons.parallelStream().reduce(0, (sum, p) -> {
            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
            return sum += p.age;
        }, (sum1, sum2) -> {
            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
            return sum1 + sum2;
        });
        Optional.of(ageSum).ifPresent(System.out::print);
        // accumulator: sum=0; person=Pamela
        // accumulator: sum=0; person=David
        // accumulator: sum=0; person=Max
        // accumulator: sum=0; person=Peter
        // combiner: sum1=18; sum2=23
        // combiner: sum1=23; sum2=12
        // combiner: sum1=41; sum2=35
    }

    @Test
    public void groupBy() {
        Map<String, List<Person>> xx = persons.stream().collect(Collectors.groupingBy(p -> p.name));
        System.out.println(xx.toString());
    }

    @Test
    public void partitionBy() {
        Map<Boolean, List<Person>> xx = persons.stream().collect(Collectors.partitioningBy(p -> p.name.startsWith("P")));
        System.out.println(xx.toString());
    }

    @Test
    public void oldJoinStr() {
        StringBuilder xx = new StringBuilder("[");
        for (Person p : persons) {
            if (xx.length() > 1)
                xx.append(",");
            xx.append(p.name);
        }
        xx.append("]");
        System.out.println(xx.toString());
    }

    @Test
    public void joinStr() {
        String xx = persons.stream().map(p -> p.name).collect(Collectors.joining(",", "[", "]"));
        System.out.println(xx);
    }

    @Test
    public void sort() {
        List<Person> xx = persons.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());
        System.out.println(xx);
    }

    @Test
    public void reverse() {
        List<Person> xx = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println(xx);
    }

    @Test
    public void sortMultiConditions() {
        List<Person> xx = persons.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(xx);
    }

    @Test
    public void xxx() {
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
        limit(10).forEach(System.out::println);
    }
    
    public static void main(String[] args) {
        BiFunction<String, Integer, User> bifun = User::new;
        bifun.apply("", 1);
    }

}
