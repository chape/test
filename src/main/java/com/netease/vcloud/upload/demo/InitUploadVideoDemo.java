package com.netease.vcloud.upload.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.InitUploadVideoParam;



/**
* <p>Title: InitUploadVideoDemo</p>
* <p>Description: 视频上传初始化的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class InitUploadVideoDemo {
	
	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(InitUploadVideoDemo.class);
	
	public static void main(String[] args) {
		
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
	     String appSecret = "a7224d72e2e440329f680004da882fe61";  	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);
	   
	     
	     Map<String, Object> initParamMap = new HashMap<String, Object>();

	     /*输入上传文件的相关信息 */
	     /* 上传文件的原始名称（包含后缀名） 此参数必填*/
	     initParamMap.put("originFileName", "love.mp4");

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
	     
	     try{

	    	 /*视频上传初始化返回结果的封装类*/
	    	 InitUploadVideoParam initUploadVideoParam = vclient.initUploadVideo(initParamMap);
	    	 //InitUploadVideoParam initUploadVideoParam = vclient.initUploadVideo("love.mp4", "for_love.mp4", new Long(1056), null, null, null, null);
	    	 if(initUploadVideoParam.getCode() == 200){
	    		 logger.info("[InitUploadVideoDemo] init upload params successfully. " + initUploadVideoParam.getRet().toString());
	    	 }else{
	    		 logger.info("[InitUploadVideoDemo] fail to init upload params. " + "return code " + initUploadVideoParam.getCode() + " return message " + initUploadVideoParam.getMsg());
	    	 }

	     }catch (Exception e) {
	    	 e.printStackTrace();
	     }    
	     
		
	}

}
