package java8.functional;

import java.util.function.BinaryOperator;

import org.junit.Test;
/**
 * BinaryOperator<T,T> 接收两个参数，返回一个值
 * @author ChaoChao
 *
 */
public class BinaryOperatorLearn {

    @Test
    public void testBi(){
        BinaryOperator<Integer> bo = (x,y) -> (x*y);
        System.out.println(bo.apply(1, 8));
    }
}
