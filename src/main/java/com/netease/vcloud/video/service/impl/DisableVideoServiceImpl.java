package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.DisableVideoModule;
import com.netease.vcloud.video.param.DisableVideoParam;
import com.netease.vcloud.video.service.DisableVideoService;
import com.netease.vcloud.video.util.VideoUtil;


/**
* <p>Title: DisableVideoServiceImpl</p>
* <p>Description: 视频屏蔽的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class DisableVideoServiceImpl implements DisableVideoService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(DisableVideoServiceImpl.class);
	
	/* 
	* <p>Title: disableVideo</p>
	* <p>Description: </p>
	* @param vid
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.DisableVideoService#disableVideo(java.lang.Long)
	*/
	public DisableVideoParam disableVideo(Long vid) throws IOException, VcloudException{
		
		if(null == vid)
			throw new VcloudException("vid is null or invalid");

		DisableVideoModule disableVideoModule = new DisableVideoModule(vid);
		VideoUtil util = new VideoUtil(disableVideoModule);
		DisableVideoParam disableVideoParam = util.disableVideo();
		return disableVideoParam;

	}
}
