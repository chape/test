package proxy.cglib;

import net.sf.cglib.proxy.Mixin;

public class CglibMixin {
	public static void main(String[] args) {
		Class<?>[] interfaces = new Class[]{Interface1.class,Interface2.class};
		Object[] implementObjs = new Object[]{new Implement1(),new Implement2()};
		Object mixedObj = Mixin.create(interfaces, implementObjs);
		Interface1 in1 = (Interface1)mixedObj;
		Interface2 in2 = (Interface2) mixedObj;
		in1.doInterface1();
		in2.doInterface2();
	}
}
