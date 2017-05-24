package com.netease.vcloud.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.log4j.Logger;

import com.netease.vcloud.config.Config;


/**
* <p>Title: HttpClientBuilder</p>
* <p>Description: 构造HttpClient的工具类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-24
*/
public class HttpClientBuilder {	
	
	/** 设置连接超时限制  */
	private static Integer connectionTimeout = Config.getConnectionTimeout();	
	
	/** 设置socket超时限制  */
	private static Integer socketTimeout = Config.getSocketTimeout();
	/**
	 * 
	 * <p>Title: getHttpClient</p>
	 * <p>Description: 创建HttpClient</p>
	 * @return 创建的HttpClient
	 */
	public static HttpClient getHttpClient(){
		
		HttpParams httpParameters = new BasicHttpParams(); 
		
		/* 连接超时 */
		HttpConnectionParams.setConnectionTimeout(httpParameters, connectionTimeout);
		/* socket超时 */
		HttpConnectionParams.setSoTimeout(httpParameters, socketTimeout);
		
		HttpClient httpClient = new DefaultHttpClient(httpParameters);  
		
		return httpClient;
	}

}
