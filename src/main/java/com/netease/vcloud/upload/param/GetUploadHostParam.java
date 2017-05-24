package com.netease.vcloud.upload.param;

import java.util.List;


/**
* <p>Title: GetUploadHostParam</p>
* <p>Description: 获取上传加速节点地址输出参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-27
*/
public class GetUploadHostParam {
	
	/** 输出参数中的lbs*/
	String lbs;
	
	/** 输出参数中的上传节点地址集合*/
	List<String> upload;
	
	/**
	 * 
	* <p>Title: getLbs</p>
	* <p>Description: 得到获取上传加速节点地址输出参数的lbs</p>
	* @return lbs
	 */ 
	public String getLbs() {
		return lbs;
	}
	/**
	 * 
	* <p>Title: setLbs</p>
	* <p>Description: 设置获取上传加速节点地址输出参数的lbs</p>
	* @param lbs
	 */
	public void setLbs(String lbs) {
		this.lbs = lbs;
	}
	/**
	 * 
	* <p>Title: getUpload</p>
	* <p>Description: 得到获取上传加速节点地址输出参数的上传节点地址集合</p>
	* @return 上传节点地址集合
	 */
	public List<String> getUpload() {
		return upload;
	}
	
	/**
	 * 
	* <p>Title: setUpload</p>
	* <p>Description: 设置获取上传加速节点地址输出参数的上传节点地址集合</p>
	* @param upload 上传节点地址集合
	 */
	public void setUpload(List<String> upload) {
		this.upload = upload;
	}
	@Override
	public String toString() {
		return "GetUploadHostParam [lbs=" + lbs + ", upload=" + upload + "]";
	}
	
	
}
