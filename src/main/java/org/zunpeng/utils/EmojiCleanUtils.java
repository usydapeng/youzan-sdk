package org.zunpeng.utils;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiCleanUtils {

	private static final Logger logger = LoggerFactory.getLogger(EmojiCleanUtils.class);

	public static String clean(String content){
		String result = content;
		Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
							Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE );
		try {
			Matcher emojiMatcher = emoji.matcher(content);
			while(emojiMatcher.find()){
				result = result.replace(emojiMatcher.group(), "");
			}
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			result = null;
		}

		if(result != null){
			result = Jsoup.clean(result, Whitelist.none());
		}

		result = result.trim();

		if(StringUtils.isBlank(result)){
			result = "用户" + String.valueOf(Math.abs(UUID.randomUUID().toString().replace("-", "").hashCode())).substring(0, 5);
		}

		result = result.trim();

		return result;
	}
}
