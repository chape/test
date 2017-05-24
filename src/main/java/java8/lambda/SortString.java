package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortString {

	public static void oldSort(List<String> preList){
		Collections.sort(preList, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
			
		});
	}
	
	public static void lambdaSort(List<String> preList){
		Collections.sort(preList,(String a, String b) -> {
			return a.compareTo(b);
		});
	}
	
	public static void lambdaShorterSort(List<String> preList){
		Collections.sort(preList,(String a, String b) -> a.compareTo(b));
	}
	
	public static void lambdaShortestSort(List<String> preList){
		Collections.sort(preList,(a, b) -> a.compareTo(b));
	}
	
	public static void main(String[] args) {
		List<String> preList = Arrays.asList("cc","aa","bb");
//		oldSort(preList);
//		lambdaSort(preList);
//		lambdaShorterSort(preList);
		lambdaShortestSort(preList);
		System.out.println(preList);
	}
}
