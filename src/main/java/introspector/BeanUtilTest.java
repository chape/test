package introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilTest {

	//Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
	public static void map2Bean(Map<String,Object> map,Object obj){
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				String name = propertyDescriptor.getName();
				if("class".equals(name)){
					continue;
				}
				Method writeMethod = propertyDescriptor.getWriteMethod();
				writeMethod.invoke(obj, map.get(name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Map --> Bean 2: 利用org.apache.commons.beanutils 工具类实现 Map --> Bean  
    public static void transMap2Bean2(Map<String, Object> map, Object obj) {  
        if (map == null || obj == null) {  
            return;  
        }  
        try {  
            BeanUtils.populate(obj, map);  
        } catch (Exception e) {
            System.out.println("transMap2Bean2 Error " + e);  
        }  
    }
    
    //Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map 
	public static Map<String,Object> bean2Map(Object obj){
		if(null == obj){
			return null;
		}
		Map<String,Object> returnMap = new HashMap<>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				String key = propertyDescriptor.getName();
				if("class".equals(key)){
					continue;
				}
				Method readMethod = propertyDescriptor.getReadMethod();
				Object value = readMethod.invoke(obj);
				returnMap.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	
	public static void main(String[] args) {
		PersonBean person = new PersonBean();  
        Map<String, Object> mp = new HashMap<String, Object>();  
        mp.put("name", "Mike");  
        mp.put("age", 25);  
        mp.put("mN", "male");  
  
        // 将map转换为bean  
        map2Bean(mp, person);  
  
        System.out.println("--- transMap2Bean Map Info: ");  
        for (Map.Entry<String, Object> entry : mp.entrySet()) {  
            System.out.println(entry.getKey() + ": " + entry.getValue());  
        }  
  
        System.out.println("--- Bean Info: ");  
        System.out.println("name: " + person.getName());  
        System.out.println("age: " + person.getAge());  
        System.out.println("mN: " + person.getmN());  
  
        // 将javaBean 转换为map  
        Map<String, Object> map = bean2Map(person);  
  
        System.out.println("--- transBean2Map Map Info: ");  
        for (Map.Entry<String, Object> entry : map.entrySet()) {  
            System.out.println(entry.getKey() + ": " + entry.getValue());  
        }  
  
	}
}
