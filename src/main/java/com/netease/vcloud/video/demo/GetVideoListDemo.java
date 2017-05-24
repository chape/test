package com.netease.vcloud.video.demo;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.video.param.GetVideoListParam;


/**
* <p>Title: GetVideoListDemo</p>
* <p>Description: 获取视频列表的Demo</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class GetVideoListDemo {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(GetVideoListDemo.class);
	
	public static void main(String[] args) {
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "f4b51648c54e4e92a744653885cdd29c1";		
	     String appSecret = "a7224d72e2e440329f680004da882fe61";  	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);
	     
	     /*获取视频列表分页后的索引   参数必填*/
	     Integer currentPage = new Integer(8);
	     
	     /*获取视频列表一页的记录数（若为-1，表示不用分页）  参数必填*/
	     Integer pageSize = new Integer(10);
	     
	     /*根据视频状态过滤选择（0表示获取所有状态视频）  参数必填*/
	     Integer status = new Integer(0); 
	     
	     /*根据视频分类过滤选择（0表示获取所有分类视频）   参数必填*/
	     Integer type = new Integer(0);     
	    
	     try{	   
	     /* 获取视频列表返回结果的封装类 */
	     GetVideoListParam getVideoListParam = vclient.getVideoList(currentPage, pageSize, status, type);
	     
	     if(getVideoListParam.getCode() == 200){
	    	 logger.info("[GetVideoListDemo] get video list successfully. " + getVideoListParam.getRet().getList().toString());	    	
	     }else{
	    	 logger.info("[GetVideoListDemo] fail to get video list. " + "return code : " + getVideoListParam.getCode() + " return message: " + getVideoListParam.getMsg());
	     }
	     }catch (Exception e) {
				e.printStackTrace();
			}

	}
}
