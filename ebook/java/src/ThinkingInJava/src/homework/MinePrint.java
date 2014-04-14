package homework;

import java.util.HashMap;
import java.util.Map;

public class MinePrint {
	private static Map<Class<?>, Object> instanceMap = new HashMap<Class<?>, Object>();

	public static void println(String content, Object a) {
		if (content == null) {
			System.out.println("打印内容: " + a);
		} else {
			System.out.println(content + " : " + a);
		}

	}

	public static void printArray(String content, Object[] a) {
		for (Object b : a) {
			System.out.println(content + " : " + b);
		}
	}

	public static <E> void printClass(Class<E> clazz, Object[] a) {
		E result = (E) instanceMap.get(clazz);
		class_01 x1 = new class_01();
		if (result == null) {

			try {
				result = clazz.newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}

			instanceMap.put(clazz, result);
		}
		println("begin print", result);
	}
}
