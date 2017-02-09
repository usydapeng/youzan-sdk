package org.zunpeng.utils;

import com.squareup.okhttp.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RequestUtils {

	private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

	private static final OkHttpClient client = new OkHttpClient();

	public static String getJson(String url){
		try {
			Request request = new Request.Builder()
					.url(url)
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.build();
			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				logger.info("post error: " + response.message());
				return null;
			}

			String contentType = response.header("Content-Type");
			if(contentType.contains("application/json")){
				String message = response.body().string();
				logger.info("sms send response: " + message);
				return message;
			}

			return null;
		} catch(Throwable t){
			logger.info(t.getMessage());
			return null;
		}
	}

	public static String post(String url, Map<String, String> requestParameters){
		try {
			FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
			if(requestParameters != null){
				for(String key : requestParameters.keySet()){
					Object value = requestParameters.get(key);
					if(value == null || StringUtils.isBlank(value.toString())){
						continue;
					}
					formEncodingBuilder.add(key, value.toString());
				}
			}
			RequestBody requestBody = formEncodingBuilder.build();

			Request request = new Request.Builder()
					.addHeader("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1")
					.addHeader("Accept",
							"application/json;charset=utf-8;")
					.addHeader("Content-Type",
							"application/x-www-form-urlencoded;charset=utf-8;")
					.url(url)
					.post(requestBody)
					.build();

			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				logger.info("post error: " + response.message());
				return null;
			}

			String message = response.body().string();
			logger.info("sms send response: " + message);
			return message;
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public static String buildUrl(String url, Map<String, String> requestParameters){
		try {
			String paramStr = ApiUtils.buildParamStr(requestParameters, true, true);
			if(StringUtils.isBlank(paramStr)){
				return url;
			} else {
				return url + "?" + paramStr;
			}
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public static String getSign(Map<String, String> params, String appkey) {
		try {
			String paramStr = ApiUtils.buildParamStr(params, false, true) + appkey;
			return Md5Utils.md5(paramStr);
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

}