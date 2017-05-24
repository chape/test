package com.netease.vcloud.transcode.service;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.transcode.param.SetVideoCallBackParam;


/**
* <p>Title: SetVideoCallBackService</p>
* <p>Description: 设置回调地址接口接口</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-30
*/
public interface SetVideoCallBackService {

	/**
	 * 
	 * <p>Title: setVideoCallBack</p>
	 * <p>Description: 设置回调地址接口</p>
	 * @param callbackUrl  转码成功后回调客户端的URL地址
	 * @return setVideoCallBackParam  设置回调地址接口返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public abstract SetVideoCallBackParam setVideoCallBack(String callbackUrl)
			throws IOException, VcloudException;

}