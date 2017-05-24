package com.netease.vcloud.video.module;

/**
* <p>Title: GetVideoListModule</p>
* <p>Description: 获取视频信息列表输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class GetVideoListModule {

	/**获取视频列表分页后的索引   参数必填*/
	private   Integer currentPage;

	/**获取视频列表一页的记录数（若为-1，表示不用分页）  参数必填*/
	private   Integer pageSize;

	/**根据视频状态过滤选择（0表示获取所有状态视频）  参数必填*/
	private  Integer status; 

	/**根据视频分类过滤选择（0表示获取所有分类视频）   参数必填*/
	private  Integer type;	
	
	public GetVideoListModule() {		
	}
	public GetVideoListModule(Integer currentPage, Integer pageSize,
			Integer status, Integer type) {		
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.status = status;
		this.type = type;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}     
	
	
	
	
}
