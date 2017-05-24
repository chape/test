package java8.functional;

import java.util.function.Consumer;

import org.junit.Test;
/**
 * Consumer<T> 接收一个参数，无返回值
 * @author ChaoChao
 *
 */
public class ConsumerLearn {

    @Test
    public void testCon(){
        Consumer<String> con = s -> System.out.println(s.toUpperCase());
        con.accept("asd");
    }
}
