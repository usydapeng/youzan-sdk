package org.zunpeng.youzan;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dapeng on 2017/2/9.
 */
public class ApiErrorBean {

	@SerializedName("msg")
	private String message;

	private long code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}
}
