package com.netease.vcloud.transcode.service;

import java.io.IOException;
import java.util.List;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingParam;


/**
* <p>Title: MultiVideoTranscodingService</p>
* <p>Description: 多视频转码接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface MultiVideoTranscodingService {

	/**
	 * 
	 * <p>Title: multiVideoTranscoding</p>
	 * <p>Description: 多视频转码</p>
	 * @param vids      需要转码的多个视频ID组成的列表
	 * @param presetId  转码模板ID
	 * @return multiVideoTranscodingParam 多视频转码返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract MultiVideoTranscodingParam multiVideoTranscoding(
			List<Long> vids, Long presetId, Long watermarkId) throws IOException, VcloudException;

}