package com.netease.vcloud.video.module;


/**
* <p>Title: RecoverVideoModule</p>
* <p>Description: 视频恢复输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class RecoverVideoModule {

	/** 视频ID 参数必填*/
	private Long vid;	
	
	public RecoverVideoModule() {		
	}
	public RecoverVideoModule(Long vid) {	
		this.vid = vid;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	
	
	
}
