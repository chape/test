package java8.basic;

import java.util.function.BinaryOperator;

import org.junit.Test;
/**
 * 函数接口指仅有单个抽象方法的接口，用来表示Lambda表达式类型
 * @author ChaoChao
 *
 */
public class BaseLambda {

	@Test
    public void test(){
    	BinaryOperator<Integer> xx = (Integer x,Integer y) -> x+y;
    	System.out.println(xx.apply(1, 2));
    }
}
