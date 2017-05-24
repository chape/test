package com.netease.vcloud.video.module;

/**
* <p>Title: EditVideoModule</p>
* <p>Description: 视频编辑输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class EditVideoModule {

	/** 查询视频ID 参数必填*/
	private Long vid;

	/** 视频的名称   参数必填*/
	private String videoName;

	/** 视频分类ID 参数必填*/
	private Long typeId;

	/** 视频的描述信息  参数非必填*/
	private String description;	
	
	public EditVideoModule() {		
	}
	public EditVideoModule(Long vid, String videoName, Long typeId,
			String description) {	
		this.vid = vid;
		this.videoName = videoName;
		this.typeId = typeId;
		this.description = description;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	  
	
	
	
}
