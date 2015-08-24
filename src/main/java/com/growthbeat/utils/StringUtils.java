package com.growthbeat.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static String urlEncode(String string) {
		try {
			return URLEncoder.encode(string, Charset.defaultCharset().toString());
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public static String urlDecode(String string) {
		try {
			return URLDecoder.decode(string, Charset.defaultCharset().toString());
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
