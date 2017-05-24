package com.netease.vcloud.video.module;

/**
* <p>Title: DisableVideoModule</p>
* <p>Description: 视频屏蔽输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class DisableVideoModule {

	/** 视频ID 参数必填*/
	private Long vid;
	
	public DisableVideoModule() {		
	}
	public DisableVideoModule(Long vid) {		
		this.vid = vid;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	
}
