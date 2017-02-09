package org.zunpeng.youzan;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dapeng on 2017/2/9.
 */
public class AuthErrorBean {

	@SerializedName("error_description")
	private String errorDesc;

	private String error;

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
