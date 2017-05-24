package java8.functional;

import java.util.function.Function;

import org.junit.Test;
/**
 * Function<T,R> 接收T对象，返回R对象
 * @author ChaoChao
 *
 */
public class FunctionLearn {

    @Test
    public void testFun(){
        Function<String, Integer> fun = (a) -> new Integer(a.length()); 
        System.out.println(fun.apply("asd"));
    }
}
