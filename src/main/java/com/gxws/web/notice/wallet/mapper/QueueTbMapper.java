package com.gxws.web.notice.wallet.mapper;

import java.util.List;

import com.gxws.tool.mybatis.mapper.Mapper;
import com.gxws.web.notice.wallet.tb.QueueTb;

/**
 * @author zhuwl120820@gxwsxx.com
 * @since 1.0
 */
public interface QueueTbMapper extends Mapper<QueueTb> {

	public List<QueueTb> selectSendList(String without);
}
