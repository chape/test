package com.netease.vcloud.transcode.util;

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
import com.netease.vcloud.transcode.module.MultiVideoTranscodingModule;
import com.netease.vcloud.transcode.module.MultiVideoTranscodingWithoutPresetModule;
import com.netease.vcloud.transcode.module.SetVideoCallBackModule;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingParam;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingWithoutPresetParam;
import com.netease.vcloud.transcode.param.SetVideoCallBackParam;
import com.netease.vcloud.util.HttpClientBuilder;
import com.netease.vcloud.util.HttpPostBuilder;


/**
* <p>Title: TranscodeUtil</p>
* <p>Description: 视频转码的工具类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-1
*/
public class TranscodeUtil {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(TranscodeUtil.class);	

	/** 多视频转码输入参数的封装类 */
	private MultiVideoTranscodingModule multiVideoTranscodingModule;
	
	/** 多视频无模板转码输入参数的封装类*/
	private MultiVideoTranscodingWithoutPresetModule multiVideoTranscodingWithoutPresetModule;
	
	/** 设置回调地址接口输入参数的封装类*/
	private SetVideoCallBackModule setVideoCallBackModule;
	
	/**
	 * 
	* <p>Description: 多视频转码的构造函数</p>
	* @param multiVideoTranscodingModule  多视频转码输入参数的封装类
	 */
	public TranscodeUtil(MultiVideoTranscodingModule multiVideoTranscodingModule) {		
		this.multiVideoTranscodingModule = multiVideoTranscodingModule;
	}
		
	
	/**
	 * 
	* <p>Description: 多视频无模板转码的构造函数 </p>
	* @param multiVideoTranscodingWithoutPresetModule  多视频无模板转码输入参数的封装类
	 */
	public TranscodeUtil(MultiVideoTranscodingWithoutPresetModule multiVideoTranscodingWithoutPresetModule) {	
		this.multiVideoTranscodingWithoutPresetModule = multiVideoTranscodingWithoutPresetModule;
	}	
	
	/**
	 * 
	* <p>Description: 设置回调地址的构造函数</p>
	* @param setVideoCallBackModule 设置回调地址接口输入参数的封装类
	 */
	public TranscodeUtil(SetVideoCallBackModule setVideoCallBackModule) {	
		this.setVideoCallBackModule = setVideoCallBackModule;
	}
	
	
	/**
	* <p>Title: multiVideoTranscoding</p>
	* <p>Description: 多视频转码</p>
	* @return multiVideoTranscodingParam 多视频转码输出参数的封装类
	* @throws IOException
	 * @throws VcloudException 
	*/
	public MultiVideoTranscodingParam multiVideoTranscoding() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/transcode/resetmulti";
		String url = Config.getMultiVideoTranscodingURL();		
		
		/* 设置请求的参数 */		
		StringEntity params = new StringEntity(JSON.toJSONString(multiVideoTranscodingModule));	
		// 得到Json数据
		MultiVideoTranscodingParam multiVideoTranscodingParam = (MultiVideoTranscodingParam) jsonParamObjectBuilder(url, params, MultiVideoTranscodingParam.class);			
		
		return multiVideoTranscodingParam;
	}
	
		
	/**
	* <p>Title: multiVideoTranscodingWithoutPreset</p>
	* <p>Description: 多视频无模板转码</p>
	* @return multiVideoTranscodingWithoutPresetParam  多视频无模板转码输出参数的封装类
	* @throws IOException
	 * @throws VcloudException 
	*/
	public MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPreset() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/transcode";
		String url = Config.getMultiVideoTranscodingWithoutPresetURL();
		
		/* 设置请求的参数 */			
		StringEntity params = new StringEntity(JSON.toJSONString(multiVideoTranscodingWithoutPresetModule));	
		// 得到Json数据
		MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPresetParam = (MultiVideoTranscodingWithoutPresetParam) jsonParamObjectBuilder(url, params, MultiVideoTranscodingWithoutPresetParam.class);			
		
		return multiVideoTranscodingWithoutPresetParam;
	}
	
	/**
	 * <p>Title: setVideoCallBack</p>
	 * <p>Description: 设置回调地址</p>
	 * @return setVideoCallBackParam  设置回调地址输出参数的封装类
	 * @throws IOException
	 * @throws VcloudException 
	 */
	public SetVideoCallBackParam setVideoCallBack() throws IOException, VcloudException  {

		/* 接口 */
		//String url = "https://vcloud.163.com/app/vod/transcode/setcallback";
		String url = Config.getSetVideoCallBackURL();
		/* 设置请求的参数 */
		//StringEntity params = new StringEntity("{\"callbackUrl\":\"" + callbackUrl + "\"}");
		
		StringEntity params = new StringEntity(JSON.toJSONString(setVideoCallBackModule));
		// 得到Json数据
		SetVideoCallBackParam setVideoCallBackParam = (SetVideoCallBackParam) jsonParamObjectBuilder(url, params, SetVideoCallBackParam.class);			
		
		return setVideoCallBackParam;
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
