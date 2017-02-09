package org.zunpeng.youzan;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zunpeng.utils.ApiUtils;

import java.util.Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public class YouzanApiUtils {

	private static Logger logger = LoggerFactory.getLogger(YouzanApiUtils.class);

	public static String URL_GET_AUTHORIATION_CODE = "https://open.youzan.com/oauth/authorize";

	private static String version_1_0_0 = "1.0.0";

	private static String version_2_0_0 = "2.0.0";

	//根据微信粉丝用户的 openid 或 fans_id 获取用户信息
	private static String MEHTOD_KDT_USERS_WEIXIN_FOLLOWER = "kdt.users.weixin.follower";

	//获取单笔交易的信息 2.0.0
	private static String METHOD_KDT_TRADE = "kdt.trade";

	//根据商品货号获取商品
	private static String METHOD_KDT_ITEMS_CUSTOM = "kdt.items.custom";

	public static String buildUrl(String baseUrl, Map<String, String> requestParameters) {
		try {
			String httpUrl = baseUrl;
			String paramStr = ApiUtils.buildParamStr(requestParameters, true, false);
			if(StringUtils.isNotBlank(paramStr)){
				httpUrl += "?" + paramStr;
			}
			return httpUrl;
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return null;
		}
	}
}
