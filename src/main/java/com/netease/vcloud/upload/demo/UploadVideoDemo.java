package com.netease.vcloud.upload.demo;


import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;
import com.netease.vcloud.util.FileUtil;



/**
* <p>Title: UploadVideoDemo</p>
* <p>Description: 简单的视频上传的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-22
*/
public class UploadVideoDemo {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(UploadVideoDemo.class);	

	
	public static void main(String[] args) {
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
	     String appSecret = "a7224d72e2e440329f680004da882fe61";  	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);

		
		try {
			/*请输入上传文件路径*/
			//String filePath = "e:\\3.mp4";
			String filePath = "e:\\1.jpg";

			Map<String, Object> initParamMap = new HashMap<String, Object>();
			/*输入上传文件的相关信息 */
			/* 上传文件的原始名称（包含后缀名） 此参数必填*/
			initParamMap.put("originFileName", FileUtil.getFileName(filePath));
			//initParamMap.put("originFileName", "love.mp4");

			/* 用户命名的上传文件名称  此参数非必填*/
			initParamMap.put("userFileName", "for_love.mp4");

			/* 视频所属的类别ID（不填写为默认分类）此参数非必填*/
			initParamMap.put("typeId", new Long(1056));

			/* 频所需转码模板ID（不填写为默认模板） 此参数非必填*/
			//initParamMap.put("presetId", new Long(30599));

			/* 转码成功后回调客户端的URL地址（需标准http格式）  此参数非必填*/
			initParamMap.put("callbackUrl", null);

			/* 上传视频的描述信息  此参数非必填*/
			initParamMap.put("description", "love.mp4");
			
			/* 上传视频的视频水印Id 此参数非必填*/
			//initParamMap.put("watermarkId", new Long(1));

		

			QueryVideoIDorWatermarkIDParam queryVideoIDParam = vclient.uploadVideo(filePath, initParamMap);  

			logger.info("[UploadDemo] upload video successfully.  " + queryVideoIDParam.getRet().toString());
			
			
		} catch (Exception e) {		
			e.printStackTrace();
		}

	}
}
