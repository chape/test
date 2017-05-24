package com.netease.vcloud.transcode.module;


/**
* <p>Title: SetVideoCallBackModule</p>
* <p>Description: 设置回调地址接口输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class SetVideoCallBackModule {

	/** 转码成功后回调客户端的URL地址    参数必填*/
	String callbackUrl;	

	public SetVideoCallBackModule() {		
	}

	public SetVideoCallBackModule(String callbackUrl) {		
		this.callbackUrl = callbackUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	
	
}
