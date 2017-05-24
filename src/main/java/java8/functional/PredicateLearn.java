package java8.functional;

import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;
/**
 * Predicate<T> 断言，一般用来判断是否满足某条件
 * @author ChaoChao
 *
 */
public class PredicateLearn {

    @Test
    public void testPredicate(){
        Predicate<String> predicate01 = (s) -> s.length() > 7;  
        Predicate<String> predicate02 = (s) -> s.contains("s");  
        assertTrue(predicate01.test("abcdefgh"));  //true  
        assertTrue(predicate01.and(predicate02).negate().test("abcdefgh"));  //true  
        assertTrue(predicate01.and(predicate02).test("abcdefghs")); //true  
        assertTrue(predicate01.or(predicate02).test("abcdefgh"));  //true  
        assertTrue(Predicate.isEqual("asd").test("asd")); 
    }
}
