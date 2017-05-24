package com.netease.vcloud.transcode.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.transcode.module.MultiVideoTranscodingModule;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingParam;
import com.netease.vcloud.transcode.service.MultiVideoTranscodingService;
import com.netease.vcloud.transcode.util.TranscodeUtil;


/**
* <p>Title: MultiVideoTranscodingServiceImpl</p>
* <p>Description: 多视频转码的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class MultiVideoTranscodingServiceImpl implements MultiVideoTranscodingService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(MultiVideoTranscodingServiceImpl.class);
	
	/* 
	* <p>Title: multiVideoTranscoding</p>
	* <p>Description: </p>
	* @param vids
	* @param presetId
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.MultiVideoTranscodingService#multiVideoTranscoding(java.util.List, java.lang.Long)
	*/
	public MultiVideoTranscodingParam multiVideoTranscoding(List<Long> vids, Long presetId, Long watermarkId) throws IOException, VcloudException{
		if(null == vids)
			throw new VcloudException("vids is null or invalid");
		if(null == presetId)
			throw new VcloudException("presetId is null or invalid");
		
		MultiVideoTranscodingModule multiVideoTranscodingModule = new MultiVideoTranscodingModule(vids, presetId, watermarkId); 		
		TranscodeUtil util = new TranscodeUtil(multiVideoTranscodingModule);		
		MultiVideoTranscodingParam multiVideoTranscodingParam = util.multiVideoTranscoding();
		return multiVideoTranscodingParam;

	}
}
