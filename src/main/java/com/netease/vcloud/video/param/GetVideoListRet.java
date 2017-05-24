package com.netease.vcloud.video.param;

import java.util.List;

/**
* <p>Title: GetVideoListRet</p>
* <p>Description:  获取视频列表输出参数中的ret部分的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-27
*/
public class GetVideoListRet {

	/**  获取视频列表输出参数中的ret部分的list */
	private List<GetVideoList> list;

	/** 输出参数中的当前取得页数*/
	private Integer currentPage;
	
	/** 输出参数中的一页的记录数目*/
	private Integer pageSize;
	
	/** 输出参数中的总页数*/
	private Integer pageNum;
	
	/** 输出参数中的获取视频列表的分类数目*/
	private Integer totalRecords;
	
	/**
	 * 
	* <p>Title: getList</p>
	* <p>Description: 得到获取视频列表输出参数中的ret部分的list</p>
	* @return ret部分的list
	 */
	public List<GetVideoList> getList() {
		return list;
	}

	/**
	 * 
	* <p>Title: setList</p>
	* <p>Description: 设置获取视频列表输出参数中的ret部分的list</p>
	* @param list ret部分的list
	 */
	public void setList(List<GetVideoList> list) {
		this.list = list;
	}
	
	/**
	 * 
	* <p>Title: getCurrentPage</p>
	* <p>Description: 得到获取视频列表输出参数的当前取得页数</p>
	* @return 当前取得页数
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * 
	* <p>Title: setCurrentPage</p>
	* <p>Description: 设置获取视频列表输出参数的当前取得页数</p>
	* @param currentPage 当前取得页数
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 
	* <p>Title: getPageSize</p>
	* <p>Description: 得到获取视频列表输出参数的一页的记录数目</p>
	* @return 一页的记录数目
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 
	* <p>Title: setPageSize</p>
	* <p>Description: 设置得到获取视频列表输出参数的一页的记录数目</p>
	* @param pageSize 一页的记录数目
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	* <p>Title: getPageNum</p>
	* <p>Description: 得到获取视频列表输出参数的总页数</p>
	* @return 总页数
	 */
	public Integer getPageNum() {
		return pageNum;
	}

	/**
	 * 
	* <p>Title: setPageNum</p>
	* <p>Description: 设置获取视频列表输出参数的总页数</p>
	* @param pageNum  总页数
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * 
	* <p>Title: getTotalRecords</p>
	* <p>Description: 得到获取视频列表输出参数的获取视频列表的分类数目</p>
	* @return 获取视频列表的分类数目
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}

	/**
	 * 
	* <p>Title: setTotalRecords</p>
	* <p>Description: 设置获取视频列表输出参数的获取视频列表的分类数目</p>
	* @param totalRecords 获取视频列表的分类数目
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	
}
