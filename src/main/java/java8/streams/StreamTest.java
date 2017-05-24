package java8.streams;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import java8.entity.Person;

public class StreamTest {

    @Test
    public void filter() {
        Stream.generate(() -> UUID.randomUUID().toString()).limit(10).filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }

    @Test
    public void sort() {
        Stream.generate(() -> UUID.randomUUID().toString()).limit(10).sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }

    @Test
    public void map() {
        Stream.generate(() -> UUID.randomUUID().toString()).limit(10).map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
    }

    @Test
    public void anyMatchStartWithA() {
        boolean any = Stream.generate(() -> UUID.randomUUID().toString()).limit(10).anyMatch((s) -> s.startsWith("a"));
        System.out.println(any);
    }

    @Test
    public void allMatchStartWithA() {
        boolean all = Stream.generate(() -> UUID.randomUUID().toString()).limit(10).allMatch((s) -> s.startsWith("a"));
        System.out.println(all);
    }

    @Test
    public void noneMatchStartWithZ() {
        boolean none = Stream.generate(() -> UUID.randomUUID().toString()).limit(10).noneMatch((s) -> s.startsWith("z"));
        System.out.println(none);
    }

    @Test
    public void countStartWithB() {
        long sum = Stream.generate(() -> UUID.randomUUID().toString()).limit(10).filter(s -> s.startsWith("b")).count();
        System.out.println(sum);
    }

    /**
     * parallel 转为并行流
       sequential 转为串行流
     */
    @Test
    public void paraSequential(){
        Stream.of(1,2,3,4).parallel();
        Stream.of(1,2,3,4).sequential();
    }
    
    /*
    提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。
    从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。例如 Stream 的 sum 就相当于
    Integer sum = integers.reduce(0, (a, b) -> a+b); 或
    Integer sum = integers.reduce(0, Integer::sum);
    */
    @Test
    public void reduce() {
        Optional<String> sumStr = Stream.generate(() -> UUID.randomUUID().toString()).limit(10).sorted().reduce((a, b) -> a + "#" + b);
        sumStr.ifPresent(System.out::println);

        // 字符串连接，concat = "ABCD"
        Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
    }

    @Test
    public void filtedList() {
        Stream.generate(() -> UUID.randomUUID().toString()).limit(10).filter((e) -> e.startsWith("a")).collect(Collectors.toList());
    }

    // limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素
    @Test
    public void limitSkip() {
        Stream.generate(new PersonSupplier()).limit(100).map(Person::getName).limit(10).skip(3).peek(System.out::println).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        Stream.of(1,2,3,4).unordered().forEach(System.out::println);
    }
}
