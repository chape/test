package java8.functional;

import java.util.function.Supplier;

import org.junit.Test;

/**
 * Supplier<T> 类似工厂，调用时会返回一个指定类型的对象
 * @author ChaoChao
 *
 */
public class SupplierLearn {
    @Test
    public void testSup(){
        Supplier<String> sup = () -> "sda";
        System.out.println(sup.get());
    }
}
