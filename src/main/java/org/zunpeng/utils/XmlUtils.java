package org.zunpeng.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zunpeng.utils.xstream.CustomStaxDriver;

/**
 * Created by dapeng on 16/1/20.
 */
@SuppressWarnings("unchecked")
public class XmlUtils {

	private static Logger logger = LoggerFactory.getLogger(XmlUtils.class);

	public static String toXml(Object object){
		XStream xStream = new XStream(new CustomStaxDriver());
		xStream.autodetectAnnotations(true);
		xStream.processAnnotations(object.getClass());
		String contentXML = xStream.toXML(object);

		try {
			Document document = DocumentHelper.parseText(contentXML);
			return document.getRootElement().asXML();
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return null;
		}
	}

	public static <T> T toBean(String fromXml, Class<?> clazz){
		XStream xStream = new XStream(new CustomStaxDriver());
		xStream.autodetectAnnotations(true);
		xStream.processAnnotations(clazz);

		try {
			Object instance = clazz.newInstance();
			xStream.fromXML(fromXml, instance);
			return (T) instance;
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return null;
		}
	}

	public static String toJson(Object object){
		XStream xStream = new XStream(new JettisonMappedXmlDriver());
		return xStream.toXML(object);
	}
}
