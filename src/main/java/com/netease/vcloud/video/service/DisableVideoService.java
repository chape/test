package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.DisableVideoParam;


/**
* <p>Title: DisableVideoService</p>
* <p>Description: 视频屏蔽接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface DisableVideoService {

	/**
	 * 
	 * <p>Title: disableVideo</p>
	 * <p>Description: 视频屏蔽</p>
	 * @param vid      视频ID
	 * @return disableVideoParam 视频屏蔽返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract DisableVideoParam disableVideo(Long vid)
			throws IOException, VcloudException;

}