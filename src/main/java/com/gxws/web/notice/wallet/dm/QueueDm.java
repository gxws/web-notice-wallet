package com.gxws.web.notice.wallet.dm;

import java.util.Date;

import com.gxws.web.notice.wallet.tb.QueueTb;

/**
 * @author zhuwl120820@gxwsxx.com
 * @since
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
