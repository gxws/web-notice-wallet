package com.gxws.web.notice.wallet.dm;

import java.util.Date;

import com.gxws.web.notice.wallet.tb.QueueTb;

/**
 * 发送对象包装类
 * 
 * @author zhuwl120820@gxwsxx.com
 * @since 1.0
 */
public class QueueDm {
	private QueueTb queueTb;

	private Date time;
	private Date initTime;

	public QueueTb getQueueTb() {
		return queueTb;
	}

	public void setQueueTb(QueueTb queueTb) {
		this.queueTb = queueTb;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getInitTime() {
		return initTime;
	}

	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

}
