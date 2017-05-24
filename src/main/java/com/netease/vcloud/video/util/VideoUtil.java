package com.netease.vcloud.video.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.netease.vcloud.VcloudException;
import com.netease.vcloud.config.Config;
import com.netease.vcloud.util.HttpClientBuilder;
import com.netease.vcloud.util.HttpPostBuilder;
import com.netease.vcloud.video.module.DeleteSingleTranscodeVideoModule;
import com.netease.vcloud.video.module.DeleteSingleVideoModule;
import com.netease.vcloud.video.module.DisableVideoModule;
import com.netease.vcloud.video.module.EditVideoModule;
import com.netease.vcloud.video.module.GetSingleVideoModule;
import com.netease.vcloud.video.module.GetVideoListModule;
import com.netease.vcloud.video.module.RecoverVideoModule;
import com.netease.vcloud.video.param.DeleteSingleTranscodeVideoParam;
import com.netease.vcloud.video.param.DeleteSingleVideoParam;
import com.netease.vcloud.video.param.DisableVideoParam;
import com.netease.vcloud.video.param.EditVideoParam;
import com.netease.vcloud.video.param.GetSingleVideoParam;
import com.netease.vcloud.video.param.GetVideoListParam;
import com.netease.vcloud.video.param.RecoverVideoParam;


/**
* <p>Title: VideoUtil</p>
* <p>Description: 视频相关操作的工具类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-6-21
*/
public class VideoUtil {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(VideoUtil.class);
			
	
	/**  获取视频信息输入参数的封装类 */
	private GetSingleVideoModule getSingleVideoModule;
	
	/** 获取视频信息列表输入参数的封装类*/
	private GetVideoListModule getVideoListModule;
	
	/** 视频编辑输入参数的封装类*/
	private EditVideoModule editVideoModule;
	
	/** 删除单个转码输出视频输入参数的封装类*/
	private DeleteSingleTranscodeVideoModule deleteSingleTranscodeVideoModule;
	
	/** 删除视频信息输入参数的封装类*/
	private DeleteSingleVideoModule deleteSingleVideoModule;
	
	/** 视频屏蔽输入参数的封装类 */
	private DisableVideoModule disableVideoModule;
	
	/** 视频恢复输入参数的封装类 */
	private RecoverVideoModule recoverVideoModule;
	
	/**
	 * 
	* <p>Description:  获取单个视频的构造函数</p>
	* @param getSingleVideoModule 获取视频信息输入参数的封装类
	 */
	public VideoUtil(GetSingleVideoModule getSingleVideoModule) {		
		this.getSingleVideoModule = getSingleVideoModule;
	}
		
	/**
	 * 
	* <p>Description:  获取视频列表的构造函数</p>
	* @param getVideoListModule
	 */
	public VideoUtil(GetVideoListModule getVideoListModule) {		
		this.getVideoListModule = getVideoListModule;
	}	
	
	/**
	 * 
	* <p>Description: 视频编辑的构造函数 </p>
	* @param editVideoModule 视频编辑输入参数的封装类
	 */
	public VideoUtil(EditVideoModule editVideoModule) {
		this.editVideoModule = editVideoModule;
	}	
	
	/**
	 * 
	* <p>Description: 删除单个转码输出视频  的构造函数</p>
	* @param deleteSingleTranscodeVideoModule 删除单个转码输出视频输入参数的封装类
	 */
	public VideoUtil(DeleteSingleTranscodeVideoModule deleteSingleTranscodeVideoModule) {		
		this.deleteSingleTranscodeVideoModule = deleteSingleTranscodeVideoModule;
	}
	
	
	/**
	 * 
	* <p>Description:  删除单个视频 的构造函数</p>
	* @param deleteSingleVideoModule  删除视频信息输入参数的封装类
	 */
	public VideoUtil(DeleteSingleVideoModule deleteSingleVideoModule) {		
		this.deleteSingleVideoModule = deleteSingleVideoModule;
	}
	
	
	/**
	 * 
	* <p>Description: 视频屏蔽的构造函数</p>
	* @param disableVideoModule  视频屏蔽输入参数的封装类
	 */
	public VideoUtil(DisableVideoModule disableVideoModule) {		
		this.disableVideoModule = disableVideoModule;
	}
	
	
	/**
	 * 
	* <p>Description: 视频恢复 的构造函数</p>
	* @param recoverVideoModule 视频恢复输入参数的封装类
	 */
	public VideoUtil(RecoverVideoModule recoverVideoModule) {		
		this.recoverVideoModule = recoverVideoModule;
	}
	
	
	/**
	* <p>Title: getSingleVideo</p>
	* <p>Description: 获取单个视频 </p>
	* @return  getSingleVideoParam   获取单个视频输出参数的封装类
	* @throws IOException
	 * @throws VcloudException 
	*/
	public GetSingleVideoParam getSingleVideo() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/get";
		String url = Config.getGetSingleVideoURL();
		/* 设置请求的参数 */
		//StringEntity params = new StringEntity("{\"vid\":"	+ vid + "}");	
		
		StringEntity params = new StringEntity(JSON.toJSONString(getSingleVideoModule));	

		GetSingleVideoParam getSingleVideoParam = (GetSingleVideoParam) jsonParamObjectBuilder(url, params, GetSingleVideoParam.class);

		return getSingleVideoParam;

	}

	
	/**
	* <p>Title: getVideoList</p>
	* <p>Description: 获取视频列表  </p>
	* @return getVideoListParam 获取视频列表输出参数的封装类
	* @throws IOException
	 * @throws VcloudException 
	*/
	public GetVideoListParam getVideoList() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/list";
		String url = Config.getGetVideoListURL();
		
		/* 设置请求的参数 */			
		//StringEntity params = new StringEntity("{\"currentPage\":" + currentPage + ",\"pageSize\":" + pageSize + ",\"status\":" + status + ",\"type\":" + type +"}");	
		StringEntity params = new StringEntity(JSON.toJSONString(getVideoListModule));	

		// 得到Json数据
		GetVideoListParam getVideoListParam = (GetVideoListParam) jsonParamObjectBuilder(url, params, GetVideoListParam.class);	
		
		return getVideoListParam;
	}
	
	
	/**
	 * <p>Title: editVideo</p>
	 * <p>Description: 视频编辑</p>
	 * @return editVideoParam  视频编辑输出参数的封装类
	 * @throws IOException
	 * @throws VcloudException 
	 */
	public EditVideoParam editVideo() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/edit";
		String url = Config.getEditVideoURL();
	
		/* 设置请求的参数 */
		StringEntity params = new StringEntity(JSON.toJSONString(editVideoModule));		
		
		// 得到Json数据
		EditVideoParam  editVideoParam = (EditVideoParam) jsonParamObjectBuilder(url, params, EditVideoParam.class);	
		
		return editVideoParam;
	}
	
		
	/**
	 * <p>Title: deleteSingleTransCodeVideo</p>
	 * <p>Description: 删除单个转码输出视频</p>
	 * @return deleteSingleTranscodeVideoParam 删除单个转码输出视频输出参数的封装类
	 * @throws IOException
	 * @throws VcloudException 
	 */
	public DeleteSingleTranscodeVideoParam deleteSingleTransCodeVideo() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/delete_single";
		String url = Config.getDeleteSingleTransCodeVideoURL();
		/* 设置请求的参数 */
		//StringEntity params = new StringEntity("{\"vid\":"	+ vid + ",\"style\":" + style  +"}");
		
		StringEntity params = new StringEntity(JSON.toJSONString(deleteSingleTranscodeVideoModule));
		// 得到Json数据
		DeleteSingleTranscodeVideoParam deleteSingleTranscodeVideoParam = (DeleteSingleTranscodeVideoParam) jsonParamObjectBuilder(url, params, DeleteSingleTranscodeVideoParam.class);			
		
		return deleteSingleTranscodeVideoParam;
	}
	
		
	/**
	 * <p>Title: deleteSingleVideo</p>
	 * <p>Description: 删除单个视频</p>
	 * @return deleteSingleVideoParam 删除单个视频输出参数的封装类
	 * @throws IOException
	 * @throws VcloudException 
	 */
	public DeleteSingleVideoParam deleteSingleVideo() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/videoDelete";
		String url = Config.getDeleteSingleVideoURL();
		/* 设置请求的参数 */
		//StringEntity params = new StringEntity("{\"vid\":" + vid +"}");  
		
		StringEntity params = new StringEntity(JSON.toJSONString(deleteSingleVideoModule)); 
		// 得到Json数据
		DeleteSingleVideoParam deleteSingleVideoParam = (DeleteSingleVideoParam) jsonParamObjectBuilder(url, params, DeleteSingleVideoParam.class);			
		
		return deleteSingleVideoParam;
	}
	
	/**
	* <p>Title: disableVideo</p>
	* <p>Description: 视频屏蔽</p>
	* @return disableVideoParam 视频屏蔽输出参数的封装类
	* @throws IOException
	 * @throws VcloudException 
	*/
	public DisableVideoParam disableVideo() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/videoDisable";
		String url = Config.getDisableVideoURL();
		/* 设置请求的参数 */
		//StringEntity params = new StringEntity("{\"vid\":" + vid +"}");  
		
		StringEntity params = new StringEntity(JSON.toJSONString(disableVideoModule)); 
		// 得到Json数据
		DisableVideoParam disableVideoParam = (DisableVideoParam) jsonParamObjectBuilder(url, params, DisableVideoParam.class);			
		
		return disableVideoParam;
	}
		
	
	/**
	* <p>Title: recoverVideo</p>
	* <p>Description: 视频恢复 </p>
	* @return recoverVideoParam  视频恢复输出参数的封装类
	* @throws IOException
	 * @throws VcloudException 
	*/
	public RecoverVideoParam recoverVideo() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/video/videoRecover";
		String url = Config.getRecoverVideoURL();
		/* 设置请求的参数 */
		//StringEntity params = new StringEntity("{\"vid\":" + vid +"}");  
		
		StringEntity params = new StringEntity(JSON.toJSONString(recoverVideoModule)); 
		// 得到Json数据
		RecoverVideoParam recoverVideoParam = (RecoverVideoParam) jsonParamObjectBuilder(url, params, RecoverVideoParam.class);			
		
		return recoverVideoParam;
	}
	
	/**
	 * <p>Title: jsonParamObjectBuilder</p>
	 * <p>Description: 执行HttpPost请求 得到 json数据对应的参数封装类工具</p>
	 * @param url            接口地址
	 * @param params         请求的参数 
	 * @param clazz          对应待返回的参数封装类的class
	 * @return object        对应待返回的参数封装类
	 * @throws IOException
	 * @throws VcloudException 
	 */
	private <T> T jsonParamObjectBuilder(String url, StringEntity params, Class <T> clazz) throws IOException, VcloudException{

		HttpClient httpClient = HttpClientBuilder.getHttpClient();
		HttpPost httpPost = HttpPostBuilder.getHttpPost(url);	
		
		// 设置请求的参数		
		httpPost.setEntity(params);		
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String stringBody = EntityUtils.toString(response.getEntity(), "utf-8");		
		//logger.info("[VideoUtil] : json stringBody" + stringBody);

		// 得到Json数据
		 T object = null;
		try {
			 object =  JSON.parseObject(stringBody, clazz);			
		} catch (Exception e) {
			logger.error("[VideoUtil] json parse exception : "	+ e + ",msg : " + e.getMessage());
			throw new VcloudException("[VideoUtil] json parse exception", e);			
		}
		return object;	
	}
	
	
	
	
}
