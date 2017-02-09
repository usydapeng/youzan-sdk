package org.zunpeng.youzan.user;

import com.google.gson.annotations.SerializedName;
import org.zunpeng.youzan.ApiErrorBean;

import java.util.List;

/**
 * Created by dapeng on 2017/2/9.
 */
public class GetUserReturnInfo extends ApiErrorBean {

	private String sex;

	@SerializedName("union_id")
	private String unionId;

	@SerializedName("is_follow")
	private Boolean followed;

	private Long points;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("weixin_openid")
	private String openId;

	@SerializedName("nick")
	private String nickname;

	private String avatar;

	@SerializedName("follow_time")
	private String followTime;

	private String province;

	private String city;

	private List<UserTag> tags;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Boolean getFollowed() {
		return followed;
	}

	public void setFollowed(Boolean followed) {
		this.followed = followed;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFollowTime() {
		return followTime;
	}

	public void setFollowTime(String followTime) {
		this.followTime = followTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<UserTag> getTags() {
		return tags;
	}

	public void setTags(List<UserTag> tags) {
		this.tags = tags;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
