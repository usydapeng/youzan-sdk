package org.zunpeng.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanCopyUtils {

	private static Logger logger = LoggerFactory.getLogger(BeanCopyUtils.class);

	public static <T> T copy(Object source, Class<T> clazz){
		if(source == null){
			throw new NullPointerException("this source is null");
		}
		BeanUtilsBean.getInstance().getConvertUtils().register(false, true, 0);
		T target;
		try {
			target = clazz.newInstance();
			BeanUtils.copyProperties(target, source);
		} catch (Throwable t){
			logger.info(t.getMessage(), t);
			throw new RuntimeException(t.getMessage(), t);
		}
		return target;
	}
}
