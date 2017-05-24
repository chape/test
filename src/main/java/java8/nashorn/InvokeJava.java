package java8.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;

public class InvokeJava {

	public static String fun1(String name){
		System.out.format("Hi there from Java, %s", name);
		return "greetings from java";
	}
	
	ScriptEngine engine;
	
	@Before
	public void init(){
		engine = new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	@Test
	public void invokeJava() throws FileNotFoundException, ScriptException, NoSuchMethodException{
		engine.eval(new FileReader("src/main/java/java8/nashorn/invokejava.js"));
	}
}
