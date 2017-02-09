package org.zunpeng.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;

/**
 * Created by dapeng on 16/1/20.
 */
public class UriEncoderUtils {

	private static Logger logger = LoggerFactory.getLogger(UriEncoderUtils.class);

	public static String encodeUrl(String uri){
		try {
			return URLEncoder.encode(uri, "UTF-8");
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return null;
		}
	}
}
