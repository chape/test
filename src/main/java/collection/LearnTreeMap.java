package collection;

import java.util.Map;
import java.util.TreeMap;
/**
 * 超过阈值则取2^n为size
 * @author ChaoChao
 *
 */
public class LearnTreeMap {
   public static void main(String[] args) {
	   Map<String,String> xx = new TreeMap<String,String>();
	   for (int i = 0; i < 17; i++) {
		xx.put(i+"", i+"");
	}
	   System.out.println(xx);
   }
}
