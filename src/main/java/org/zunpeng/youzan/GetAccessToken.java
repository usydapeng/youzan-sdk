package org.zunpeng.youzan;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.zunpeng.utils.bean2map.Bean2Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public class GetAccessToken extends Bean2Map {

	@XStreamAlias("client_id")
	private String clientId;

	@XStreamAlias("client_secret")
	private String clientSecret;

	@XStreamAlias("grant_type")
	private String grantType = "authorization_code";

	private String code;

	@XStreamAlias("redirect_uri")
	private String redirectUri;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
}
