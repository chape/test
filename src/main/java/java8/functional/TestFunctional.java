package java8.functional;

public class TestFunctional {

	public static Integer normal(String s){
		Converter<String, Integer> converter = (form) -> Integer.valueOf(form);
		return converter.convert(s);
	}
	
	public static Integer staticMethodRef(String s){
		Converter<String, Integer> converter = Integer::valueOf;
		return converter.convert(s);
	}
	
	public static String objectMethodRef(String s){
		Something some = new Something();
		Converter<String, String> converter = some::startWith;
		return converter.convert(s);
	}
	
	public static Person constructRef(String s1,String s2){
		PersonFactory<Person> personFactory = Person::new;
		return personFactory.create(s1, s2);
	}
	
	
	
	public static void main(String[] args) {
//		Integer num = normal("123");
//		Integer num = staticMethodRef("123");
//		String num = objectMethodRef("123");
		Person p = constructRef("Pei", "Chao");
		System.out.println(p);
	}
}
