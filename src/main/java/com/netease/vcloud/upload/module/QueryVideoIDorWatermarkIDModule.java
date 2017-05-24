package com.netease.vcloud.upload.module;


import java.util.List;

/**
* <p>Title: QueryVideoIDorWatermarkIDModule</p>
* <p>Description: 根据对象名查询视频或水印图片主ID输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class QueryVideoIDorWatermarkIDModule {

	/** 请输入 查询文件的对象名     参数必填*/
	private List<String> objectNames;	

	public QueryVideoIDorWatermarkIDModule() {		
	}
	public QueryVideoIDorWatermarkIDModule(List<String> objectNamesList) {	
		this.objectNames = objectNamesList;
	}
	public List<String> getObjectNames() {
		return objectNames;
	}
	public void setObjectNames(List<String> objectNames) {
		this.objectNames = objectNames;
	}
	
	
	
}
