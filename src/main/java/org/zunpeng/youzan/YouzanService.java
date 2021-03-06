package org.zunpeng.youzan;

import okhttp3.ResponseBody;
import org.zunpeng.youzan.goods.GetGoodsReturnInfo;
import org.zunpeng.youzan.order.GetTradeReturnInfo;
import org.zunpeng.youzan.shop.GetShopReturnInfo;
import org.zunpeng.youzan.user.GetUserReturnInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Created by dapeng on 2017/2/9.
 */
public interface YouzanService {

	@POST("oauth/token")
	Call<GetAccessTokenReturnInfo> accessToken(@QueryMap Map<String, String> requestParams);

	@GET("/api/oauthentry/{method}/{version}/get")
	Call<ResponseBody> invokeApi_get(@Path("method") String method, @Path("version") String version, @QueryMap Map<String, String> requestParams);

	//2.0.0
	@GET("/api/oauthentry/kdt.trade/{version}/get")
	Call<ApiReturnInfo<GetTradeReturnInfo>> getTradeInfo(@Path("version") String version, @QueryMap Map<String, String> requestParams);

	@GET("/api/oauthentry/kdt.item/{version}/get")
	Call<ApiReturnInfo<GetGoodsReturnInfo>> getGoodsInfo(@Path("version") String version, @QueryMap Map<String, String> requestParams);

	@GET("/api/oauthentry/kdt.users.weixin.follower/{version}/get")
	Call<ApiReturnInfo<GetUserReturnInfo>> getUserInfo(@Path("version") String version, @QueryMap Map<String, String> requestParams);

	@GET("/api/oauthentry/kdt.shop.basic/{version}/get")
	Call<ApiPartialReturnInfo<GetShopReturnInfo>> getShopInfo(@Path("version") String version, @QueryMap Map<String, String> requestParams);

}
