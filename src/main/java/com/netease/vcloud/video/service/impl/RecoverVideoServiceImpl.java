package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.RecoverVideoModule;
import com.netease.vcloud.video.param.RecoverVideoParam;
import com.netease.vcloud.video.service.RecoverVideoService;
import com.netease.vcloud.video.util.VideoUtil;


/**
* <p>Title: RecoverVideoServiceImpl</p>
* <p>Description: 视频恢复的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class RecoverVideoServiceImpl implements RecoverVideoService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(RecoverVideoServiceImpl.class);
	/* 
	* <p>Title: recoverVideo</p>
	* <p>Description: </p>
	* @param vid
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.RecoverVideoService#recoverVideo(java.lang.Long)
	*/
	public RecoverVideoParam recoverVideo(Long vid) throws IOException, VcloudException{
		
		if(null == vid)
			throw new VcloudException("vid is null or invalid");
		RecoverVideoModule recoverVideoModule = new RecoverVideoModule(vid);
		VideoUtil util = new VideoUtil(recoverVideoModule);
		RecoverVideoParam recoverVideoParam = util.recoverVideo();
		return recoverVideoParam;

	}
}
