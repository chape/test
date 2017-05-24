package java8.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;

public class HelloWorld {

	ScriptEngine engine;
	
	@Before
	public void init(){
		engine = new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	@Test
	public void eval() throws ScriptException{
		engine.eval("print('hello world')");
	}
	
	@Test
	public void evalFromFile() throws FileNotFoundException, ScriptException{
		engine.eval(new FileReader("src/main/java/java8/nashorn/helloworld.js"));
	}
}
