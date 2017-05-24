package com.netease.vcloud.video.module;


/**
* <p>Title: DeleteSingleTranscodeVideoModule</p>
* <p>Description: 删除单个转码输出视频输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class DeleteSingleTranscodeVideoModule {

	/** 查询视频ID 参数必填*/
	private Long vid;

	/** 视频转码格式    参数必填*/
	private Integer style;	
	
	public DeleteSingleTranscodeVideoModule() {	
	}
	public DeleteSingleTranscodeVideoModule(Long vid, Integer style) {	
		this.vid = vid;
		this.style = style;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public Integer getStyle() {
		return style;
	}
	public void setStyle(Integer style) {
		this.style = style;
	} 	
	
	
}
