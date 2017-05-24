package com.netease.vcloud.upload.module;

import java.util.Map;

/**
* <p>Title: InitUploadVideoModule</p>
* <p>Description: 视频上传初始化输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class InitUploadVideoModule {

	/** 上传文件的原始名称（包含后缀名） 此参数必填*/
	String originFileName; 

	/** 用户命名的上传文件名称  此参数非必填*/
	String userFileName;

	/** 视频所属的类别ID（不填写为默认分类）此参数非必填*/
	Long typeId;

	/** 频所需转码模板ID（不填写为默认模板） 此参数非必填*/
	Long presetId; 

	/** 转码成功后回调客户端的URL地址（需标准http格式）  此参数非必填*/
	String callbackUrl; 

	/** 上传视频的描述信息  此参数非必填*/
	String description;

	/** 上传视频的视频水印Id 此参数非必填*/
	Long watermarkId;

	
	public InitUploadVideoModule() {		
	}
	public InitUploadVideoModule(Map<String, Object> initParamMap) {	
		this.originFileName = (String) initParamMap.get("originFileName");
		this.userFileName = (String) initParamMap.get("userFileName");
		this.typeId = (Long) initParamMap.get("typeId");
		this.presetId = (Long) initParamMap.get("presetId");
		this.callbackUrl = (String) initParamMap.get("callbackUrl");
		this.description = (String) initParamMap.get("description");
		this.watermarkId = (Long) initParamMap.get("watermarkId");
	}
	public InitUploadVideoModule(String originFileName, String userFileName,
			Long typeId, Long presetId, String callbackUrl, String description,
			Long watermarkId) {	
		this.originFileName = originFileName;
		this.userFileName = userFileName;
		this.typeId = typeId;
		this.presetId = presetId;
		this.callbackUrl = callbackUrl;
		this.description = description;
		this.watermarkId = watermarkId;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getUserFileName() {
		return userFileName;
	}
	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getPresetId() {
		return presetId;
	}
	public void setPresetId(Long presetId) {
		this.presetId = presetId;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getWatermarkId() {
		return watermarkId;
	}
	public void setWatermarkId(Long watermarkId) {
		this.watermarkId = watermarkId;
	}
	
	
	
}
