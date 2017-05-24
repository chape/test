package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;
/**
 * 对某些方法使用AOP，某些不使用，就像事spring务管理器中切入的时候，我们一般会配置一个模式匹配，哪些类和那些方法才需要做AOP
 * cglib的实现是提供了一个CallbackFilter来实现这个机制
 * @author ChaoChao
 *
 */
public class CglibCallBackFilter {

	static class MethodInterceptorImpl implements MethodInterceptor{

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println("proxy before");
			return proxy.invokeSuper(obj, args);
		}
		
	}
	static class CallbackFilterImpl implements CallbackFilter{

		@Override
		public int accept(Method method) {
			//返回1代表执行callbacks数组角标为1的元素
			return "doTwo".equals(method.getName()) ? 1 : 0;
		}
		
	}
	public static void main(String[] args) {
		Callback[] callbacks = new Callback[]{new MethodInterceptorImpl(),NoOp.INSTANCE};
		Enhancer eh = new Enhancer();
		eh.setSuperclass(CallBackFilterTest.class);
		eh.setCallbacks(callbacks);
		eh.setCallbackFilter(new CallbackFilterImpl());
		CallBackFilterTest cbft = (CallBackFilterTest) eh.create();
		cbft.doOne();
		cbft.doTwo();
	}
}
