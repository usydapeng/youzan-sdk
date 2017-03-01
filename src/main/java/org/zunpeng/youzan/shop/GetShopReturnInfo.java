package org.zunpeng.youzan.shop;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dapeng on 2017/3/1.
 */
public class GetShopReturnInfo {

	private String sid;

	private String name;

	private String logo;

	private String url;

	@SerializedName("physical_url")
	private String physicalUrl;

	@SerializedName("cert_type")
	private Long certType;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhysicalUrl() {
		return physicalUrl;
	}

	public void setPhysicalUrl(String physicalUrl) {
		this.physicalUrl = physicalUrl;
	}

	public Long getCertType() {
		return certType;
	}

	public void setCertType(Long certType) {
		this.certType = certType;
	}
}
