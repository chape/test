package com.netease.vcloud.transcode.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingWithoutPresetParam;



/**
* <p>Title: MultiVideoTranscodingWithoutPresetDemo</p>
* <p>Description: 多视频无模板转码的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class MultiVideoTranscodingWithoutPresetDemo {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(MultiVideoTranscodingWithoutPresetDemo.class);
	
	public static void main(String[] args) {
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
	     String appSecret = "a7224d72e2e440329f680004da882fe61";  	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);
		
		/* 需要转码的多个视频ID组成的列表    参数必填*/
		List<Long> vids = new ArrayList<Long>();
		
		vids.add(new Long(40381));
		vids.add(new Long(42210)); 
		
		/* 转码格式    参数必填*/
		Map<String, Integer> videoFormatMap = new HashMap<String, Integer>();
		videoFormatMap.put("sdMp4", 1);
		videoFormatMap.put("hdMp4", 1);
		videoFormatMap.put("shdMp4", 1);
		videoFormatMap.put("sdFlv", 1);
		videoFormatMap.put("hdFlv", 1);
		videoFormatMap.put("shdFlv", 1);
		videoFormatMap.put("sdHls", 1);
		videoFormatMap.put("hdHls", 1);
		videoFormatMap.put("shdHls", 1);
		
		
		try{	 
			/* 多视频无模板转码返回结果的封装类 */
			MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPresetParam = vclient.multiVideoTranscodingWithoutPreset(vids, videoFormatMap);

			if(multiVideoTranscodingWithoutPresetParam.getCode() == 200){
				logger.info("[MultiVideoTranscodingWithoutPresetDemo] transcode video successfully. " + multiVideoTranscodingWithoutPresetParam.getRet().toString());
			}else{
				logger.info("[MultiVideoTranscodingWithoutPresetDemo] fail to transcode video. " + multiVideoTranscodingWithoutPresetParam.getCode() + " return message: " + multiVideoTranscodingWithoutPresetParam.getMsg());
			} }catch (Exception e) {
				e.printStackTrace();
			}		
	}
}
