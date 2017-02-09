package org.zunpeng.utils.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by dapeng on 2017/1/19.
 */
public class RetrofitUtils {

	private static Logger logger = LoggerFactory.getLogger(RetrofitUtils.class);

	private static Retrofit instance = null;

	private static Gson gson = new GsonBuilder()
//			.setDateFormat("yyyy-MM-dd hh:mm:ss")
			.create();

	public static Retrofit getInstance(String baseUrl){
		if (instance == null){
			synchronized (RetrofitUtils.class){
				if (instance == null){
					instance = build(baseUrl);
				}
			}
		}
		return instance;
	}

	public static <T> T createService(Retrofit retrofit, Class<T> clazz){
		return retrofit.create(clazz);
	}

	public static String stringInfo(Call<ResponseBody> call) throws java.io.IOException {
		Response<ResponseBody> response = call.execute();

		if(response.isSuccessful()){
			String responseContent = response.body().string();
			logger.info("---------------- success: " + responseContent);
			return responseContent;
		} else {
			logger.info("---------------- http status code:\t" + response.code());
			logger.info("---------------- http response message:\t" + response.message());
			logger.info("---------------- http error body:\t" + response.errorBody().string());
			throw new RuntimeException("---------------- request error");
		}
	}

	public static <T> T info(Call<T> call) throws java.io.IOException {
		Response<T> response = call.execute();

		if(response.isSuccessful()){
			T t = response.body();
			logger.info("---------------- success: " + gson.toJson(t));
			return t;
		} else {
			logger.info("---------------- http status code:\t" + response.code());
			logger.info("---------------- http response message:\t" + response.message());
			logger.info("---------------- http error body:\t" + response.errorBody().string());
			throw new RuntimeException("---------------- request error");
		}
	}

	private static Retrofit build(String baseUrl){
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.readTimeout(5000, TimeUnit.MILLISECONDS)
				.connectTimeout(5000,TimeUnit.MILLISECONDS)
				//不记录请求cookie
//				.cookieJar(new CustomCookieJar())
				.build();

		return new Retrofit.Builder()
				.baseUrl(baseUrl)
				.client(okHttpClient)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
	}
}
