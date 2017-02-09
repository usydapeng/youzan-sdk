package org.zunpeng.utils.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.StaxWriter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by dapeng on 16/1/20.
 */
public class CustomStaxDriver extends StaxDriver {

	public CustomStaxDriver() {
		super(new QNameMap(), new NoNameCoder());
	}

	@Override
	public StaxWriter createStaxWriter(XMLStreamWriter out,
	                                   boolean writeStartEndDocument) throws XMLStreamException {

		final XMLStreamWriter writer = out;

		return new StaxWriter(getQnameMap(), out, writeStartEndDocument, isRepairingNamespace(), getNameCoder()) {

			boolean cdata = false;

			boolean globalCdata = false;

			private Class targetClass;

			public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
				super.startNode(name);

				if ("xml".equals(name)) {
					targetClass = clazz;
					Annotation xStreamCDATA = clazz.getAnnotation(XStreamCDATA.class);
					if(xStreamCDATA != null && xStreamCDATA instanceof XStreamCDATA){
						globalCdata = true;
					}
					return;
				}

				cdata = false;

				if(targetClass == null){
					return;
				}

				Field[] fields = targetClass.getDeclaredFields();
				for (Field field : fields) {
					XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);
					String domName = xStreamAlias != null ? xStreamAlias.value() : field.getName();

					if (name.equals(domName)) {
						if(globalCdata){
							cdata = true;
						} else {
							XStreamCDATA xStreamCDATA = field.getAnnotation(XStreamCDATA.class);
							if (xStreamCDATA != null) {
								cdata = true;
							}
						}
						break;
					}
				}
			}


			@Override
			public void setValue(String value) {
				if (cdata) {
					try {
						writer.writeCData(value);
					} catch (XMLStreamException e) {
						e.printStackTrace();
					}
				} else {
					super.setValue(value);
				}

			}

		};
	}
}