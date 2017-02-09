package org.zunpeng.youzan;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.zunpeng.utils.bean2map.Bean2Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public class ApiAuthBean extends Bean2Map {

	@XStreamAlias("access_token")
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
