package com.netease.vcloud.transcode.module;


import java.util.List;
import java.util.Map;


/**
* <p>Title: MultiVideoTranscodingWithoutPresetModule</p>
* <p>Description: 多视频无模板转码输入参数的封装类</p>
* <p>Company: com.netease.vcloud</p>
* @date       2016-7-7
*/
public class MultiVideoTranscodingWithoutPresetModule {

	/** 需要转码的多个视频ID组成的列表    参数必填*/
	List<Long> vids;
	
	/** 标清Mp4格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer sdMp4;

	/** 高清Mp4格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer hdMp4;

	/** 超清Mp4格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer shdMp4;

	/** 标清Flv格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer sdFlv;

	/** 高清Flv格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer hdFlv;

	/** 超清Flv格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer shdFlv;

	/** 标清Hls格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer sdHls;

	/** 高清Hls格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer hdHls;

	/** 超清Hls格式（1表示选择，0表示不选择） 参数必填 */
	private  Integer shdHls;

	
	
	public MultiVideoTranscodingWithoutPresetModule() {	
	}
	
	
	public MultiVideoTranscodingWithoutPresetModule(List<Long> vids, Map<String, Integer> videoFormatMap) {
		this.vids = vids;
		this.sdMp4 = videoFormatMap.get("sdMp4");
		this.hdMp4 = videoFormatMap.get("hdMp4");
		this.shdMp4 = videoFormatMap.get("shdMp4");
		this.sdFlv = videoFormatMap.get("sdFlv");
		this.hdFlv = videoFormatMap.get("hdFlv");
		this.shdFlv = videoFormatMap.get("shdFlv");
		this.sdHls = videoFormatMap.get("sdHls");
		this.hdHls = videoFormatMap.get("hdHls");
		this.shdHls = videoFormatMap.get("shdHls");
	}


	public MultiVideoTranscodingWithoutPresetModule(List<Long> vids,
			Integer sdMp4, Integer hdMp4, Integer shdMp4, Integer sdFlv,
			Integer hdFlv, Integer shdFlv, Integer sdHls, Integer hdHls,
			Integer shdHls) {	
		this.vids = vids;
		this.sdMp4 = sdMp4;
		this.hdMp4 = hdMp4;
		this.shdMp4 = shdMp4;
		this.sdFlv = sdFlv;
		this.hdFlv = hdFlv;
		this.shdFlv = shdFlv;
		this.sdHls = sdHls;
		this.hdHls = hdHls;
		this.shdHls = shdHls;
	}
	public List<Long> getVids() {
		return vids;
	}
	public void setVids(List<Long> vids) {
		this.vids = vids;
	}
	public Integer getSdMp4() {
		return sdMp4;
	}
	public void setSdMp4(Integer sdMp4) {
		this.sdMp4 = sdMp4;
	}
	public Integer getHdMp4() {
		return hdMp4;
	}
	public void setHdMp4(Integer hdMp4) {
		this.hdMp4 = hdMp4;
	}
	public Integer getShdMp4() {
		return shdMp4;
	}
	public void setShdMp4(Integer shdMp4) {
		this.shdMp4 = shdMp4;
	}
	public Integer getSdFlv() {
		return sdFlv;
	}
	public void setSdFlv(Integer sdFlv) {
		this.sdFlv = sdFlv;
	}
	public Integer getHdFlv() {
		return hdFlv;
	}
	public void setHdFlv(Integer hdFlv) {
		this.hdFlv = hdFlv;
	}
	public Integer getShdFlv() {
		return shdFlv;
	}
	public void setShdFlv(Integer shdFlv) {
		this.shdFlv = shdFlv;
	}
	public Integer getSdHls() {
		return sdHls;
	}
	public void setSdHls(Integer sdHls) {
		this.sdHls = sdHls;
	}
	public Integer getHdHls() {
		return hdHls;
	}
	public void setHdHls(Integer hdHls) {
		this.hdHls = hdHls;
	}
	public Integer getShdHls() {
		return shdHls;
	}
	public void setShdHls(Integer shdHls) {
		this.shdHls = shdHls;
	}	
	
	
	
	
}
