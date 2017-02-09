package org.zunpeng.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dapeng on 16/1/20.
 */
public class Sha1Utils {

	private static Logger logger = LoggerFactory.getLogger(Sha1Utils.class);

	public static String sha1(String input) throws NoSuchAlgorithmException {
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA-1");
			byte[] result = mDigest.digest(input.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}

			return sb.toString();
		} catch (Throwable t){
			logger.error(t.getMessage(), t);
			return null;
		}
	}

	public static String encode(String input) {
		try {
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(input.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return null;
		}
	}
}
