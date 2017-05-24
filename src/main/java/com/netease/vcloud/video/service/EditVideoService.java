package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.EditVideoParam;


/**
* <p>Title: EditVideoService</p>
* <p>Description: 视频编辑接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface EditVideoService {

	/**
	 * 
	 * <p>Title: editVideo</p>
	 * <p>Description: 视频编辑</p>
	 * @param vid             视频ID
	 * @param videoName       视频的名称
	 * @param typeId          视频分类ID
	 * @param description     视频的描述信息
	 * @return editVideoParam 视频编辑返回结果的封装类 
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract EditVideoParam editVideo(Long vid, String videoName,
			Long typeId, String description) throws IOException,
			VcloudException;

}