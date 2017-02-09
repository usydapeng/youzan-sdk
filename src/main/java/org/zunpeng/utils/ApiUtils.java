package org.zunpeng.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by dapeng on 16/1/20.
 */
public class ApiUtils {

	public static String encodeParam(String param) throws UnsupportedEncodingException {
		return URLEncoder.encode(param, "UTF-8");
	}

	public static String buildParamStr(Map<String, String> requestParameters, boolean encode, boolean sorted) throws UnsupportedEncodingException {
		String paramStr = "";
		if(requestParameters != null && requestParameters.size() > 0){
			List<String> keyList = Lists.newArrayList(requestParameters.keySet());
			if(sorted){
				Collections.sort(keyList);
			}
			int i = 0;
			for(String key : keyList){
				String value = requestParameters.get(key);
				if(value == null || StringUtils.isBlank(value.toString())){
					continue;
				}
				if(i > 0){
					paramStr += "&";
				}
				if(encode){
					paramStr += (key + "=" + encodeParam(value.toString()));
				} else {
					paramStr += (key + "=" + value);
				}
				i ++;
			}
		}
		return paramStr;
	}
}
