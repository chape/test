package btrace;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class HelloWorld {

//	@OnMethod(clazz="org.jboss.resteasy.plugins.server.netty.RestEasyHttpRequestDecoder", method="decode",location=@Location(Kind.RETURN))
//	public static void func(@ProbeClassName String pcn , @ProbeMethodName String pmn,@Duration long d){
//		println("class:"+pcn);
//		println("method:"+pmn);
//		println(d/(1000*1000));//d为纳秒
//		println(timeMillis());
//		println("===hello world !");
//	}
	@OnMethod(clazz="com.fs.module.ip.logic.IpLogic", method="getScenics",location=@Location(Kind.RETURN))
	public static void func(@ProbeClassName String pcn , @ProbeMethodName String pmn){
		println("class:"+pcn);
		println("method:"+pmn);
		println("==========================================hello world !");
	}
}
