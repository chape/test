package collection;

import java.util.HashMap;
import java.util.Map;
/**
 * 超过阈值则取2^n为size
 * @author ChaoChao
 *
 */
public class LearnHashMap {
   public static void main(String[] args) {
	   Map<String,String> xx = new HashMap<String,String>();
	   for (int i = 0; i < 17; i++) {
		xx.put(i+"", i+"");
	}
	   System.out.println(xx);
   }
}
