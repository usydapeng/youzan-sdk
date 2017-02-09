package org.zunpeng.youzan;

import java.util.Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public class ApiReturnInfo<T> {

	private Map<String, T> response;

	public Map<String, T> getResponse() {
		return response;
	}

	public void setResponse(Map<String, T> response) {
		this.response = response;
	}
}
