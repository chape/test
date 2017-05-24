package com.netease.vcloud.transcode.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingWithoutPresetParam;


/**
* <p>Title: MultiVideoTranscodingWithoutPresetService</p>
* <p>Description: 多视频无模板转码接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface MultiVideoTranscodingWithoutPresetService {

	/**
	 * 
	 * <p>Title: multiVideoTranscodingWithoutPreset</p>
	 * <p>Description: 多视频无模板转码</p>
	 * @param vids              需要转码的多个视频ID组成的列表
	 * @param videoFormatMap    转码格式集合
	 * @return multiVideoTranscodingWithoutPresetParam   多视频无模板转码返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPreset(
			List<Long> vids, Map<String, Integer> videoFormatMap)
			throws IOException, VcloudException;

}