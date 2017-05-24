package java8.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static Map<Integer,String> map = new HashMap<Integer,String>();
	
	public static void initMap(){
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val"+i);
		}
	}
	
	public static void printValMap(){
		initMap();
		map.forEach((k,v) -> System.out.println(v));
	}
	
	public static void utilizeMethod(){
		initMap();
		
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3));             // val33

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));     // false

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));    // true

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));             // val33
	}
	
	public static void remove(){
		initMap();
		
		map.remove(3,"val3");
		System.out.println(map.get(3));
	}
	
	public static void other(){
		initMap();
		
//		System.out.println(map.getOrDefault(11, "not found"));
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));             // val9val9

//		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
//		System.out.println(map.get(9));             // val9concat
	}
	
	public static void main(String[] args) {
		other();
	}
}
