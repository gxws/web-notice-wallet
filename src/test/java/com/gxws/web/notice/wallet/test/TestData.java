package com.gxws.web.notice.wallet.test;

import com.gxws.tool.test.data.generate.SqlFileGenerator;

/**
 * @author zhuwl120820@gxwsxx.com
 * @since
 */
public class TestData {
	public static void main(String[] args) {
		SqlFileGenerator sfg = new SqlFileGenerator("db_auto_small.sql");
		sfg.add(QueueTb.class);
		sfg.close();
	}
}
