package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.GetSingleVideoModule;
import com.netease.vcloud.video.param.GetSingleVideoParam;
import com.netease.vcloud.video.service.GetSingleVideoService;
import com.netease.vcloud.video.util.VideoUtil;

/**
* <p>Title: GetSingleVideoServiceImpl</p>
* <p>Description: 获取单个视频的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class GetSingleVideoServiceImpl implements GetSingleVideoService {
	
	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(GetSingleVideoServiceImpl.class);
	/* 
	* <p>Title: getSingleVideo</p>
	* <p>Description: </p>
	* @param vid
	* @return
	* @throws VcloudException
	* @throws IOException
	* @see com.netease.vcloud.video.util.service.impl.GetSingleVideoService#getSingleVideo(java.lang.Long)
	*/
	public GetSingleVideoParam getSingleVideo(Long vid) throws VcloudException, IOException{
		
		if(null == vid)
			throw new VcloudException("vid is null or invalid");
		
		GetSingleVideoModule getSingleVideoModule = new GetSingleVideoModule(vid);		
		VideoUtil util = new VideoUtil(getSingleVideoModule);
		GetSingleVideoParam getSingleVideoParam = util.getSingleVideo();
		return getSingleVideoParam;

	}


}
