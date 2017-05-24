package com.netease.vcloud.video.demo;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.video.param.EditVideoParam;



/**
* <p>Title: EditVideoDemo</p>
* <p>Description: 视频编辑的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class EditVideoDemo {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(EditVideoDemo.class);

	public static void main(String[] args) {
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
	     String appSecret = "a7224d72e2e440329f680004da882fe61";  	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);

		/* 查询视频ID 参数必填*/
		Long vid = new Long(38852);

		/* 视频的名称   参数必填*/
		String videoName = new String("aa2");

		/* 视频分类ID 参数必填*/
		Long typeId = new Long(1056);

		/* 视频的描述信息  参数非必填*/
		//String description = "a";	   		

		try{	
			EditVideoParam editVideoParam = vclient.editVideo(vid, videoName, typeId);
			if(editVideoParam.getCode() == 200){
				logger.info("[EditVideoDemo] edit video successfully. ");
			}else{
				logger.info("[EditVideoDemo] fail to edit video. " + "return code : " + editVideoParam.getCode() + " return message: " + editVideoParam.getMsg());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
