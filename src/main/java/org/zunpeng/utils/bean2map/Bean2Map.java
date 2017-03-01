package org.zunpeng.utils.bean2map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

/**
 * Created by dapeng on 16/1/19.
 */
public class Bean2Map {

	private static Logger logger = LoggerFactory.getLogger(Bean2Map.class);

	public Map<String, Object> retrieveProp(){
		Class<?> classType = this.getClass();

		List<Field> fieldList = Lists.newArrayList();
		getField(classType, fieldList);

		try {
			Map<String, Object> map = Maps.newHashMap();
			for(Field field : fieldList){
				if(Modifier.isStatic(field.getModifiers())){
					continue;
				}

				FieldExclude fieldExclude = field.getAnnotation(FieldExclude.class);
				if(fieldExclude != null){
					continue;
				}

				field.setAccessible(true);
				Object value = field.get(this);

				if(value != null && StringUtils.isNotBlank(value.toString())){
					XStreamAlias annotation = field.getAnnotation(XStreamAlias.class);
					if(annotation == null){
						map.put(field.getName(), value);
					} else {
						map.put(annotation.value(), value);
					}
				}
			}
			return map;
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			throw new RuntimeException(t.getMessage(), t);
		}
	}

	public Map<String, String> retrieveStringProp(){
		Map<String, Object> map = retrieveProp();

		Map<String, String> processMap = Maps.newHashMap();
		for(String key : map.keySet()){
			Object value = map.get(key);
			if(value == null){
				continue;
			}
			processMap.put(key, value.toString());
		}

		return processMap;
	}

	private void getField(Class clazz, List<Field> fieldList){
		Field[] fields = clazz.getDeclaredFields();
		fieldList.addAll(Lists.newArrayList(fields));

		Class superClazz = clazz.getSuperclass();
		if(!superClazz.equals(Object.class)){
			getField(superClazz, fieldList);
		}
	}
}
