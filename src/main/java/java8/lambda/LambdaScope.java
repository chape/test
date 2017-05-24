package java8.lambda;

import org.junit.Test;

import java8.functional.Converter;

public class LambdaScope {

	static int outerStaticNum;
	int outerNum;
	
	@Test
	public void testInstanceScope(){
		Converter<Integer,String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};
		stringConverter1.convert(1);
	}
	
	@Test
	public void testInstanceStaticScope(){
		Converter<Integer,String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			System.out.println(outerStaticNum);
			return String.valueOf(from);
		};
		stringConverter2.convert(1);
	}
	
	@Test
	public void testLocalScope(){
		int num = 1;//隐式final变量
		Converter<Integer, String> c = (from) -> String.valueOf(from + num);
		String result = c.convert(2);
		System.out.println(result);
	}
	
}
