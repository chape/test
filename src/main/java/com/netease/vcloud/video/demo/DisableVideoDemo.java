package com.netease.vcloud.video.demo;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.video.param.DisableVideoParam;



/**
* <p>Title: DisableVideoDemo</p>
* <p>Description: 视频屏蔽的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class DisableVideoDemo {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(DisableVideoDemo.class);

	public static void main(String[] args) {
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
	     String appSecret = "a7224d72e2e440329f680004da882fe61";  	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);

		/* 视频ID 参数必填*/
		Long vid = new Long(38852);
		
		try{	 
			/* 视频屏蔽返回结果的封装类 */
			DisableVideoParam disableVideoParam = vclient.disableVideo(vid);

			if(disableVideoParam.getCode() == 200){
				logger.info("[DisableVideoDemo] disable video successfully. ");
			}else{
				logger.info("[DisableVideoDemo] fail to disable video. " + "return code : " + disableVideoParam.getCode() + " return message: " + disableVideoParam.getMsg());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}


	}
}
