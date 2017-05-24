package java8.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;

import java8.functional.Person;

public class InvokeJs {

	ScriptEngine engine;
	
	@Before
	public void init(){
		engine = new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	@Test
	public void invokeFun1() throws FileNotFoundException, ScriptException, NoSuchMethodException{
		engine.eval(new FileReader("src/main/java/java8/nashorn/invokejs.js"));
		Invocable inv = (Invocable) engine;
		Object result = inv.invokeFunction("fun1", "chape");
		System.out.println(result);
		System.out.println(result.getClass());
	}
	
	@Test
	public void invokeFun2() throws FileNotFoundException, ScriptException, NoSuchMethodException{
		engine.eval(new FileReader("src/main/java/java8/nashorn/invokejs.js"));
		Invocable inv = (Invocable) engine;
		inv.invokeFunction("fun2", new Date());
		inv.invokeFunction("fun2", LocalDateTime.now());
		inv.invokeFunction("fun2", new Person());
	}
	
}
