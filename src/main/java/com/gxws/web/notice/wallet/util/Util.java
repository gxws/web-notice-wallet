package com.gxws.web.notice.wallet.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuwl120820@gxwsxx.com
 * @since
 */
public class Util {
	public static Map<String, String> string2Map(String data, String separatorMap, String separatorKeyValue) {
		Map<String, String> map = new HashMap<>();
		if (null == data || "".equals(data)) {
			return map;
		}
		String[] arrays = data.split(separatorMap);
		String[] keyValue = new String[2];
		for (String s : arrays) {
			keyValue = s.split(separatorKeyValue);
			map.put(keyValue[0], keyValue[1]);
		}
		return map;
	}

	/**
	 * 签名
	 * 
	 * @author：韦永玉
	 * @create：2014年7月30日 上午9:30:26
	 * @param params
	 *            签名参数
	 * @param key
	 *            钥匙
	 * @param signType
	 *            加密类型
	 * @param charset
	 *            编码格式
	 * @return
	 */
	public static String sign(Map<String, String> params, String charset) {
		String linkStr = createLinkString(paraFilter(params));
		return sign(linkStr, charset);
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("paySign")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 签名
	 * 
	 * @author：韦永玉
	 * @create：2014年7月25日 上午11:55:29
	 * @param in
	 * @param key
	 * @param charset
	 * @return
	 */
	public static String sign(String in, String charset) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = getContentBytes(in, charset);
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("sha-1");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (null == charset || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("sha-1签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
}
