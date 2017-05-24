package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * org的asm包可以动态修改字节码信息，可以动态在内存中创建class类和修改class类信息
 * cglib包装了对asm的操作，通过创建一个类的子类，然后在调用时，子类方法覆盖父类方法，然后子类在完成相关动作后，进行super的回调
 * @author ChaoChao
 *
 */
public class CglibInterceptor {
	static class MethodInterceptorImpl implements MethodInterceptor{

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println("before");
			proxy.invokeSuper(obj, args);
			System.out.println("after");
			return null;
		}
		
	}
	public static void main(String[] args) {
		Enhancer eh = new Enhancer();
		eh.setSuperclass(TestProxy.class);
		eh.setCallback(new MethodInterceptorImpl());
		TestProxy tp = (TestProxy) eh.create();
		tp.test();
	}
}
