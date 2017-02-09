package org.zunpeng.youzan;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.zunpeng.utils.bean2map.Bean2Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public class GetAuthorizationCode extends Bean2Map {

	@XStreamAlias("client_id")
	private String clientId;

	@XStreamAlias("response_type")
	private String responseType = "code";

	private String state;

	@XStreamAlias("redirect_uri")
	private String redirectUri;

	private String scope;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
