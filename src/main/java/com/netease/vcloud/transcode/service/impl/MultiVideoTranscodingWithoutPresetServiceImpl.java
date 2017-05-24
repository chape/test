package com.netease.vcloud.transcode.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.transcode.module.MultiVideoTranscodingWithoutPresetModule;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingWithoutPresetParam;
import com.netease.vcloud.transcode.service.MultiVideoTranscodingWithoutPresetService;
import com.netease.vcloud.transcode.util.TranscodeUtil;


/**
* <p>Title: MultiVideoTranscodingWithoutPresetServiceImpl</p>
* <p>Description: 多视频无模板转码的实现类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class MultiVideoTranscodingWithoutPresetServiceImpl implements MultiVideoTranscodingWithoutPresetService {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(MultiVideoTranscodingWithoutPresetServiceImpl.class);

	/* 
	* <p>Title: multiVideoTranscodingWithoutPreset</p>
	* <p>Description: </p>
	* @param vids
	* @param videoFormatMap
	* @return
	* @throws IOException
	* @throws VcloudException
	* @see com.netease.vcloud.video.util.service.impl.MultiVideoTranscodingWithoutPresetService#multiVideoTranscodingWithoutPreset(java.util.List, java.util.Map)
	*/
	public MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPreset(List<Long> vids, Map<String, Integer> videoFormatMap) throws IOException, VcloudException{
		if(null == vids)
			throw new VcloudException("vids is null or invalid");
		if(! checkVideoFormat(videoFormatMap))
			throw new VcloudException("some of the init video format param is null or invalid");
		
		MultiVideoTranscodingWithoutPresetModule multiVideoTranscodingWithoutPresetModule = new MultiVideoTranscodingWithoutPresetModule(vids, videoFormatMap);		
		TranscodeUtil util = new TranscodeUtil(multiVideoTranscodingWithoutPresetModule);		
		MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPresetParam = util.multiVideoTranscodingWithoutPreset();
		return multiVideoTranscodingWithoutPresetParam;

	}
	
	/**
	 * 
	* <p>Title: checkVideoFormat</p>
	* <p>Description: 判断九种必填的视频转码格式是否有缺失</p>
	* @param videoFormatMap 视频转码格式集合 
	* @return 如果九种视频转码格式都存在，则返回true，否则返回false
	 */
	private boolean checkVideoFormat(Map<String, Integer> videoFormatMap){
		if(videoFormatMap.size() < 9)
			return false;
		
		ArrayList<String> targetVideoFormat = new ArrayList<String>();
		targetVideoFormat.add("sdMp4");
		targetVideoFormat.add("hdMp4");
		targetVideoFormat.add("shdMp4");
		targetVideoFormat.add("sdFlv");
		targetVideoFormat.add("hdFlv");
		targetVideoFormat.add("shdFlv");
		targetVideoFormat.add("sdHls");
		targetVideoFormat.add("hdHls");
		targetVideoFormat.add("shdHls");
		
		for(int i = 0; i < targetVideoFormat.size(); i++){
			Integer number = videoFormatMap.get(targetVideoFormat.get(i));
			if(null == number)
				return false;
		}		
		
		return true;
	}
}
