package collection;

import java.util.HashSet;
import java.util.Set;
/**
 * 超过阈值则取2^n为size
 * @author ChaoChao
 *
 */
public class LearnHashSet {
   public static void main(String[] args) {
	   Set<String> xx = new HashSet<String>();
	   for (int i = 0; i < 17; i++) {
		xx.add(i+"");
	}
	   System.out.println(xx);
   }
}
