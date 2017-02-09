package org.zunpeng.youzan.goods;

import com.google.gson.annotations.SerializedName;
import org.zunpeng.youzan.ApiAuthBean;

/**
 * Created by dapeng on 2017/2/9.
 */
public class GetGoodsInfo extends ApiAuthBean {

	@SerializedName("outer_id")
	private String outerId;

	private String fields;

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
}
