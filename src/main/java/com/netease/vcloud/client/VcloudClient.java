package com.netease.vcloud.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.ClientConfiguration;
import com.netease.vcloud.VcloudException;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.config.Config;

import com.netease.vcloud.transcode.param.MultiVideoTranscodingParam;
import com.netease.vcloud.transcode.param.MultiVideoTranscodingWithoutPresetParam;
import com.netease.vcloud.transcode.param.SetVideoCallBackParam;
import com.netease.vcloud.transcode.service.MultiVideoTranscodingService;
import com.netease.vcloud.transcode.service.MultiVideoTranscodingWithoutPresetService;
import com.netease.vcloud.transcode.service.SetVideoCallBackService;
import com.netease.vcloud.transcode.service.impl.MultiVideoTranscodingServiceImpl;
import com.netease.vcloud.transcode.service.impl.MultiVideoTranscodingWithoutPresetServiceImpl;
import com.netease.vcloud.transcode.service.impl.SetVideoCallBackServiceImpl;

import com.netease.vcloud.upload.param.GetUploadHostParam;
import com.netease.vcloud.upload.param.InitUploadVideoParam;
import com.netease.vcloud.upload.param.QueryOffsetParam;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;
import com.netease.vcloud.upload.param.UploadVideoFragmentParam;
import com.netease.vcloud.upload.recorder.Recorder;
import com.netease.vcloud.upload.service.GetUploadHostService;
import com.netease.vcloud.upload.service.InitUploadVideoService;
import com.netease.vcloud.upload.service.QueryOffsetService;
import com.netease.vcloud.upload.service.QueryVideoIDorWatermarkIDService;
import com.netease.vcloud.upload.service.UploadVideoFragmentService;
import com.netease.vcloud.upload.service.UploadVideoService;
import com.netease.vcloud.upload.service.UploadVideoWithRecorderService;
import com.netease.vcloud.upload.service.impl.GetUploadHostServiceImpl;
import com.netease.vcloud.upload.service.impl.InitUploadVideoServiceImpl;
import com.netease.vcloud.upload.service.impl.QueryOffsetServiceImpl;
import com.netease.vcloud.upload.service.impl.QueryVideoIDorWatermarkIDServiceImpl;
import com.netease.vcloud.upload.service.impl.UploadVideoFragmentServiceImpl;
import com.netease.vcloud.upload.service.impl.UploadVideoServiceImpl;
import com.netease.vcloud.upload.service.impl.UploadVideoWithRecorderServiceImpl;
import com.netease.vcloud.video.param.DeleteSingleTranscodeVideoParam;
import com.netease.vcloud.video.param.DeleteSingleVideoParam;
import com.netease.vcloud.video.param.DisableVideoParam;
import com.netease.vcloud.video.param.EditVideoParam;
import com.netease.vcloud.video.param.GetSingleVideoParam;
import com.netease.vcloud.video.param.GetVideoListParam;
import com.netease.vcloud.video.param.RecoverVideoParam;
import com.netease.vcloud.video.service.DeleteSingleTranscodeVideoService;
import com.netease.vcloud.video.service.DeleteSingleVideoService;
import com.netease.vcloud.video.service.DisableVideoService;
import com.netease.vcloud.video.service.EditVideoService;
import com.netease.vcloud.video.service.GetSingleVideoService;
import com.netease.vcloud.video.service.GetVideoListService;
import com.netease.vcloud.video.service.RecoverVideoService;
import com.netease.vcloud.video.service.impl.DeleteSingleTranscodeVideoServiceImpl;
import com.netease.vcloud.video.service.impl.DeleteSingleVideoServiceImpl;
import com.netease.vcloud.video.service.impl.DisableVideoServiceImpl;
import com.netease.vcloud.video.service.impl.EditVideoServiceImpl;
import com.netease.vcloud.video.service.impl.GetSingleVideoServiceImpl;
import com.netease.vcloud.video.service.impl.GetVideoListServiceImpl;
import com.netease.vcloud.video.service.impl.RecoverVideoServiceImpl;


/**
* <p>Title: VcloudClient</p>
* <p>Description: 提供给用户进行点播相关操作的视频云客户端</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-1
*/
public class VcloudClient {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(VcloudClient.class);
	
	/** 访问服务的凭据类*/
	private Credentials credentials;
	
	/** 客户端配置类*/
	private ClientConfiguration clientConfiguration;

	/**
	 * 
	* <p>Description: 传入访问服务的凭据类和客户端配置类构造视频云客户端</p>
	* @param credentials            传入访问服务的凭据类
	* @param clientConfiguration    客户端配置类
	 */
	public VcloudClient(Credentials credentials,
			ClientConfiguration clientConfiguration) {	
		this.credentials = credentials;
		this.clientConfiguration = clientConfiguration;
		init();
	}
	
	/**
	 * 
	* <p>Description:  传入访问服务的凭据类构造视频云客户端，客户端配置会采用默认配置</p>
	* @param credentials 传入访问服务的凭据类
	 */
	public VcloudClient(Credentials credentials) {		
		this.credentials = credentials;
		this.clientConfiguration = new ClientConfiguration();
		init();
	}
	
	/**
	 * 
	* <p>Title: init</p>
	* <p>Description: 利用访问服务的凭据类和客户端配置类初始化配置信息</p>
	 */
	public void init(){
		Config.setConnectionTimeout(clientConfiguration.getConnectionTimeout());
		Config.setSocketTimeout(clientConfiguration.getSocketTimeout());
		Config.setAppKey(credentials.getAppKey());
		Config.setAppSecret(credentials.getAppSecret());
	}
		
	
	/**
	 * 
	 * <p>Title: getSingleVideo</p>
	 * <p>Description: 获取单个视频</p>
	 * @param vid  视频ID
	 * @return getSingleVideoParam  获取单个视频返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public GetSingleVideoParam getSingleVideo(Long vid) throws IOException, VcloudException  {
		GetSingleVideoService getSingleVideoService = new GetSingleVideoServiceImpl();
		return getSingleVideoService.getSingleVideo(vid);
	}
	
	/**
	 * 
	 * <p>Title: getVideoList</p>
	 * <p>Description: 获取视频列表</p>	
	 * @param currentPage    获取视频列表分页后的索引
	 * @param pageSize       获取视频列表一页的记录数（若为-1，表示不用分页）
	 * @param status         根据视频状态过滤选择（0表示获取所有状态视频）
	 * @param type           根据视频分类过滤选择（0表示获取所有分类视频）
	 * @return getVideoListParam  获取视频列表返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public GetVideoListParam getVideoList(Integer currentPage, Integer pageSize, Integer status, Integer type) throws IOException, VcloudException  {
		GetVideoListService getVideoListService = new GetVideoListServiceImpl();
		return getVideoListService.getVideoList(currentPage, pageSize, status, type);
	}
	
	/**
	 * 
	 * <p>Title: editVideo</p>
	 * <p>Description: 视频编辑</p>
	 * @param vid             视频ID
	 * @param videoName       视频的名称
	 * @param typeId          视频分类ID	
	 * @return editVideoParam 视频编辑返回结果的封装类 
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public EditVideoParam editVideo(Long vid, String videoName,
			Long typeId) throws IOException, VcloudException  {	
		return this.editVideo(vid, videoName, typeId, null);
	}
	
	/**
	 * 
	 * <p>Title: editVideo</p>
	 * <p>Description: 视频编辑</p>
	 * @param vid             视频ID
	 * @param videoName       视频的名称
	 * @param typeId          视频分类ID
	 * @param description     视频的描述信息
	 * @return editVideoParam 视频编辑返回结果的封装类 
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public EditVideoParam editVideo(Long vid, String videoName,
			Long typeId, String description) throws IOException, VcloudException  {
		EditVideoService editVideoService = new EditVideoServiceImpl();
		return editVideoService.editVideo(vid, videoName, typeId, description);				
	}
	
	/**
	 * 
	 * <p>Title: deleteSingleTransCodeVideo</p>
	 * <p>Description: 删除单个转码输出视频</p>
	 * @param vid      视频ID
	 * @param style    视频转码格式
	 * @return deleteSingleTranscodeVideoParam 删除单个转码输出视频返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public DeleteSingleTranscodeVideoParam deleteSingleTransCodeVideo(Long vid, Integer style) throws IOException, VcloudException  {
		DeleteSingleTranscodeVideoService deleteSingleTranscodeVideoService = new DeleteSingleTranscodeVideoServiceImpl();
		return deleteSingleTranscodeVideoService.deleteSingleTransCodeVideo(vid, style);
	}
	
	
	/**
	 * 
	 * <p>Title: deleteSingleVideo</p>
	 * <p>Description: 删除视频</p>
	 * @param vid 视频ID
	 * @return deleteSingleVideoParam 删除视频返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public DeleteSingleVideoParam deleteSingleVideo(Long vid) throws IOException, VcloudException  {
		DeleteSingleVideoService deleteSingleVideoService = new DeleteSingleVideoServiceImpl();
		return deleteSingleVideoService.deleteSingleVideo(vid);
	}
	
	/**
	 * 
	 * <p>Title: disableVideo</p>
	 * <p>Description: 视频屏蔽</p>
	 * @param vid      视频ID
	 * @return disableVideoParam 视频屏蔽返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	
	public DisableVideoParam disableVideo(Long vid) throws IOException, VcloudException  {
		DisableVideoService disableVideoService = new DisableVideoServiceImpl();
		return disableVideoService.disableVideo(vid);
	}
	
	/**
	 * <p>Title: recoverVideo</p>
	 * <p>Description: 视频恢复</p>
	 * @param vid      视频ID
	 * @return recoverVideoParam 视频恢复返回结果的封装
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public RecoverVideoParam recoverVideo(Long vid) throws IOException, VcloudException  {
		RecoverVideoService recoverVideoService = new RecoverVideoServiceImpl();
		return recoverVideoService.recoverVideo(vid);
	}
	
	/**
	 * 
	 * <p>Title: multiVideoTranscoding</p>
	 * <p>Description: 多视频转码</p>
	 * @param vids      需要转码的多个视频ID组成的列表
	 * @param presetId  转码模板ID
	 * @return multiVideoTranscodingParam 多视频转码返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	
	public MultiVideoTranscodingParam multiVideoTranscoding(List<Long> vids, Long presetId) throws IOException, VcloudException  {
		return multiVideoTranscoding(vids, presetId, null);
	}
	
	/**
	 * 
	* <p>Title: multiVideoTranscoding</p>
	* <p>Description:  多视频转码</p>
	* @param vids              需要转码的多个视频ID组成的列表
	* @param presetId          转码模板ID
	* @param watermarkId       视频水印ID
	* @return multiVideoTranscodingParam 多视频转码返回结果的封装类
	* @throws IOException
	* @throws VcloudException
	 */
	public MultiVideoTranscodingParam multiVideoTranscoding(List<Long> vids, Long presetId, Long watermarkId) throws IOException, VcloudException  {
		MultiVideoTranscodingService multiVideoTranscodingService = new MultiVideoTranscodingServiceImpl();
		return multiVideoTranscodingService.multiVideoTranscoding(vids, presetId, watermarkId);
	}
	
	
	/**
	 * 
	 * <p>Title: multiVideoTranscodingWithoutPreset</p>
	 * <p>Description: 多视频无模板转码</p>
	 * @param vids              需要转码的多个视频ID组成的列表
	 * @param videoFormatMap    转码格式集合
	 * @return multiVideoTranscodingWithoutPresetParam   多视频无模板转码返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public MultiVideoTranscodingWithoutPresetParam multiVideoTranscodingWithoutPreset(List<Long> vids, Map<String, Integer> videoFormatMap) throws IOException, VcloudException  {
		MultiVideoTranscodingWithoutPresetService multiVideoTranscodingWithoutPresetService = new MultiVideoTranscodingWithoutPresetServiceImpl();
		return multiVideoTranscodingWithoutPresetService.multiVideoTranscodingWithoutPreset(vids, videoFormatMap);
	}
	
	/**
	 * 
	 * <p>Title: setVideoCallBack</p>
	 * <p>Description: 设置回调地址接口</p>
	 * @param callbackUrl  转码成功后回调客户端的URL地址
	 * @return setVideoCallBackParam  设置回调地址接口返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public SetVideoCallBackParam setVideoCallBack(String callbackUrl) throws IOException, VcloudException  {
		SetVideoCallBackService setVideoCallBackService = new SetVideoCallBackServiceImpl();
		return setVideoCallBackService.setVideoCallBack(callbackUrl);		
	}
	
	/**
	 * 
	 * <p>Title: initUploadVideo</p>
	 * <p>Description: 视频上传初始化</p>
	 * @param initParamMap 上传文件的相关信息集合
	 * @return initUploadVideoParam 视频上传初始化返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public InitUploadVideoParam initUploadVideo(Map<String, Object> initParamMap) throws IOException, VcloudException{
		InitUploadVideoService initUploadVideoService = new InitUploadVideoServiceImpl();
		return initUploadVideoService.initUploadVideo(initParamMap);
	}
	
	/**
	 * 
	 * <p>Title: initUploadVideo</p>
	 * <p>Description: 视频上传初始化</p>
	 * @param initParamMap 上传文件的相关信息集合
	 * @return initUploadVideoParam 视频上传初始化返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public InitUploadVideoParam initUploadVideo(String originFileName, String userFileName, Long typeId,
			Long presetId, String callbackUrl, String description, Long watermarkId) throws IOException, VcloudException{
		
		Map<String, Object> initParamMap = new HashMap<String, Object>();
		
		initParamMap.put("originFileName", originFileName);
		initParamMap.put("userFileName", userFileName);
		initParamMap.put("typeId", typeId);
		initParamMap.put("presetId", presetId);
		initParamMap.put("callbackUrl", callbackUrl);
		initParamMap.put("description", description);
		initParamMap.put("watermarkId", watermarkId);
	
		InitUploadVideoService initUploadVideoService = new InitUploadVideoServiceImpl();
		return initUploadVideoService.initUploadVideo(initParamMap);
	}
	
	/**
	 * 
	 * <p>Title: getUploadHost</p>
	 * <p>Description: 获取上传加速节点地址</p>	
	 * @return getUploadHostParam   获取上传加速节点地址返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 	
	 */
	
	public GetUploadHostParam getUploadHost(String bucket) throws IOException, VcloudException{
		GetUploadHostService getUploadHostService = new GetUploadHostServiceImpl();
		return getUploadHostService.getUploadHost(bucket);
	}
	
	/**
	 * 
	 * <p>Title: uploadVideo</p>
	 * <p>Description: 上传视频分片</p>
	 * @param bucket             存储上传文件的桶名 
	 * @param uploadHost         上传加速节点地址
	 * @param object             存储上传文件的对象名
	 * @param offset             当前分片在整个对象中的起始偏移量
	 * @param context            上传上下文
	 * @param in                 上传文件的输出流
	 * @param remainderSize      上传文件剩余大小
	 * @param xNosToken          上传的token信息
	 * @return uploadVideoParam  分片上传视频返回结果的封装类
	 * @throws IOException 
	 * @throws VcloudException 
	 */
	public UploadVideoFragmentParam uploadVideoFragment(String bucket,
			String uploadHost, String object, Long offset, String context,
			InputStream in, Long remainderSize, String xNosToken) throws VcloudException, IOException{
		UploadVideoFragmentService uploadVideoFragmentService = new UploadVideoFragmentServiceImpl();
		return uploadVideoFragmentService.uploadVideo(bucket, uploadHost, object, offset, context, in, remainderSize, xNosToken);
	}
	
	/**
	 * 
	 * <p>Title: uploadVideo</p>
	 * <p>Description: 上传视频分片</p>
	 *@param initUploadVideoParam    视频上传初始化返回结果的封装类
	 * @param getUploadHostParam      获取上传加速节点地址返回结果的封装类
	 * @param offset                  当前分片在整个对象中的起始偏移量
	 * @param context                 上传上下文
	 * @param in                      上传文件的输出流
	 * @param remainderSize           上传文件剩余大小
	 * @return uploadVideoParam  分片上传视频返回结果的封装类
	 * @throws IOException 
	 * @throws VcloudException 
	 */
	public UploadVideoFragmentParam uploadVideoFragment(InitUploadVideoParam initUploadVideoParam,
			GetUploadHostParam getUploadHostParam, Long offset, String context,
			InputStream in, Long remainderSize) throws VcloudException, IOException{
		UploadVideoFragmentService uploadVideoFragmentService = new UploadVideoFragmentServiceImpl();
		return uploadVideoFragmentService.uploadVideo(initUploadVideoParam, getUploadHostParam, offset, context, in, remainderSize);
	}
	
	/**
	 * 
	 * <p>Title: queryVideoID</p>
	 * <p>Description: 上传完成后查询视频主ID</p>
	 * @param objectNamesList  查询视频的对象名集合
	 * @return queryVideoIDParam 上传完成后查询视频主ID返回结果的封装类
	 * @throws VcloudException 
	 * @throws IOException 
	 */
	public QueryVideoIDorWatermarkIDParam queryVideoID(List<String> objectNamesList) throws IOException, VcloudException{
		QueryVideoIDorWatermarkIDService queryVideoIDService = new QueryVideoIDorWatermarkIDServiceImpl();
		return queryVideoIDService.queryVideoID(objectNamesList);
	}
	
	/** 
	 * <p>Title: getPartOffset</p>
	 * <p>Description: 断点续传查询断点</p>
	 * @param uploadHost        上传加速节点地址
	 * @param bucket            存储上传文件的桶名
	 * @param object            存储上传文件的对象名
	 * @param context           上传上下文
	 * @param xNosToken         上传的token信息
	 * @return  queryOffsetParam 断点续传查询断点输出参数的封装类
	 * @throws IOException 
	 * @throws VcloudException
	 */
	public QueryOffsetParam getPartOffset(String uploadHost,
			String bucket, String object, String context, String xNosToken) throws IOException, VcloudException{
		QueryOffsetService queryOffsetService = new QueryOffsetServiceImpl();
		return queryOffsetService.getPartOffset(uploadHost, bucket, object, context, xNosToken);
	}
	
	/**
	 * 
	 * <p>Description: 断点续传查询断点的构造函数 </p>
	 * @param initUploadVideoParam    视频上传初始化返回结果的封装类
	 * @param getUploadHostParam      获取上传加速节点地址返回结果的封装类
	 * @param uploadVideoParam        分片上传视频返回结果的封装类
	 */
	public QueryOffsetParam getPartOffset(InitUploadVideoParam initUploadVideoParam, GetUploadHostParam getUploadHostParam, UploadVideoFragmentParam uploadVideoParam) throws IOException, VcloudException{
		String uploadHost = getUploadHostParam.getUpload().get(0);
		String bucket = initUploadVideoParam.getRet().getBucket();
		String object = initUploadVideoParam.getRet().getObject();
		String context = uploadVideoParam.getContext();
		String xNosToken = initUploadVideoParam.getRet().getxNosToken();
		return this.getPartOffset(uploadHost, bucket, object, context, xNosToken);				
	}
	
	/**
	 * 
	 * <p>Title: uploadVideo</p>
	 * <p>Description: 简单的视频上传</p>
	 * @param filePath       上传文件路径
	 * @param initParamMap   初始化参数集合
	 * @return 视频上传成功，则返回根据对象名查询视频ID输出参数的封装类，否则返回null
	 * @throws VcloudException
	 * @throws IOException
	 */
	public QueryVideoIDorWatermarkIDParam uploadVideo(String filePath,
			Map<String, Object> initParamMap)throws IOException, VcloudException{
		UploadVideoService uploadVideoService = new UploadVideoServiceImpl();
		return uploadVideoService.uploadVideo(filePath, initParamMap);
	}
	
	/**
	 * 
	 * <p>Title: uploadVideo</p>
	 * <p>Description: 简单的视频上传</p>
	 * @param filePath        上传文件路径
	 * @param originFileName  上传文件的原始名称（包含后缀名）
	 * @param userFileName    用户命名的上传文件名称 
	 * @param typeId          视频所属的类别ID（不填写为默认分类）
	 * @param presetId        视频所需转码模板ID（不填写为默认模板）
	 * @param callbackUrl     转码成功后回调客户端的URL地址（需标准http格式）
	 * @param description     上传视频的描述信息 
	 * @param watermarkId     上传视频的水印Id 
	 * @return 视频上传成功，则返回根据对象名查询视频ID输出参数的封装类，否则返回null
	 * @throws VcloudException
	 * @throws IOException
	 */
	public QueryVideoIDorWatermarkIDParam uploadVideo(String filePath, String originFileName, String userFileName, Long typeId,
			Long presetId, String callbackUrl, String description, Long watermarkId)throws IOException, VcloudException{
		
		Map<String, Object> initParamMap = new HashMap<String, Object>();
		
		initParamMap.put("originFileName", originFileName);
		initParamMap.put("userFileName", userFileName);
		initParamMap.put("typeId", typeId);
		initParamMap.put("presetId", presetId);
		initParamMap.put("callbackUrl", callbackUrl);
		initParamMap.put("description", description);
		initParamMap.put("watermarkId", watermarkId);
		
		return this.uploadVideo(filePath, initParamMap);
	}
	
	/**
	 * 
	 * <p>Title: uploadVideoWithRecorder</p>
	 * <p>Description: 支持断点续传的视频上传</p>
	 * @param filePath       上传文件路径
	 * @param initParamMap   初始化参数集合
	 * @param recoderMap     记录视频上传参数的集合，用于存储断点续传所需的相关参数
	 * @return  视频上传成功，则返回根据对象名查询视频ID输出参数的封装类，否则返回null
	 * @throws IOException
	 * @throws VcloudException
	 */
	public QueryVideoIDorWatermarkIDParam uploadVideoWithRecorder(String filePath,
			Map<String, Object> initParamMap, Map<String, Object> recoderMap)throws IOException, VcloudException{
		UploadVideoWithRecorderService uploadVideoWithRecorderService = new UploadVideoWithRecorderServiceImpl();
		return uploadVideoWithRecorderService.uploadVideoWithRecorder(filePath, initParamMap, recoderMap);
	}
	
	/**
	 * 
	 * <p>Title: uploadVideoWithRecorder</p>
	 * <p>Description: 支持断点续传的视频上传</p>
	 * @param filePath       上传文件路径
	 * @param initParamMap   初始化参数集合
	 * @param recorder       断点续传时记录上传进度的实现类
	 * @return  视频上传成功，则返回根据对象名查询视频ID输出参数的封装类，否则返回null
	 * @throws IOException
	 * @throws VcloudException
	 */
	public QueryVideoIDorWatermarkIDParam uploadVideoWithRecorder(String filePath,
			Map<String, Object> initParamMap, Recorder recorder)throws IOException, VcloudException{
		UploadVideoWithRecorderService uploadVideoWithRecorderService = new UploadVideoWithRecorderServiceImpl();
		return uploadVideoWithRecorderService.uploadVideoWithRecorder(filePath, initParamMap, recorder);
	}
	
	/**
	 * 
	 * <p>Title: uploadVideoWithRecorder</p>
	 * <p>Description: 支持断点续传的视频上传</p>
	 * @param filePath        上传文件路径
	 * @param originFileName  上传文件的原始名称（包含后缀名）
	 * @param userFileName    用户命名的上传文件名称 
	 * @param typeId          视频所属的类别ID（不填写为默认分类）
	 * @param presetId        视频所需转码模板ID（不填写为默认模板）
	 * @param callbackUrl     转码成功后回调客户端的URL地址（需标准http格式）
	 * @param description     上传视频的描述信息 
	 * @param watermarkId     上传视频的水印Id 
	 * @param recoderMap      断点续传视频时保存上传进度的参数集合 
	 * @return  视频上传成功，则返回根据对象名查询视频ID输出参数的封装类，否则返回null
	 * @throws IOException
	 * @throws VcloudException
	 */
	public QueryVideoIDorWatermarkIDParam uploadVideoWithRecorder(String filePath,
			String originFileName, String userFileName, Long typeId,
			Long presetId, String callbackUrl, String description, Long watermarkId, Map<String, Object> recoderMap)throws IOException, VcloudException{

		Map<String, Object> initParamMap = new HashMap<String, Object>();
		
		initParamMap.put("originFileName", originFileName);
		initParamMap.put("userFileName", userFileName);
		initParamMap.put("typeId", typeId);
		initParamMap.put("presetId", presetId);
		initParamMap.put("callbackUrl", callbackUrl);
		initParamMap.put("description", description);
		initParamMap.put("watermarkId", watermarkId);
		
		return this.uploadVideoWithRecorder(filePath, initParamMap, recoderMap);
	}
	
	
}
