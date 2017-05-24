package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.DeleteSingleVideoParam;

/**
* <p>Title: DeleteSingleVideoService</p>
* <p>Description: 删除视频接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface DeleteSingleVideoService {

	/**
	 * 
	 * <p>Title: deleteSingleVideo</p>
	 * <p>Description: 删除视频</p>
	 * @param vid 视频ID
	 * @return deleteSingleVideoParam 删除视频返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract DeleteSingleVideoParam deleteSingleVideo(Long vid)
			throws IOException, VcloudException;

}