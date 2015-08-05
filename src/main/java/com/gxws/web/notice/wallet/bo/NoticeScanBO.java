package com.gxws.web.notice.wallet.bo;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gxws.web.notice.wallet.dm.QueueDm;
import com.gxws.web.notice.wallet.mapper.QueueTbMapper;
import com.gxws.web.notice.wallet.tb.QueueTb;

/**
 * 消息获取
 * 
 * @author zhuwl120820@gxwsxx.com
 * @since 1.0
 */
@Component
public class NoticeScanBO {

	private Logger log = Logger.getLogger(getClass());

	@Autowired
	private NoticeSendBO noticeSendBO;

	// @Autowired
	// private INoticeBO noticeBO;

	@Autowired
	private QueueTbMapper qm;

	private static long last = new Date().getTime();

	// private BigDecimal ms = new BigDecimal("1000");

	private static final long scan = 5000;

	private static long now;

	@Scheduled(cron = "0/1 * * * * ?")
	public void scanning() {
		// log.debug("获取新的通知");
		now = new Date().getTime();
		if (last + scan > now) {
			return;
		}
		// List<NoticeQueueDM> list = noticeSendBO.getList();
		List<QueueDm> list = noticeSendBO.getList();
		StringBuffer sb = new StringBuffer();
		// for (NoticeQueueDM dm : list) {
		QueueTb tb = null;
		for (QueueDm dm : list) {
			tb = dm.getQueueTb();
			sb.append(tb.getId() + ",");
		}
		String without = "";
		if (0 == sb.length()) {

		} else {
			without = sb.substring(0, sb.length() - 1);
		}
		// list = noticeBO.getNewNotice(without);
		List<QueueTb> tblist = qm.selectSendList(without);
		if (null != tblist && 0 != tblist.size()) {
			log.debug("新通知：" + tblist.size());
			noticeSendBO.addList(tblist);
		}
		last = now;
	}

	// @Scheduled(cron = "0 0/1 * * * ?")
	// public void getScanSleep() {
	// // scan = noticeBO.getScanSleep().multiply(ms).longValue();
	// log.debug("获取scanSleep: " + scan + " ms");
	// }
}
