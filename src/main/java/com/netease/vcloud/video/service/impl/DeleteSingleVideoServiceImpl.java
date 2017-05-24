package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.DeleteSingleVideoModule;
import com.netease.vcloud.video.param.DeleteSingleVideoParam;
import com.netease.vcloud.video.service.DeleteSingleVideoService;
import com.netease.vcloud.video.util.VideoUtil;

/**
* <p>Title: DeleteSingleVideoServiceImpl</p>
* <p>Description: 删除视频的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class DeleteSingleVideoServiceImpl implements DeleteSingleVideoService {
	
	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(DeleteSingleVideoServiceImpl.class);
	
	/* 
	* <p>Title: deleteSingleVideo</p>
	* <p>Description: </p>
	* @param vid
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.DeleteSingleVideoService#deleteSingleVideo(java.lang.Long)
	*/
	public DeleteSingleVideoParam deleteSingleVideo(Long vid) throws IOException, VcloudException{
		
		if(null == vid)
			throw new VcloudException("vid is null or invalid");	
		DeleteSingleVideoModule deleteSingleVideoModule = new DeleteSingleVideoModule(vid);
		VideoUtil util = new VideoUtil(deleteSingleVideoModule);
		DeleteSingleVideoParam deleteSingleVideoParam = util.deleteSingleVideo();
		return deleteSingleVideoParam;
	}

}
