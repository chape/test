package java8.optional;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
/**
 * Optional。这也是一个模仿 Scala 语言中的概念，作为一个容器
 * 它可能含有某值，或者不包含。使用它的目的是尽可能避免 NullPointerException。
 * @author ChaoChao
 *
 */
public class OptionalTest {

    @Test
    public void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
        if (text != null) {
            System.out.println(text);
        }
    }

    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    };
    
    @Test
    public void get(){
            Optional<String> op1 = Optional.of("123");
            Assert.assertEquals("123", op1.get());
            System.out.println(op1.get());
    }
    
    @Test
    public void ifPresent(){
            Optional<String> op1 = Optional.of("123");
            op1.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
    
    @Test
    public void nullable(){
            Optional<String> op2 = Optional.ofNullable(null);
            Assert.assertTrue(op2.isPresent() == false);
            System.out.println(op2.orElse("ss"));
    }
}
