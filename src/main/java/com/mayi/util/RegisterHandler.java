package com.mayi.util;

import java.util.HashMap;
import java.util.Map;

import com.mayi.annotation.Component;

public class RegisterHandler {

	public static Map<String, Object> beans = new HashMap<String, Object>();

	public static void registerBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (ClassLoaderHandler.classNames.size() == 0) {
			return;
		}

		for (String className : ClassLoaderHandler.classNames) {
			Class<?> clazz = Class.forName(className.replace(".class", ""));
			System.out.println("clazz:" + clazz.getName());
			if (clazz.isAnnotationPresent(Component.class)) {
				Object obj = clazz.newInstance();
				String key = clazz.getAnnotation(Component.class).value();
				beans.put(key == null || key.equals("")
						? clazz.getName().substring(key.lastIndexOf(".") + 1).substring(0, 1).toLowerCase() : key, obj);
			}
		}
		System.out.println(beans);
	}

}
