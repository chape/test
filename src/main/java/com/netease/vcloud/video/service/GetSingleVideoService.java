package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.GetSingleVideoParam;


/**
* <p>Title: GetSingleVideoService</p>
* <p>Description:  获取单个视频接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface GetSingleVideoService {

	/**
	 * 
	 * <p>Title: getSingleVideo</p>
	 * <p>Description: 获取单个视频</p>
	 * @param vid  视频ID
	 * @return getSingleVideoParam  获取单个视频返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract GetSingleVideoParam getSingleVideo(Long vid)
			throws VcloudException, IOException;

}