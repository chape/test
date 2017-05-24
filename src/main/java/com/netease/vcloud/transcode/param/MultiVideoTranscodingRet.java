package com.netease.vcloud.transcode.param;


/**
* <p>Title: MultiVideoTranscodingRet</p>
* <p>Description:  多视频转码输出参数的ret部分的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-27
*/
public class MultiVideoTranscodingRet {

	/** 输出参数中的转码成功的数量*/
	private Integer successCount;
	
	/** 输出参数中的转码失败的数量*/
	private Integer failCount;
	
	/** 输出参数中的跳过转码的数量*/
	private Integer passCount;

	/**
	 * 
	* <p>Title: getSuccessCount</p>
	* <p>Description: 得到多视频转码输出参数的ret部分的转码成功的数量</p>
	* @return 转码成功的数量
	 */
	public Integer getSuccessCount() {
		return successCount;
	}

	/**
	 * 
	* <p>Title: setSuccessCount</p>
	* <p>Description:  设置多视频转码输出参数的ret部分的转码成功的数量</p>
	* @param successCount  转码成功的数量
	 */
	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	/**
	 * 
	* <p>Title: getFailCount</p>
	* <p>Description: 得到多视频转码输出参数的ret部分的转码失败的数量</p>
	* @return 转码失败的数量
	 */
	public Integer getFailCount() {
		return failCount;
	}

	/**
	 * 
	* <p>Title: setFailCount</p>
	* <p>Description: 设置多视频转码输出参数的ret部分的转码失败的数量</p>
	* @param failCount 转码失败的数量
	 */
	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	/**
	 * 
	* <p>Title: getPassCount</p>
	* <p>Description: 得到多视频转码输出参数的ret部分的跳过转码的数量</p>
	* @return 跳过转码的数量
	 */
	public Integer getPassCount() {
		return passCount;
	}

	/**
	 * 
	* <p>Title: setPassCount</p>
	* <p>Description: 设置多视频转码输出参数的ret部分的跳过转码的数量</p>
	* @param passCount 跳过转码的数量
	 */
	public void setPassCount(Integer passCount) {
		this.passCount = passCount;
	}

	@Override
	public String toString() {
		return "MultiVideoTranscodingRet [successCount=" + successCount
				+ ", failCount=" + failCount + ", passCount=" + passCount + "]";
	}
	
	
	
}
