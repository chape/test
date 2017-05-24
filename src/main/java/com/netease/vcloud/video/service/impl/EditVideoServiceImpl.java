package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.EditVideoModule;
import com.netease.vcloud.video.param.EditVideoParam;
import com.netease.vcloud.video.service.EditVideoService;
import com.netease.vcloud.video.util.VideoUtil;


/**
* <p>Title: EditVideoServiceImpl</p>
* <p>Description: 视频编辑的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class EditVideoServiceImpl implements EditVideoService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(EditVideoServiceImpl.class);
	
	/* 
	* <p>Title: editVideo</p>
	* <p>Description: </p>
	* @param vid
	* @param videoName
	* @param typeId
	* @param description
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.EditVideoService#editVideo(java.lang.Long, java.lang.String, java.lang.Long, java.lang.String)
	*/
	public EditVideoParam editVideo(Long vid, String videoName, Long typeId, String description) throws IOException, VcloudException{
		
		if(null == vid)
			throw new VcloudException("vid is null or invalid");
		if(null == videoName || "".equals(videoName.trim()))
			throw new VcloudException("videoName is null or invalid");
		if(null == typeId)
			throw new VcloudException("typeId is null or invalid");
		
		EditVideoModule editVideoModule = new EditVideoModule(vid, videoName, typeId, description);		
		VideoUtil util = new VideoUtil(editVideoModule);
		EditVideoParam editVideoParam = util.editVideo();
		return editVideoParam;

	}	
	
}
