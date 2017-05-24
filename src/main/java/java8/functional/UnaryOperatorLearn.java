package java8.functional;

import java.util.function.UnaryOperator;

import org.junit.Test;
/**
 * UnaryOperator<T> 执行一元操作（与、或、非）
 * @author ChaoChao
 *
 */
public class UnaryOperatorLearn {
    
    @Test
    public void testUnary(){
        UnaryOperator<String> str = s -> s.toUpperCase();
        System.out.println(str.apply("asd"));
    }
}
