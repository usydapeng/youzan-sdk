package org.zunpeng.youzan.order;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dapeng on 2017/3/1.
 */
public class GetTradeReturnInfo {

	private Long num;

	private String status;

	@SerializedName("status_str")
	private String statusStr;

	@SerializedName("created")
	private String createTime;

	@SerializedName("buyer_area")
	private String buyerArea;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getBuyerArea() {
		return buyerArea;
	}

	public void setBuyerArea(String buyerArea) {
		this.buyerArea = buyerArea;
	}
}
