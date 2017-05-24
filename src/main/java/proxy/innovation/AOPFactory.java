package proxy.innovation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * JVM级别的提供的一种代理机制
 * @author ChaoChao
 *
 */
public class AOPFactory implements InvocationHandler {
	private Object proxyed;
	
	public AOPFactory(Object proxyed) {
		super();
		this.proxyed = proxyed;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("this is proxy before");
		Object result = method.invoke(this.proxyed, args);
		System.out.println("this is proxy after");
		return result;
	}

}
