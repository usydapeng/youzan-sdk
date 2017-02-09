package org.zunpeng.utils;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by dapeng on 16/1/15.
 */
public class ImageDownloadUtils {

	private static Logger logger = LoggerFactory.getLogger(ImageDownloadUtils.class);

	private static boolean download(String imageDownloadPath, String imageUrl, String filename){
		try {
			Request request = new Request.Builder()
					.addHeader("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1")
					.addHeader("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.addHeader("Accept-Encoding", "*")
					.url(imageUrl)
					.build();

			OkHttpClient client = new OkHttpClient();
			Response response = client.newCall(request).execute();
			InputStream inputStream = response.body().byteStream();
			FileOutputStream outputStream = new FileOutputStream(imageDownloadPath + "/" + filename);
			byte[] buffer = new byte[1024];
			int temp;
			while ((temp = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, temp);
				outputStream.flush();
			}
			outputStream.close();
			inputStream.close();

			return true;
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return false;
		}
	}

}
