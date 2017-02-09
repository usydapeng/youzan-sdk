package org.zunpeng.youzan.user;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.zunpeng.youzan.ApiAuthBean;

/**
 * Created by dapeng on 2017/2/9.
 */
public class GetUserInfo extends ApiAuthBean {

	@XStreamAlias("weixin_openid")
	private String openId;

	private String fields;

	@XStreamAlias("user_id")
	private Long userId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
