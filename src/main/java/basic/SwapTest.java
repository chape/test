package basic;

import java.lang.reflect.Field;

public class SwapTest {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Integer a =1,b=2;
//        int a =1,b=2;
        System.out.println("a=" + a + " ,b=" + b);
        swap2(a,b);
        System.out.println("a=" + a + " ,b=" + b);
        System.out.println(Integer.valueOf(1) == a);
        System.out.println(Integer.valueOf(1));
        System.out.println(Integer.valueOf(2));
        System.out.println(Integer.valueOf(3));
    }
    /****************虽然以下两种方案可以实现方法外数据交换,但是污染了Integer缓存区***************/
    public static void swap1(Integer i1,Integer i2) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	Field declaredField = Integer.class.getDeclaredField("value");
    	declaredField.setAccessible(true);
    	//防止缓存(-128~127),新建对象
    	Integer temp = new Integer(i1.intValue());
        declaredField.set(i1, i2.intValue());
        declaredField.set(i2, temp);
    }
    public static void swap2(Integer i1,Integer i2) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	Field declaredField = Integer.class.getDeclaredField("value");
    	declaredField.setAccessible(true);
    	int temp = i1.intValue();
    	//直接设置基础数据类型
    	declaredField.setInt(i1, i2.intValue());
    	declaredField.setInt(i2, temp);
    }

    /***********常规方法，但是无法在方法外实现交换数据 *****************/
    public static void swap3(int a,int b){
    	int temp = a;
    	a = b;
    	b =temp;
    	System.out.println("xxx:"+ a + ","+b);
    }
    public static void swap4(int a,int b){
    	a = a^b;
    	b = a^b;
    	a = a^b;
    	System.out.println("xxx:"+ a + ","+b);
    }
    public static void swap5(int a,int b){
    	a = a + b;
    	b = a - b;
    	a = a - b;
    	System.out.println("xxx:"+ a + ","+b);
    }
    
}
