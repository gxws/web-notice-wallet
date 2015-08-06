package com.gxws.web.notice.wallet.tb;

import java.util.Date;

/**
 * 通知列表
 * 
 * @author zhuwl120820@gxwsxx.com
 * @since 1.0
 */
public class QueueTb {
	private String id;
	private Integer status;
	private String data;
	private String url;
	private Date timeCreate;
	private Date timeSent;
//	private String appKey;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Date getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}

//	public String getAppKey() {
//		return appKey;
//	}
//
//	public void setAppKey(String appKey) {
//		this.appKey = appKey;
//	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
