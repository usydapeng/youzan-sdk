package org.zunpeng.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by dapeng on 16/3/28.
 */
public class MathUtils {

	public static <T> T multiply(Number number, Number multiples, Class<T> clazz){
		BigDecimal bd1 = new BigDecimal(number.toString());
		BigDecimal bd2 = new BigDecimal(multiples.toString());
		try {
			return convert2Number(bd1.multiply(bd2), clazz);
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage(), t);
		}
	}

	public static <T> T divide(Number number, Number multiples, Class<T> clazz){
		BigDecimal bd1 = new BigDecimal(number.toString());
		BigDecimal bd2 = new BigDecimal(multiples.toString());
		try {
			return convert2Number(bd1.divide(bd2), clazz);
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage(), t);
		}
	}

	public static <T> T subtract(Number minuend, Number subtractor, Class<T> clazz){
		BigDecimal bd1 = new BigDecimal(minuend.toString());
		BigDecimal bd2 = new BigDecimal(subtractor.toString());
		try {
			return convert2Number(bd1.subtract(bd2), clazz);
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage(), t);
		}
	}

	public static <T> T add(Number addend1, Number addend2, Class<T> clazz){
		BigDecimal bd1 = new BigDecimal(addend1.toString());
		BigDecimal bd2 = new BigDecimal(addend2.toString());
		try {
			return convert2Number(bd1.add(bd2), clazz);
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage(), t);
		}
	}

	public static long convert2Cent(double price){
		return multiply(price, 100, Long.class);
	}

	public static double convert2Dollar(long price){
		return divide(price, 100, Double.class);
	}

	private static  <T> T convert2Number(BigDecimal bigDecimal, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		if(clazz.equals(Integer.class)){
			Method method = clazz.getMethod("valueOf", int.class);
			return (T) method.invoke(null, bigDecimal.intValue());
		} else if(clazz.equals(Double.class)){
			Method method = clazz.getMethod("valueOf", double.class);
			return (T) method.invoke(null, bigDecimal.doubleValue());
		} else if(clazz.equals(Long.class)){
			Method method = clazz.getMethod("valueOf", long.class);
			return (T) method.invoke(null, bigDecimal.longValue());
		} else if(clazz.equals(Float.class)){
			Method method = clazz.getMethod("valueOf", float.class);
			return (T) method.invoke(null, bigDecimal.floatValue());
		} else {
			throw new RuntimeException("class is error");
		}
	}
}
