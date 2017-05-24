package java8.share;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class OptionalTest {

    @Test
    public void print() {
        String text = null;
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
        if (text != null) {
            System.out.println(text);
        }
    }

    @Test
    public void getLength() {
        String text = null;
        // Java 8
        System.out.println(Optional.ofNullable(text).map(String::length).orElse(-1));
        // Pre-Java 8
        System.out.println(text != null ? text.length() : -1);
    };

    @Test
    public void get() {
        //不能为null 否则抛异常
        Optional<String> op1 = Optional.of("123");
        Assert.assertEquals("123", op1.get());
    }

    @Test
    public void nullable() {
        //可为null 如果为null则返回Optional.empty()
        Optional<String> op2 = Optional.ofNullable(null);
        Assert.assertTrue(op2.isPresent() == false);
    }
    
    @Test
    public void ifPresent() {
        Optional<String> op1 = Optional.of("123");
        op1.ifPresent((s) -> System.out.println(s.charAt(0)));
    }

    class Outer {
        Nested nested;

        public Nested getNested() {
            return nested;
        }
    }

    class Nested {
        Inner inner;

        public Inner getInner() {
            return inner;
        }
    }

    class Inner {
        String x;

        public String getX() {
            return x;
        }
    }

    @Test
    public void checkNull() {
        Outer outer = new Outer();
        if(null != outer){
            Nested nested = outer.getNested();
            if(null != nested){
                Inner inner = nested.getInner();
                if(null != inner){
                    String x = inner.getX();
                    if(null != x){
                        System.out.println(x);
                    }
                }
            }
        }
    }

    /**
     * 使用 Optional 时尽量不直接调用 Optional.get() 方法
     * Optional.isPresent() 更应该被视为一个私有方法, 应依赖于其他像 Optional.orElse(), Optional.orElseGet(), Optional.map() 等方法
     */
    @Test
    public void uglyOptional(){
        Optional<Outer> optionalOuter = Optional.ofNullable(new Outer());
        
        if(optionalOuter.isPresent()){
            Nested nested = optionalOuter.get().getNested();
            Optional<Nested> optionalNested = Optional.ofNullable(nested);
            if(optionalNested.isPresent()){
                Inner inner = optionalNested.get().getInner();
                Optional<Inner> optionalInner = Optional.ofNullable(inner);
                if(optionalInner.isPresent()){
                    String x = optionalInner.get().getX();
                    Optional<String> optionalX = Optional.ofNullable(x);
                    if(optionalX.isPresent()){
                        System.out.println(optionalX.get());
                    }
                }
            }
        }
    }
    
    @Test
    public void optional() {
        Optional.ofNullable(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.x))
                .ifPresent(System.out::println);
    }
    
    @Test
    public void optional2() {
        Optional.ofNullable(new Outer())
                .map(o -> o.nested)
                .map(n -> n.inner)
                .map(i -> i.x)
                .ifPresent(System.out::println);
    }
    
    static class Summer {
        public static void main(String args[]) {

            Integer value1 = null;
            Integer value2 = new Integer(10);
            Optional<Integer> a = Optional.ofNullable(value1);
            Optional<Integer> b = Optional.ofNullable(value2);
            System.out.println(sum(a, b));
        }

        private static Integer sum(Optional<Integer> a, Optional<Integer> b) {

            System.out.println("1st parameter is present: " + a.isPresent());
            System.out.println("2nd parameter is present: " + b.isPresent());

            Integer value1 = a.orElse(new Integer(0));
            Integer value2 = b.orElse(new Integer(0));
            return value1 + value2;
        }
    }
}
