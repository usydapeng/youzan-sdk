package org.zunpeng.utils.retrofit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dapeng on 2017/1/19.
 */
public class CustomCookieJar implements CookieJar {

	private static Logger logger = LoggerFactory.getLogger(CustomCookieJar.class);

	private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

	private static long timestamp = 0;

	public static long getTimestamp() {
		return timestamp;
	}

	public static void setTimestamp(long timestamp) {
		CustomCookieJar.timestamp = timestamp;
	}

	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		logger.info("---------save from response ");

		for(Cookie cookie : cookies){
			if("session".equalsIgnoreCase(cookie.name())){
				timestamp = new Date().getTime() + (1000 * 60 * 60 * 2);
			}
		}

		cookieStore.put(url.host(), cookies);
	}

	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		logger.info("-----------load for request ");
		List<Cookie> cookies = cookieStore.get(url.host());
		return cookies != null ? cookies : new ArrayList<Cookie>();
	}
}
