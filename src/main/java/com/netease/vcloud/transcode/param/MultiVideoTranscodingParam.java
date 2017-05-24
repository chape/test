package com.netease.vcloud.transcode.param;


/**
* <p>Title: MultiVideoTranscodingParam</p>
* <p>Description: 多视频转码输出参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-27
*/
public class MultiVideoTranscodingParam {
	
	/** 输出参数中的响应码*/
	private Integer code;
	
	/** 输出参数中的错误信息*/
	private String msg;
	
	/** 输出参数中的ret部分*/
	private MultiVideoTranscodingRet ret;

	/**
	 * 
	* <p>Title: getCode</p>
	* <p>Description: 得到多视频转码输出参数的响应码</p>
	* @return 响应码
	 */
	public Integer getCode() {
		return code;
	}


	/**
	 * 
	* <p>Title: setCode</p>
	* <p>Description: 设置多视频转码输出参数的响应码</p>
	* @param code 响应码
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * 
	* <p>Title: getMsg</p>
	* <p>Description: 得到多视频转码输出参数的错误信息</p>
	* @return 错误信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 
	* <p>Title: setMsg</p>
	* <p>Description: 设置多视频转码输出参数的错误信息</p>
	* @param msg 错误信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 
	* <p>Title: getRet</p>
	* <p>Description: 得到多视频转码输出参数的ret部分</p>
	* @return ret部分
	 */
	public MultiVideoTranscodingRet getRet() {
		return ret;
	}

	/**
	 * 
	* <p>Title: setRet</p>
	* <p>Description: 设置多视频转码输出参数的ret部分</p>
	* @param ret
	 */
	public void setRet(MultiVideoTranscodingRet ret) {
		this.ret = ret;
	}
	
	

}
