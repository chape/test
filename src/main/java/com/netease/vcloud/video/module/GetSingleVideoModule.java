package com.netease.vcloud.video.module;

/**
* <p>Title: GetSingleVideoModule</p>
* <p>Description: 获取视频信息输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class GetSingleVideoModule {

	/** 视频ID 参数必填*/
	private  Long vid ;	
	
	public GetSingleVideoModule() {	
	}

	public GetSingleVideoModule(Long vid) {		
		this.vid = vid;
	}

	public Long getVid() {
		return vid;
	}

	public void setVid(Long vid) {
		this.vid = vid;
	}  
	
	
}
