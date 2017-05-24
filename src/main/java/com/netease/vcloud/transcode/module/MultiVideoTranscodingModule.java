package com.netease.vcloud.transcode.module;


import java.util.List;

/**
* <p>Title: MultiVideoTranscodingModule</p>
* <p>Description: 多视频转码输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class MultiVideoTranscodingModule {

	/** 需要转码的多个视频ID组成的列表    参数必填*/
	List<Long> vids;
	
	/** 转码模板ID    参数必填*/
	Long presetId;
	
	/** 视频水印ID    参数非必填*/
	Long watermarkId;	

	public MultiVideoTranscodingModule() {		
	}
	public MultiVideoTranscodingModule(List<Long> vids, Long presetId,
			Long watermarkId) {	
		this.vids = vids;
		this.presetId = presetId;
		this.watermarkId = watermarkId;
	}
	public List<Long> getVids() {
		return vids;
	}
	public void setVids(List<Long> vids) {
		this.vids = vids;
	}
	public Long getPresetId() {
		return presetId;
	}
	public void setPresetId(Long presetId) {
		this.presetId = presetId;
	}
	public Long getWatermarkId() {
		return watermarkId;
	}
	public void setWatermarkId(Long watermarkId) {
		this.watermarkId = watermarkId;
	}	
	
}
