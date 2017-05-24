package proxy.innovation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * 创建类的时候，通过实例化实现了InvocationHandler的类（AOPFactory），再将实际要实现的类的class放进去，通过Proxy来实例化
 * @author ChaoChao
 *
 */
public class DynamicProxy {

	public static Object getBean(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Object obj = Class.forName(className).newInstance();
		InvocationHandler handler = new AOPFactory(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
	}
	public static void main(String[] args) {
		try {
			IHello hello = (IHello)getBean("proxy.innovation.HelloImpl");
			hello.sayHi();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
