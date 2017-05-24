package com.netease.vcloud.transcode.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingParam;


/**
* <p>Title: MultiVideoTranscodingDemo</p>
* <p>Description:  多视频转码的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class MultiVideoTranscodingDemo {

	/** 日志实例*/	
	public static final Logger logger = Logger.getLogger(MultiVideoTranscodingDemo.class);

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
		
		/* 转码模板ID    参数必填*/
		Long presetId = new Long(28573);
		
		
		/* 视频水印ID    参数非必填*/
		Long watermarkId = null;
		
		
		try{	
		/* 多视频转码返回结果的封装类 */
		MultiVideoTranscodingParam multiVideoTranscodingParam = vclient.multiVideoTranscoding(vids, presetId, watermarkId);
		
		if(multiVideoTranscodingParam.getCode() == 200){
			logger.info("[MultiVideoTranscodingDemo] transcode video successfully. " + multiVideoTranscodingParam.getRet().toString());
		}else{
			logger.info("[MultiVideoTranscodingDemo] fail to transcode video. " + "return code : " + multiVideoTranscodingParam.getCode() + " return message: " + multiVideoTranscodingParam.getMsg());
		}
		 }catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
}
