package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.DeleteSingleTranscodeVideoParam;

/**
* <p>Title: DeleteSingleTranscodeVideoService</p>
* <p>Description: 删除单个转码输出视频接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface DeleteSingleTranscodeVideoService {

	/**
	 * 
	 * <p>Title: deleteSingleTransCodeVideo</p>
	 * <p>Description: 删除单个转码输出视频</p>
	 * @param vid      视频ID
	 * @param style    视频转码格式
	 * @return deleteSingleTranscodeVideoParam 删除单个转码输出视频返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract DeleteSingleTranscodeVideoParam deleteSingleTransCodeVideo(
			Long vid, Integer style) throws IOException, VcloudException;

}