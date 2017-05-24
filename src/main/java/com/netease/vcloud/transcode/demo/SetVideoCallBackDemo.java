package com.netease.vcloud.transcode.demo;


import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.transcode.param.SetVideoCallBackParam;



/**
* <p>Title: SetVideoCallBackDemo</p>
* <p>Description: 设置回调地址接口的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class SetVideoCallBackDemo {
	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(SetVideoCallBackDemo.class);

	public static void main(String[] args) {
		/* 输入个人信息 */
		/* 开发者平台分配的appkey 和 appSecret */
		String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
		String appSecret = "a7224d72e2e440329f680004da882fe61";  	    

		Credentials credentials;
		credentials = new BasicCredentials(appKey, appSecret);
		VcloudClient vclient = new VcloudClient(credentials);

		/* 转码成功后回调客户端的URL地址    参数必填*/
		String callbackUrl = new String("http://127.0.0.1/client/callback");

		try{	
			/*设置回调地址接口返回结果的封装类*/
			SetVideoCallBackParam setVideoCallBackParam = vclient.setVideoCallBack(callbackUrl);

			if(setVideoCallBackParam.getCode() == 200){
				logger.info("[SetVideoCallBackDemo] set callbackURL successfully. ");
			}else{
				logger.info("[SetVideoCallBackDemo] fail to set callbackURL. " + "return code : " + setVideoCallBackParam.getCode() + " return message: " + setVideoCallBackParam.getMsg());
			} }catch (Exception e) {
				e.printStackTrace();
			}


	}
}
