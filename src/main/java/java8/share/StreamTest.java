package java8.share;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import java8.entity.User;
import javaslang.Tuple2;

public class StreamTest {

    //-----------------------产生流--------------------------//
    @Test
    public void generateStream() throws IOException {
            
            Stream.of("a1","a3","a2")
                .findFirst()
                .ifPresent(System.out :: print);
            
            IntStream.range(1, 10)
                .forEach(System.out :: print);
            
            Arrays.stream(new int[]{1,2,3})
                .map(num -> num*2 + 1)
                .average()
                .ifPresent(System.out :: print);
            
            Random seed = new Random();
            Supplier<Integer> random = seed::nextInt;
            //Returns an infinite sequential unordered stream 断路
            Stream.generate(random).limit(10).forEach(System.out::println);
            seed.ints().limit(10).forEach(System.out::println);
            
            /* 
            iterate 跟 reduce 操作很像，接受一个种子值，和一个 UnaryOperator（例如 f）。
            然后种子值成为 Stream 的第一个元素，f(seed) 为第二个，f(f(seed)) 第三个，以此类推。
            Returns an infinite sequential unordered stream
           */
            Stream.iterate(0, n -> n + 3).limit(10)
                  .forEach(x -> System.out.print(x + " "));
            
            List<String> myList = Arrays.asList("x2","a4","b3","a6","a5","a3");
            myList.stream()
                            .filter(s -> s.startsWith("a"))
                            .map(String :: toUpperCase)
                            .sorted()
                            .forEach(System.out :: print);
            
            Arrays.asList("x2","a4","b3","a6","a5","a3")
                            .stream()
                            .findFirst()
                            .ifPresent(System.out :: print);
            
            "ABCDEFG_abcdefg".chars().forEach(System.out::println);
            
            Stream.concat(Stream.of("1","2"), Stream.of("3","4","5")).count();
            
            IntStream.generate(() -> (int) (System.nanoTime() % 100)).
            limit(10).forEach(System.out::println);
            
            BitSet.valueOf(new byte[]{1,2,3,4}).stream().count();
            
            String foostr = "DAFwaq";
            Pattern.compile("").splitAsStream(foostr)
                        .map(String::toLowerCase)
                        .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
            
            //从 BufferedReader
            BufferedReader br = new BufferedReader(new FileReader("/Users/ChaoChao/Downloads/logtail.log"));
            br.lines().forEach(System.out::println);
            br.close();
            
            //从 jarFile
            JarFile jarFile = new JarFile("/Users/ChaoChao/Downloads/app.jar");
                jarFile.stream()
                .peek(file -> System.out.println("Files :- " + file))
                    .filter(file -> file.getName().contains("App.class"))
                    .findFirst();
                jarFile.close();
            
            Stream.of("a1","a2","a3")
                            .map(e -> e.substring(1))
                            .mapToInt(Integer :: parseInt)
                            .max()
                            .ifPresent(System.out :: println);
            
            IntStream.range(1, 10)
                                    .mapToObj(e -> "a" + e)
                                    .forEach(System.out :: print);
            
            Stream.of(1.0,2.0,3.0)
                                    .mapToInt(Double::intValue)
                                    .mapToObj(e -> "b" + e)
                                    .forEach(System.out :: print);
    }
    
    public class Person {
        String name;
        Integer age;
        Integer gender;//1男 2女

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name, Integer age, Integer gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return name + age;
        }
    }

    List<Person> persons = Arrays.asList(new Person("Max", 18, 2), new Person("Peter", 24, 2), new Person("Jack", 23, 1), new Person("David", 18, 2));

    //-----------------------常用操作:中间操作--------------------------//
    @Test
    public void filter() {
        List<Person> filtered = persons.stream().filter(p -> p.name.startsWith("P")).collect(Collectors.toList());
        System.out.println(filtered);
    }
    @Test
    public void map(){
        persons.stream().map(p -> p.getName()).forEach(System.out::println);
    }
    @Test
    public void flatMap(){
        Stream.of(persons,persons).flatMap(ps -> ps.stream()).forEach(p -> System.out.println(p.getName()));
    }
    @Test
    public void sort() {
        List<Person> xx = persons.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());
        System.out.println(xx);
    }
    //-----------------------常用操作:终端操作--------------------------//
    @Test
    public void forEach() {
        persons.stream().forEach(System.out::println);
    }
    @Test
    public void collect() {
        persons.stream().distinct().collect(Collectors.toList());
    }
    @Test
    public void match() {
        persons.stream().anyMatch(p -> p.getName().startsWith("M"));
    }
    @Test
    public void count() {
        persons.stream().count();
    }
    @Test
    public void reduce() {
        persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println); // Pamela
    }
    //-----------------------常用操作:短路操作--------------------------//
    @Test
    public void findFirst() {
        persons.stream().map(p -> p.getName()).filter(pname -> pname.startsWith("M")).findFirst().orElse("nothing");
    }
    @Test
    public void limit() {
        IntStream.generate(() -> (int) (System.nanoTime() % 100))
                .limit(10)
                .forEach(System.out::println);
    }
    //-----------------------流转换为集合--------------------------//
    @Test
    public void toList() {
        persons.stream().map(p -> p.getName()).collect(Collectors.toList());
    }
    @Test
    public void toSet() {
        persons.stream().map(p -> p.getName()).collect(Collectors.toSet());
    }
    @Test
    public void toArray() {
        persons.stream().map(p -> p.getName()).toArray(Integer[] :: new);
    }
    @Test
    public void toMap() {
        Map<Integer, String> map = persons.stream().collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + ";" + name2));
        System.out.println(map);
    }
    //-----------------------聚合操作--------------------------//
    @Test
    public void groupBy() {
        Map<String, List<Person>> xx = persons.stream().collect(Collectors.groupingBy(p -> p.name));
        System.out.println(xx.toString());
    }
    @Test
    public void groupCategory(){
        persons.stream().collect(Collectors.groupingBy(p -> p.getGender(), Collectors.averagingInt(p -> p.getAge())));
    }
    @Test
    public void secondGroup(){
        Map<Integer, Map<Integer, List<Person>>> smap = 
                persons.stream()
                .collect(Collectors
                        .groupingBy(Person::getGender, 
                                Collectors.groupingBy(Person::getAge)));
        System.out.println(smap);
    }
    @Test
    public void groupTuple() {
        Map<Tuple2<Integer, Integer>, Double> collect = persons.stream()
                .collect(Collectors
                        .groupingBy(p -> new Tuple2<>(p.getAge(),p.getGender()), 
                                Collectors.averagingInt(p -> p.getAge())));
        System.out.println(collect);
    }
    @Test
    public void partitionBy() {
        Map<Boolean, List<Person>> xx = persons.stream().collect(Collectors.partitioningBy(p -> p.name.startsWith("P")));
        System.out.println(xx.toString());
    }
    
    //-----------------------其它操作--------------------------//
    @Test
    public void top10(){
        List<Person> top10 = persons.stream()
                .sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(top10);
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

        System.out.println(averageAge);
    }

    @Test
    public void summaryStat() {
        IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
    }

    @Test
    public void join() {
        String phrase = persons.stream().filter(p -> p.age >= 18).map(p -> p.name).collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
    }

    @Test
    public void defineColletor() {
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | "), // supplier
                (j, p) -> j.add(p.name.toUpperCase()), // accumulator
                (j1, j2) -> j1.merge(j2), // combiner
                StringJoiner::toString); // finisher

        String names = persons.stream().collect(personNameCollector);

        System.out.println(names);
    }

    @Test
    public void reduce2() {
        Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
            p1.age += p2.age;
            p1.name += p2.name;
            return p1;
        });

        System.out.format("name=%s; age=%s", result.name, result.age);
    }

    @Test
    public void reduce3() {
        Integer ageSum = persons.stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum);
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
    public void reverse() {
        List<Person> xx = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println(xx);
    }

    @Test
    public void sortMultiConditions() {
        List<Person> xx = persons.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(xx);
    }

    public static void main(String[] args) {
        BiFunction<String, Integer, User> bifun = User::new;
        bifun.apply("", 1);
    }
    
}
