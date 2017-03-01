package org.zunpeng.youzan.order;

import org.zunpeng.youzan.ApiAuthBean;

/**
 * Created by dapeng on 2017/3/1.
 */
public class GetTradeInfo extends ApiAuthBean {

	private String tid;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
}
