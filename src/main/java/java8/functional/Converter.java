package java8.functional;

/**
 * 
 * @author ChaoChao
 * 不能有超过两个函数方法
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F,T> {

	T convert(F form);
}
