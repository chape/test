package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.DeleteSingleTranscodeVideoModule;
import com.netease.vcloud.video.param.DeleteSingleTranscodeVideoParam;
import com.netease.vcloud.video.service.DeleteSingleTranscodeVideoService;
import com.netease.vcloud.video.util.VideoUtil;


/**
* <p>Title: DeleteSingleTranscodeVideoServiceImpl</p>
* <p>Description: 删除单个转码输出视频的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class DeleteSingleTranscodeVideoServiceImpl implements DeleteSingleTranscodeVideoService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(DeleteSingleTranscodeVideoServiceImpl.class);

	/* 
	* <p>Title: deleteSingleTransCodeVideo</p>
	* <p>Description: </p>
	* @param vid
	* @param style
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.DeleteSingleTranscodeVideoService#deleteSingleTransCodeVideo(java.lang.Long, java.lang.Integer)
	*/
	public DeleteSingleTranscodeVideoParam deleteSingleTransCodeVideo(Long vid, Integer style) throws IOException, VcloudException{
		if(null == vid)
			throw new VcloudException("vid is null or invalid");
		if(null == style)
			throw new VcloudException("style is null or invalid");
		DeleteSingleTranscodeVideoModule deleteSingleTranscodeVideoModule = new DeleteSingleTranscodeVideoModule(vid, style);
		VideoUtil util = new VideoUtil(deleteSingleTranscodeVideoModule);		
		DeleteSingleTranscodeVideoParam deleteSingleTranscodeVideoParam = util.deleteSingleTransCodeVideo();
		return deleteSingleTranscodeVideoParam;

	}
}
