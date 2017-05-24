package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.RecoverVideoParam;

/**
* <p>Title: RecoverVideoService</p>
* <p>Description: 视频恢复接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface RecoverVideoService {

	/**
	 * <p>Title: recoverVideo</p>
	 * <p>Description: 视频恢复</p>
	 * @param vid      视频ID
	 * @return recoverVideoParam 视频恢复返回结果的封装
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract RecoverVideoParam recoverVideo(Long vid)
			throws IOException, VcloudException;

}