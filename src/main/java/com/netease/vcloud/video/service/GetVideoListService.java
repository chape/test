package com.netease.vcloud.video.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.video.param.GetVideoListParam;

/**
* <p>Title: GetVideoListService</p>
* <p>Description: 获取视频列表接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface GetVideoListService {

	/**
	 * 
	 * <p>Title: getVideoList</p>
	 * <p>Description: 获取视频列表</p>	
	 * @param currentPage    获取视频列表分页后的索引
	 * @param pageSize       获取视频列表一页的记录数（若为-1，表示不用分页）
	 * @param status         根据视频状态过滤选择（0表示获取所有状态视频）
	 * @param type           根据视频分类过滤选择（0表示获取所有分类视频）
	 * @return getVideoListParam  获取视频列表返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract GetVideoListParam getVideoList(Integer currentPage,
			Integer pageSize, Integer status, Integer type) throws IOException,
			VcloudException;

}