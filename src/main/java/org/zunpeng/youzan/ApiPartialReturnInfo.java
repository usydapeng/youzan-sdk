package org.zunpeng.youzan;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dapeng on 2017/3/1.
 */
public class ApiPartialReturnInfo<T> {

	private T response;

	@SerializedName("error_response")
	private ApiErrorBean errorResponse;

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public ApiErrorBean getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ApiErrorBean errorResponse) {
		this.errorResponse = errorResponse;
	}

	public T instance(){
		if(response != null){
			return response;
		}
		return null;
	}
}
