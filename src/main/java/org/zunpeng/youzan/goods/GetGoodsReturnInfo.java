package org.zunpeng.youzan.goods;

import com.google.gson.annotations.SerializedName;
import org.zunpeng.youzan.ApiErrorBean;

/**
 * Created by dapeng on 2017/2/9.
 */
public class GetGoodsReturnInfo extends ApiErrorBean {

	private Long cid;

	@SerializedName("promotion_cid")
	private Long promotionCid;

	@SerializedName("origin_price")
	private String originPrice;

	@SerializedName("outer_id")
	private String outerId;

	@SerializedName("buy_quota")
	private Long buyQuota;

	@SerializedName("item_validity_start")
	private Long itemValidityStart;

	@SerializedName("item_validity_end")
	private Long itemValidityEnd;

	@SerializedName("is_listing")
	private Boolean listing;

	@SerializedName("is_lock")
	private Boolean lock;

	private Double price;

	@SerializedName("num_iid")
	private Long numIid;

	private String title;

	private String alias;

	@SerializedName("tag_ids")
	private String tagIds;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getPromotionCid() {
		return promotionCid;
	}

	public void setPromotionCid(Long promotionCid) {
		this.promotionCid = promotionCid;
	}

	public String getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(String originPrice) {
		this.originPrice = originPrice;
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public Long getBuyQuota() {
		return buyQuota;
	}

	public void setBuyQuota(Long buyQuota) {
		this.buyQuota = buyQuota;
	}

	public Long getItemValidityStart() {
		return itemValidityStart;
	}

	public void setItemValidityStart(Long itemValidityStart) {
		this.itemValidityStart = itemValidityStart;
	}

	public Long getItemValidityEnd() {
		return itemValidityEnd;
	}

	public void setItemValidityEnd(Long itemValidityEnd) {
		this.itemValidityEnd = itemValidityEnd;
	}

	public Boolean getListing() {
		return listing;
	}

	public void setListing(Boolean listing) {
		this.listing = listing;
	}

	public Boolean getLock() {
		return lock;
	}

	public void setLock(Boolean lock) {
		this.lock = lock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getNumIid() {
		return numIid;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
}
