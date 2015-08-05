package com.gxws.web.notice.wallet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 接收消息测试
 * 
 * @author zhuwl120820@gxwsxx.com
 * @since 1.0
 */
@Controller
public class ReceiveTestController {

	private final static Logger log = LoggerFactory.getLogger(ReceiveTestController.class);

	@RequestMapping("/receiveTestController")
	public void receiveTestController(HttpServletResponse res) {
		log.info("receiveTestController");
		try {
			PrintWriter pw = res.getWriter();
			pw.write("success");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
