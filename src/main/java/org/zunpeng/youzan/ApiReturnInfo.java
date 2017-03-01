package org.zunpeng.youzan;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public class ApiReturnInfo<T> {

	private Map<String, T> response;

	@SerializedName("error_response")
	private ApiErrorBean errorResponse;

	public Map<String, T> getResponse() {
		return response;
	}

	public void setResponse(Map<String, T> response) {
		this.response = response;
	}

	public ApiErrorBean getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ApiErrorBean errorResponse) {
		this.errorResponse = errorResponse;
	}

	public T instance(){
		if(response != null && response.size() == 1){
			return response.get(response.keySet().iterator().next());
		}
		return null;
	}
}
