package com.netease.vcloud.transcode.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.transcode.module.SetVideoCallBackModule;
import com.netease.vcloud.transcode.param.SetVideoCallBackParam;
import com.netease.vcloud.transcode.service.SetVideoCallBackService;
import com.netease.vcloud.transcode.util.TranscodeUtil;

/**
* <p>Title: SetVideoCallBackServiceImpl</p>
* <p>Description: 设置回调地址接口的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class SetVideoCallBackServiceImpl implements SetVideoCallBackService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(SetVideoCallBackServiceImpl.class);

	/* 
	* <p>Title: setVideoCallBack</p>
	* <p>Description: </p>
	* @param callbackUrl
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.SetVideoCallBackService#setVideoCallBack(java.lang.String)
	*/
	public SetVideoCallBackParam setVideoCallBack(String callbackUrl) throws IOException, VcloudException{
		if(null == callbackUrl || "".equals(callbackUrl.trim()))
			throw new VcloudException("callbackUrl is null or invalid");
		SetVideoCallBackModule setVideoCallBackModule = new SetVideoCallBackModule(callbackUrl);
		TranscodeUtil util = new TranscodeUtil(setVideoCallBackModule);		
		SetVideoCallBackParam setVideoCallBackParam = util.setVideoCallBack();
		return setVideoCallBackParam;

	}
}
