package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class FlatMapTest {

    List<Foo> foos = new ArrayList<>();

    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    public void init() {

        // create foos
        IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
    }

    @Test
    public void flatMap() {
        init();
        foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
    }

    @Test
    public void initAndFlatMap() {
        IntStream.range(1, 4).mapToObj(i -> new Foo("Foo" + i)).peek(f -> IntStream.range(1, 4).mapToObj(i -> new Bar("Bar" + i + " <- " + f.name)).forEach(f.bars::add)).flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
    }
}
