package proxy.log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author kevin
 * @time 2016年5月31日 上午8:50:54
 * @desc 自定义注解 LogAnnotation
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

	public String value() default "";

}
