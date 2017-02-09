package org.zunpeng.utils;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Created by dapeng on 16/1/19.
 */
public class UuidUtils {

	public static String generate(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String generate28() {
		return new DateTime().toString("yyyyMMddHHmmssSSS") + generate().substring(0, 11);
	}
}
