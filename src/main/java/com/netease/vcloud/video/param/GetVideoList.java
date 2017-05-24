package com.netease.vcloud.video.param;


/**
* <p>Title: GetVideoList</p>
* <p>Description: 获取视频列表输出参数中的ret部分的list的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-27
*/
public class GetVideoList {

	/** 视频Id */
	private Long vid;
	
	/** 视频的名称 */
	private String videoName;
	
	/** 视频的状态*/
	private Integer status;
	
	/** 视频的描述信息 */
	private String description;
	
	/** 转码完成时间 */
	private Long completeTime;
	
	/** 视频播放时长 */
	private Long duration;
	
	/** 视频所属分类ID */
	private Long typeId;
	
	/** 视频所属分类名称 */
	private String typeName;
	
	/** 视频封面截图URL地址 */
	private String snapshotUrl;
	
	/** 原始视频的播放地址 */
	private String origUrl;
	
	/** 原始视频的下载地址 */
	private String downloadOrigUrl;
	
	/** 原始视频文件大小 */
	private Long initialSize;
	
	/** 标清Mp4视频格式文件播放地址 */
	private String sdMp4Url;
	
	/** 标清Mp4视频格式文件下载地址 */
	private String downloadSdMp4Url;
	
	/** 标清Mp4视频格式文件的大小 */
	private Long sdMp4Size;
	
	/** 高清Mp4视频格式文件播放地址 */
	private String hdMp4Url;
	
	/** 高清Mp4视频格式文件下载地址 */
	private String downloadHdMp4Url;
	
	/** 高清Mp4视频格式文件的大小 */
	private Long hdMp4Size;
	
	/** 超清Mp4视频格式文件播放地址 */
	private String shdMp4Url;

	/** 超清Mp4视频格式文件下载地址 */
	private String downloadShdMp4Url;
	
	/** 超清Mp4视频格式文件的大小 */
	private Long shdMp4Size;
	
	/** 标清Flv视频格式文件播放地址 */
	private String sdFlvUrl;
	
	/** 标清Flv视频格式文件下载地址 */
	private String downloadSdFlvUrl;
	
	/** 标清Flv视频格式文件的大小 */
	private Long sdFlvSize;
	
	/** 高清Flv视频格式文件播放地址 */
	private String hdFlvUrl;
	
	/** 高清Flv视频格式文件下载地址*/
	private String downloadHdFlvUrl;
	
	/** 高清Flv视频格式文件的大小*/
	private Long hdFlvSize;
	
	/** 超清Flv视频格式文件播放地址*/
	private String shdFlvUrl;
	
	/** 超清Flv视频格式文件下载地址*/
	private String downloadShdFlvUrl;
	
	/** 超清Flv视频格式文件的大小*/
	private Long shdFlvSize;	

	/** 标清Hls视频格式文件播放地址*/
	private String sdHlsUrl;
	
	/** 标清Hls视频格式文件下载地址*/
	private String downloadSdHlsUrl;
	
	/** 标清Hls视频格式文件的大小*/
	private Long sdHlsSize;
	
	/** 高清Hls视频格式文件播放地址*/
	private String hdHlsUrl;

	/** 高清Hls视频格式文件下载地址*/
	private String downloadHdHlsUrl;

	/** 高清Hls视频格式文件的大小*/
	private Long hdHlsSize;

	/** 超清Hls视频格式文件播放地址*/
	private String shdHlsUrl;

	/** 超清Hls视频格式文件下载地址*/
	private String downloadShdHlsUrl;

	/** 超清Hls视频格式文件的大小*/
	private Long shdHlsSize;	
	
	/** 视频上传时间*/
	private Long createTime;
	
	/** 视频更新时间*/
	private Long updateTime;
	
	

	/**
	 * 
	* <p>Title: getVid</p>
	* <p>Description: 得到视频Id</p>
	* @return 视频Id
	 */
	public Long getVid() {
		return vid;
	}

	/**
	 * 
	* <p>Title: setVid</p>
	* <p>Description: 设置视频Id</p>
	* @param vid 视频Id
	 */
	public void setVid(Long vid) {
		this.vid = vid;
	}

	/**
	 * 
	* <p>Title: getVideoName</p>
	* <p>Description: 得到视频的名称</p>
	* @return 视频的名称
	 */
	public String getVideoName() {
		return videoName;
	}

	/**
	 * 
	* <p>Title: setVideoName</p>
	* <p>Description: 设置视频的名称</p>
	* @param videoName 视频的名称
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	/**
	 * 
	* <p>Title: getStatus</p>
	* <p>Description: 得到视频的状态</p>
	* @return 视频的状态
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 
	* <p>Title: setStatus</p>
	* <p>Description: 设置视频的状态</p>
	* @param status 视频的状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 
	* <p>Title: getDescription</p>
	* <p>Description: 得到视频的描述信息</p>
	* @return 视频的描述信息
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	* <p>Title: setDescription</p>
	* <p>Description: 设置视频的描述信息</p>
	* @param description 视频的描述信息
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	* <p>Title: getCompleteTime</p>
	* <p>Description: 得到转码完成时间</p>
	* @return 转码完成时间
	 */
	public Long getCompleteTime() {
		return completeTime;
	}

	/**
	 * 
	* <p>Title: setCompleteTime</p>
	* <p>Description: 设置转码完成时间</p>
	* @param completeTime 转码完成时间
	 */
	public void setCompleteTime(Long completeTime) {
		this.completeTime = completeTime;
	}

	/**
	 * 
	* <p>Title: getDuration</p>
	* <p>Description: 得到视频播放时长</p>
	* @return 视频播放时长
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * 
	* <p>Title: setDuration</p>
	* <p>Description: 设置视频播放时长</p>
	* @param duration 视频播放时长
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	/**
	 * 
	* <p>Title: getTypeId</p>
	* <p>Description: 得到视频所属分类ID</p>
	* @return 视频所属分类ID
	 */
	public Long getTypeId() {
		return typeId;
	}

	/**
	 * 
	* <p>Title: setTypeId</p>
	* <p>Description: 设置视频所属分类ID</p>
	* @param typeId 视频所属分类ID
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	/**
	 * 
	* <p>Title: getTypeName</p>
	* <p>Description: 得到视频所属分类名称</p>
	* @return 视频所属分类名称
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 
	* <p>Title: setTypeName</p>
	* <p>Description: 设置视频所属分类名称</p>
	* @param typeName 视频所属分类名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 
	* <p>Title: getSnapshotUrl</p>
	* <p>Description: 得到视频封面截图URL地址</p>
	* @return 视频封面截图URL地址
	 */
	public String getSnapshotUrl() {
		return snapshotUrl;
	}

	/**
	 * 
	* <p>Title: setSnapshotUrl</p>
	* <p>Description: 设置视频封面截图URL地址</p>
	* @param snapshotUrl 视频封面截图URL地址
	 */
	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	/**
	 * 
	* <p>Title: getOrigUrl</p>
	* <p>Description: 得到原始视频的播放地址</p>
	* @return 原始视频的播放地址
	 */
	public String getOrigUrl() {
		return origUrl;
	}

	/**
	 * 
	* <p>Title: setOrigUrl</p>
	* <p>Description: 设置原始视频的播放地址</p>
	* @param origUrl 原始视频的播放地址
	 */
	public void setOrigUrl(String origUrl) {
		this.origUrl = origUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadOrigUrl</p>
	* <p>Description: 得到原始视频的下载地址</p>
	* @return 原始视频的下载地址
	 */
	public String getDownloadOrigUrl() {
		return downloadOrigUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadOrigUrl</p>
	* <p>Description: 设置原始视频的下载地址</p>
	* @param downloadOrigUrl 原始视频的下载地址
	 */
	public void setDownloadOrigUrl(String downloadOrigUrl) {
		this.downloadOrigUrl = downloadOrigUrl;
	}

	/**
	 * 
	* <p>Title: getInitialSize</p>
	* <p>Description: 得到原始视频文件大小</p>
	* @return 原始视频文件大小
	 */
	public Long getInitialSize() {
		return initialSize;
	}

	/**
	 * 
	* <p>Title: setInitialSize</p>
	* <p>Description: 设置原始视频文件大小</p>
	* @param initialSize 原始视频文件大小
	 */
	public void setInitialSize(Long initialSize) {
		this.initialSize = initialSize;
	}

	/**
	 * 
	* <p>Title: getSdMp4Url</p>
	* <p>Description: 得到标清Mp4视频格式文件播放地址</p>
	* @return 标清Mp4视频格式文件播放地址
	 */
	public String getSdMp4Url() {
		return sdMp4Url;
	}

	/**
	 * 
	* <p>Title: setSdMp4Url</p>
	* <p>Description: 设置标清Mp4视频格式文件播放地址</p>
	* @param sdMp4Url 标清Mp4视频格式文件播放地址
	 */
	public void setSdMp4Url(String sdMp4Url) {
		this.sdMp4Url = sdMp4Url;
	}

	/**
	 * 
	* <p>Title: getDownloadSdMp4Url</p>
	* <p>Description: 得到标清Mp4视频格式文件下载地址</p>
	* @return 标清Mp4视频格式文件下载地址
	 */
	public String getDownloadSdMp4Url() {
		return downloadSdMp4Url;
	}

	/**
	 * 
	* <p>Title: setDownloadSdMp4Url</p>
	* <p>Description: 设置标清Mp4视频格式文件下载地址</p>
	* @param downloadSdMp4Url 标清Mp4视频格式文件下载地址
	 */
	public void setDownloadSdMp4Url(String downloadSdMp4Url) {
		this.downloadSdMp4Url = downloadSdMp4Url;
	}

	/**
	 * 
	* <p>Title: getSdMp4Size</p>
	* <p>Description: 标清Mp4视频格式文件的大小</p>
	* @return 标清Mp4视频格式文件的大小
	 */
	public Long getSdMp4Size() {
		return sdMp4Size;
	}

	/**
	 * 
	* <p>Title: setSdMp4Size</p>
	* <p>Description: 设置标清Mp4视频格式文件的大小</p>
	* @param sdMp4Size 标清Mp4视频格式文件的大小
	 */
	public void setSdMp4Size(Long sdMp4Size) {
		this.sdMp4Size = sdMp4Size;
	}

	/**
	 * 
	* <p>Title: getHdMp4Url</p>
	* <p>Description: 得到高清Mp4视频格式文件播放地址</p>
	* @return 高清Mp4视频格式文件播放地址
	 */
	public String getHdMp4Url() {
		return hdMp4Url;
	}

	/**
	 * 
	* <p>Title: setHdMp4Url</p>
	* <p>Description: 设置高清Mp4视频格式文件播放地址</p>
	* @param hdMp4Url 高清Mp4视频格式文件播放地址
	 */
	public void setHdMp4Url(String hdMp4Url) {
		this.hdMp4Url = hdMp4Url;
	}

	/**
	 * 
	* <p>Title: getDownloadHdMp4Url</p>
	* <p>Description: 得到高清Mp4视频格式文件下载地址</p>
	* @return 高清Mp4视频格式文件下载地址
	 */
	public String getDownloadHdMp4Url() {
		return downloadHdMp4Url;
	}

	/**
	 * 
	* <p>Title: setDownloadHdMp4Url</p>
	* <p>Description: 设置高清Mp4视频格式文件下载地址</p>
	* @param downloadHdMp4Url 高清Mp4视频格式文件下载地址
	 */
	public void setDownloadHdMp4Url(String downloadHdMp4Url) {
		this.downloadHdMp4Url = downloadHdMp4Url;
	}

	/**
	 * 
	* <p>Title: getHdMp4Size</p>
	* <p>Description: 得到高清Mp4视频格式文件的大小</p>
	* @return 高清Mp4视频格式文件的大小
	 */
	public Long getHdMp4Size() {
		return hdMp4Size;
	}

	/**
	 * 
	* <p>Title: setHdMp4Size</p>
	* <p>Description: 设置高清Mp4视频格式文件的大小</p>
	* @param hdMp4Size 高清Mp4视频格式文件的大小
	 */
	public void setHdMp4Size(Long hdMp4Size) {
		this.hdMp4Size = hdMp4Size;
	}

	/**
	 * 
	* <p>Title: getShdMp4Url</p>
	* <p>Description: 得到超清Mp4视频格式文件播放地址</p>
	* @return 超清Mp4视频格式文件播放地址
	 */
	public String getShdMp4Url() {
		return shdMp4Url;
	}

	/**
	 * 
	* <p>Title: setShdMp4Url</p>
	* <p>Description: 设置超清Mp4视频格式文件播放地址</p>
	* @param shdMp4Url 超清Mp4视频格式文件播放地址
	 */
	public void setShdMp4Url(String shdMp4Url) {
		this.shdMp4Url = shdMp4Url;
	}

	/**
	 * 
	* <p>Title: getDownloadShdMp4Url</p>
	* <p>Description: 得到超清Mp4视频格式文件下载地址</p>
	* @return 超清Mp4视频格式文件下载地址
	 */
	public String getDownloadShdMp4Url() {
		return downloadShdMp4Url;
	}

	/**
	 * 
	* <p>Title: setDownloadShdMp4Url</p>
	* <p>Description: 设置超清Mp4视频格式文件下载地址</p>
	* @param downloadShdMp4Url 超清Mp4视频格式文件下载地址
	 */
	public void setDownloadShdMp4Url(String downloadShdMp4Url) {
		this.downloadShdMp4Url = downloadShdMp4Url;
	}

	/**
	 * 
	* <p>Title: getShdMp4Size</p>
	* <p>Description: 得到超清Mp4视频格式文件的大小</p>
	* @return 超清Mp4视频格式文件的大小
	 */
	public Long getShdMp4Size() {
		return shdMp4Size;
	}

	/**
	 * 
	* <p>Title: setShdMp4Size</p>
	* <p>Description: 设置超清Mp4视频格式文件的大小</p>
	* @param shdMp4Size 超清Mp4视频格式文件的大小
	 */
	public void setShdMp4Size(Long shdMp4Size) {
		this.shdMp4Size = shdMp4Size;
	}

	/**
	 * 
	* <p>Title: getSdFlvUrl</p>
	* <p>Description: 得到标清Flv视频格式文件播放地址</p>
	* @return 标清Flv视频格式文件播放地址
	 */
	public String getSdFlvUrl() {
		return sdFlvUrl;
	}

	/**
	 * 
	* <p>Title: setSdFlvUrl</p>
	* <p>Description: 设置标清Flv视频格式文件播放地址</p>
	* @param sdFlvUrl 标清Flv视频格式文件播放地址
	 */
	public void setSdFlvUrl(String sdFlvUrl) {
		this.sdFlvUrl = sdFlvUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadSdFlvUrl</p>
	* <p>Description: 得到标清Flv视频格式文件下载地址</p>
	* @return 标清Flv视频格式文件下载地址
	 */
	public String getDownloadSdFlvUrl() {
		return downloadSdFlvUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadSdFlvUrl</p>
	* <p>Description: 设置标清Flv视频格式文件下载地址</p>
	* @param downloadSdFlvUrl 标清Flv视频格式文件下载地址
	 */
	public void setDownloadSdFlvUrl(String downloadSdFlvUrl) {
		this.downloadSdFlvUrl = downloadSdFlvUrl;
	}

	/**
	 * 
	* <p>Title: getSdFlvSize</p>
	* <p>Description: 得到标清Flv视频格式文件的大小</p>
	* @return 标清Flv视频格式文件的大小
	 */
	public Long getSdFlvSize() {
		return sdFlvSize;
	}

	/**
	 * 
	* <p>Title: setSdFlvSize</p>
	* <p>Description: 设置标清Flv视频格式文件的大小</p>
	* @param sdFlvSize 标清Flv视频格式文件的大小
	 */
	public void setSdFlvSize(Long sdFlvSize) {
		this.sdFlvSize = sdFlvSize;
	}

	/**
	 * 
	* <p>Title: getHdFlvUrl</p>
	* <p>Description: 得到高清Flv视频格式文件播放地址</p>
	* @return 高清Flv视频格式文件播放地址
	 */
	public String getHdFlvUrl() {
		return hdFlvUrl;
	}

	/**
	 * 
	* <p>Title: setHdFlvUrl</p>
	* <p>Description: 设置高清Flv视频格式文件播放地址</p>
	* @param hdFlvUrl 高清Flv视频格式文件播放地址
	 */
	public void setHdFlvUrl(String hdFlvUrl) {
		this.hdFlvUrl = hdFlvUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadHdFlvUrl</p>
	* <p>Description: 得到高清Flv视频格式文件下载地址</p>
	* @return 高清Flv视频格式文件下载地址
	 */
	public String getDownloadHdFlvUrl() {
		return downloadHdFlvUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadHdFlvUrl</p>
	* <p>Description: 设置高清Flv视频格式文件下载地址</p>
	* @param downloadHdFlvUrl 高清Flv视频格式文件下载地址
	 */
	public void setDownloadHdFlvUrl(String downloadHdFlvUrl) {
		this.downloadHdFlvUrl = downloadHdFlvUrl;
	}

	/**
	 * 
	* <p>Title: getHdFlvSize</p>
	* <p>Description: 得到高清Flv视频格式文件的大小</p>
	* @return 高清Flv视频格式文件的大小
	 */
	public Long getHdFlvSize() {
		return hdFlvSize;
	}

	/**
	 * 
	* <p>Title: setHdFlvSize</p>
	* <p>Description: 设置高清Flv视频格式文件的大小</p>
	* @param hdFlvSize 高清Flv视频格式文件的大小
	 */ 
	public void setHdFlvSize(Long hdFlvSize) {
		this.hdFlvSize = hdFlvSize;
	}

	/**
	 * 
	* <p>Title: getShdFlvUrl</p>
	* <p>Description: 得到超清Flv视频格式文件播放地址</p>
	* @return 超清Flv视频格式文件播放地址
	 */
	public String getShdFlvUrl() {
		return shdFlvUrl;
	}

	/**
	 * 
	* <p>Title: setShdFlvUrl</p>
	* <p>Description: 设置超清Flv视频格式文件播放地址</p>
	* @param shdFlvUrl 超清Flv视频格式文件播放地址
	 */
	public void setShdFlvUrl(String shdFlvUrl) {
		this.shdFlvUrl = shdFlvUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadShdFlvUrl</p>
	* <p>Description: 得到超清Flv视频格式文件下载地址</p>
	* @return 超清Flv视频格式文件下载地址
	 */
	public String getDownloadShdFlvUrl() {
		return downloadShdFlvUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadShdFlvUrl</p>
	* <p>Description: 设置超清Flv视频格式文件下载地址</p>
	* @param downloadShdFlvUrl 超清Flv视频格式文件下载地址
	 */
	public void setDownloadShdFlvUrl(String downloadShdFlvUrl) {
		this.downloadShdFlvUrl = downloadShdFlvUrl;
	}

	/**
	 * 
	* <p>Title: getShdFlvSize</p>
	* <p>Description: 得到超清Flv视频格式文件的大小</p>
	* @return 超清Flv视频格式文件的大小
	 */
	public Long getShdFlvSize() {
		return shdFlvSize;
	}

	/**
	 * 
	* <p>Title: setShdFlvSize</p>
	* <p>Description: 设置超清Flv视频格式文件的大小</p>
	* @param shdFlvSize 超清Flv视频格式文件的大小
	 */
	public void setShdFlvSize(Long shdFlvSize) {
		this.shdFlvSize = shdFlvSize;
	}

	/**
	 * 
	* <p>Title: getCreateTime</p>
	* <p>Description: 得到视频上传时间</p>
	* @return 视频上传时间
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * 
	* <p>Title: setCreateTime</p>
	* <p>Description: 设置视频上传时间</p>
	* @param createTime 视频上传时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 
	* <p>Title: getUpdateTime</p>
	* <p>Description: 得到视频更新时间</p>
	* @return 视频更新时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * 
	* <p>Title: setUpdateTime</p>
	* <p>Description: 设置视频更新时间</p>
	* @param updateTime 视频更新时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 
	* <p>Title: getSdHlsUrl</p>
	* <p>Description: 得到标清Hls视频格式文件播放地址</p>
	* @return 标清Hls视频格式文件播放地址
	 */
	public String getSdHlsUrl() {
		return sdHlsUrl;
	}

	/**
	 * 
	* <p>Title: setSdHlsUrl</p>
	* <p>Description: 设置标清Hls视频格式文件播放地址</p>
	* @param sdHlsUrl 标清Hls视频格式文件播放地址
	 */
	public void setSdHlsUrl(String sdHlsUrl) {
		this.sdHlsUrl = sdHlsUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadSdHlsUrl</p>
	* <p>Description: 得到标清Hls视频格式文件下载地址</p>
	* @return 标清Hls视频格式文件下载地址
	 */
	public String getDownloadSdHlsUrl() {
		return downloadSdHlsUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadSdHlsUrl</p>
	* <p>Description: 设置标清Hls视频格式文件下载地址</p>
	* @param downloadSdHlsUrl 标清Hls视频格式文件下载地址
	 */
	public void setDownloadSdHlsUrl(String downloadSdHlsUrl) {
		this.downloadSdHlsUrl = downloadSdHlsUrl;
	}

	/**
	 * 
	* <p>Title: getSdHlsSize</p>
	* <p>Description: 得到标清Hls视频格式文件的大小</p>
	* @return 标清Hls视频格式文件的大小
	 */
	public Long getSdHlsSize() {
		return sdHlsSize;
	}

	/**
	 * 
	* <p>Title: setSdHlsSize</p>
	* <p>Description: 设置标清Hls视频格式文件的大小</p>
	* @param sdHlsSize 标清Hls视频格式文件的大小
	 */
	public void setSdHlsSize(Long sdHlsSize) {
		this.sdHlsSize = sdHlsSize;
	}

	/**
	 * 
	* <p>Title: getHdHlsUrl</p>
	* <p>Description: 得到高清Hls视频格式文件播放地址</p>
	* @return 高清Hls视频格式文件播放地址
	 */
	public String getHdHlsUrl() {
		return hdHlsUrl;
	}

	/**
	 * 
	* <p>Title: setHdHlsUrl</p>
	* <p>Description: 设置高清Hls视频格式文件播放地址</p>
	* @param hdHlsUrl 高清Hls视频格式文件播放地址
	 */
	public void setHdHlsUrl(String hdHlsUrl) {
		this.hdHlsUrl = hdHlsUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadHdHlsUrl</p>
	* <p>Description: 得到高清Hls视频格式文件下载地址</p>
	* @return 高清Hls视频格式文件下载地址
	 */
	public String getDownloadHdHlsUrl() {
		return downloadHdHlsUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadHdHlsUrl</p>
	* <p>Description: 设置高清Hls视频格式文件下载地址</p>
	* @param downloadHdHlsUrl 高清Hls视频格式文件下载地址
	 */
	public void setDownloadHdHlsUrl(String downloadHdHlsUrl) {
		this.downloadHdHlsUrl = downloadHdHlsUrl;
	}

	/**
	 * 
	* <p>Title: getHdHlsSize</p>
	* <p>Description: 得到高清Hls视频格式文件的大小</p>
	* @return 高清Hls视频格式文件的大小
	 */
	public Long getHdHlsSize() {
		return hdHlsSize;
	}

	/**
	 * 
	* <p>Title: setHdHlsSize</p>
	* <p>Description: 设置高清Hls视频格式文件的大小</p>
	* @param hdHlsSize 高清Hls视频格式文件的大小
	 */
	public void setHdHlsSize(Long hdHlsSize) {
		this.hdHlsSize = hdHlsSize;
	}

	/**
	 * 
	* <p>Title: getShdHlsUrl</p>
	* <p>Description: 得到超清Hls视频格式文件播放地址</p>
	* @return 清Hls视频格式文件播放地址
	 */
	public String getShdHlsUrl() {
		return shdHlsUrl;
	}

	/**
	 * 
	* <p>Title: setShdHlsUrl</p>
	* <p>Description: 设置超清Hls视频格式文件播放地址</p>
	* @param shdHlsUrl 超清Hls视频格式文件播放地址
	 */
	public void setShdHlsUrl(String shdHlsUrl) {
		this.shdHlsUrl = shdHlsUrl;
	}

	/**
	 * 
	* <p>Title: getDownloadShdHlsUrl</p>
	* <p>Description: 得到超清Hls视频格式文件下载地址</p>
	* @return 超清Hls视频格式文件下载地址
	 */
	public String getDownloadShdHlsUrl() {
		return downloadShdHlsUrl;
	}

	/**
	 * 
	* <p>Title: setDownloadShdHlsUrl</p>
	* <p>Description: 设置超清Hls视频格式文件下载地址</p>
	* @param downloadShdHlsUrl 超清Hls视频格式文件下载地址
	 */
	public void setDownloadShdHlsUrl(String downloadShdHlsUrl) {
		this.downloadShdHlsUrl = downloadShdHlsUrl;
	}

	/**
	 * 
	* <p>Title: getShdHlsSize</p>
	* <p>Description: 得到超清Hls视频格式文件的大小</p>
	* @return 超清Hls视频格式文件的大小
	 */
	public Long getShdHlsSize() {
		return shdHlsSize;
	}

	/**
	 * 
	* <p>Title: setShdHlsSize</p>
	* <p>Description: 设置超清Hls视频格式文件的大小</p>
	* @param shdHlsSize 超清Hls视频格式文件的大小
	 */
	public void setShdHlsSize(Long shdHlsSize) {
		this.shdHlsSize = shdHlsSize;
	}

	@Override
	public String toString() {
		return "GetVideoList [vid=" + vid + ", videoName=" + videoName
				+ ", status=" + status + ", description=" + description
				+ ", completeTime=" + completeTime + ", duration=" + duration
				+ ", typeId=" + typeId + ", typeName=" + typeName
				+ ", snapshotUrl=" + snapshotUrl + ", origUrl=" + origUrl
				+ ", downloadOrigUrl=" + downloadOrigUrl + ", initialSize="
				+ initialSize + ", sdMp4Url=" + sdMp4Url
				+ ", downloadSdMp4Url=" + downloadSdMp4Url + ", sdMp4Size="
				+ sdMp4Size + ", hdMp4Url=" + hdMp4Url + ", downloadHdMp4Url="
				+ downloadHdMp4Url + ", hdMp4Size=" + hdMp4Size
				+ ", shdMp4Url=" + shdMp4Url + ", downloadShdMp4Url="
				+ downloadShdMp4Url + ", shdMp4Size=" + shdMp4Size
				+ ", sdFlvUrl=" + sdFlvUrl + ", downloadSdFlvUrl="
				+ downloadSdFlvUrl + ", sdFlvSize=" + sdFlvSize + ", hdFlvUrl="
				+ hdFlvUrl + ", downloadHdFlvUrl=" + downloadHdFlvUrl
				+ ", hdFlvSize=" + hdFlvSize + ", shdFlvUrl=" + shdFlvUrl
				+ ", downloadShdFlvUrl=" + downloadShdFlvUrl + ", shdFlvSize="
				+ shdFlvSize + ", sdHlsUrl=" + sdHlsUrl + ", downloadSdHlsUrl="
				+ downloadSdHlsUrl + ", sdHlsSize=" + sdHlsSize + ", hdHlsUrl="
				+ hdHlsUrl + ", downloadHdHlsUrl=" + downloadHdHlsUrl
				+ ", hdHlsSize=" + hdHlsSize + ", shdHlsUrl=" + shdHlsUrl
				+ ", downloadShdHlsUrl=" + downloadShdHlsUrl + ", shdHlsSize="
				+ shdHlsSize + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

	

	
}
