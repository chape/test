package proxy.log;

import java.util.Date;

/**
 * 
 * @author kevin
 * @time 2016年5月30日 上午7:39:02
 * @desc 输出日志 简单实现
 */
public class Logger {

	public static void info(String message) {
		System.out.println(new Date() + "--------->" + message);
	}

}
