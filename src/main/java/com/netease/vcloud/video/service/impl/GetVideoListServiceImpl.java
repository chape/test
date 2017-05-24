package com.netease.vcloud.video.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.module.GetVideoListModule;
import com.netease.vcloud.video.param.GetVideoListParam;
import com.netease.vcloud.video.service.GetVideoListService;
import com.netease.vcloud.video.util.VideoUtil;


/**
* <p>Title: GetVideoListServiceImpl</p>
* <p>Description: 获取视频列表的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class GetVideoListServiceImpl implements GetVideoListService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(GetVideoListServiceImpl.class);
	
	/* 
	* <p>Title: getVideoList</p>
	* <p>Description: </p>
	* @param currentPage
	* @param pageSize
	* @param status
	* @param type
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.GetVideoListService#getVideoList(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
	*/
	public GetVideoListParam getVideoList(Integer currentPage, Integer pageSize, Integer status, Integer type) throws IOException, VcloudException{

		if(null == currentPage)
			throw new VcloudException("currentPage is null or invalid");
		if(null == pageSize)
			throw new VcloudException("pageSize is null or invalid");
		if(null == status)
			throw new VcloudException("status is null or invalid");
		if(null == type)
			throw new VcloudException("type is null or invalid");

		GetVideoListModule getVideoListModule = new GetVideoListModule(currentPage, pageSize, status, type);
		VideoUtil util = new VideoUtil(getVideoListModule);		
		GetVideoListParam getVideoListParam = util.getVideoList();
		return getVideoListParam;


	}
}
