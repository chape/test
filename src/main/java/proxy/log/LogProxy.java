package proxy.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author kevin
 * @time 2016年5月30日 上午7:41:56
 * @desc 代理类 这里实现InvocationHandler接口
 */
@SuppressWarnings("unused")
public class LogProxy implements InvocationHandler {

	private LogProxy() {
		// 私有构造不让外部调用
	}

	private Object target;

	// 这里的参数o就是要代理的目标对象
	public static Object getInstance(Object source) {
		if(source == null){
			return null;
		}
		LogProxy pm = new LogProxy();
		pm.target = source;// 赋值,设置这个代理对象
		// 通过Proxy的方法创建代理对象，
		// 第一个参数是要代理对象的ClassLoader装载器
		// 第二个参数是要代理对象实现的所有接口
		// 第三个参数是实现了InvocationHandler接口的对象
		// 此时的result就是一个代理对象，代理的是o
		Object result = Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), pm);
		return result;//返回的是代理对象
	}
	
	//传入类字节码 
	public static Object getInstance(Class<?> clazz) {
		if(clazz == null){
			return null;
		}
		LogProxy pm = new LogProxy();
		Object source = null;
		try {
			source = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		pm.target = source;// 赋值,设置这个代理对象
		// 通过Proxy的方法创建代理对象，
		// 第一个参数是要代理对象的ClassLoader装载器
		// 第二个参数是要代理对象实现的所有接口
		// 第三个参数是实现了InvocationHandler接口的对象
		// 此时的result就是一个代理对象，代理的是o
		Object result = Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), pm);
		return result;//返回的是代理对象
	}


	// good palce ：减少代码侵入
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 如果下边不判断方法名的话，就会拦截到被代理对象的所有方法的执行。
		// if(method.getName().equalsIgnoreCase("add")){
		// //输入日志
		// Logger.info("动态代理日志信息.");
		// }
		// 2.自己定义一个annotation的类(LogAnnotation)，进行注解拦截。有注解的方法才会被拦截
		if (method.isAnnotationPresent(LogAnnotation.class)) {
			LogAnnotation la = method.getAnnotation(LogAnnotation.class);
			// 获取方法的参数类型
			/*
			 * Class<?>[] parameters = method.getParameterTypes();//参数类型
			 * if(parameters != null || parameters.length!=0){ Class<? extends
			 * Class[]> clazz = parameters.getClass(); }
			 */

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					System.out.println(args[i]);
					//掉用日志记录dao记录明细日志
				}
			}
			/*Class<?> declaringClass = method.getDeclaringClass();
			String name2 = method.getClass().getName();
			String name = declaringClass.getName();
			String canonicalName = declaringClass.getCanonicalName();
			Annotation[] declaredAnnotations = declaringClass.getDeclaredAnnotations();
			Annotation[] annotations = declaringClass.getAnnotations();*/
			
			Logger.info(la.value() + "--->执行的是" + method.getName() + "方法.");
		}
		Object obj = method.invoke(target, args);
		return obj;
	}

}
