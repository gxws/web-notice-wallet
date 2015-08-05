package com.gxws.web.notice.wallet.test;

import java.util.Date;

import com.gxws.tool.test.data.annotation.Random;
import com.gxws.tool.test.data.annotation.RandomDate;
import com.gxws.tool.test.data.annotation.RandomId;
import com.gxws.tool.test.data.annotation.RandomNumber;
import com.gxws.tool.test.data.annotation.RandomString;

/**
 * 通知列表
 * 
 * @author zhuwl120820@gxwsxx.com
 * @since 1.0
 */
@Random(numberOfTime = 100)
public class QueueTb {
	@RandomId
	private String id;
	@RandomNumber(start = "0", end = "3")
	private Integer status;
	@RandomString()
	private String data;
	private String url;
	@RandomDate(start = "2015/08/01 00:00:00", end = "2015/09/01 00:00:00")
	private Date timeCreate;
	private Date timeSent;
	@RandomString(length = 10)
	private String appKey;

}
