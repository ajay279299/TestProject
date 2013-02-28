package com.domain.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.dto.Issuer;

public class ReflectionManager {
	public static ReflectionManager instance = null;

	private ReflectionManager() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static ReflectionManager getInstance() {
		if (instance == null) {
			synchronized (ReflectionManager.class) {
				if (instance == null) {
					System.out
							.println("getInstance(): First time getInstance was invoked !!!");
					instance = new ReflectionManager();
				}
			}
		}
		return instance;
	}

	public void implementCreationOfAttributesForAnObject(Class className)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException {
		Object labelObject = className.newInstance();

		Field[] declareFieldArray = className.getDeclaredFields();
		for (int i = 0; i < declareFieldArray.length; i++) {
			Field privateStringField = className
					.getDeclaredField(declareFieldArray[i].getName());
			privateStringField.setAccessible(true);

			System.out.println(declareFieldArray[i].getName());

			Object value = privateStringField.get(className.newInstance());
			privateStringField.set(className.newInstance(), value);

		}

	}

	public static String printModifiers(Object object) {
		Class c = object.getClass();
		int m = c.getModifiers();
		String modifiers = "";
		if (Modifier.isPublic(m)) {
			System.out.println("public");
			modifiers = "public";
		} else if (Modifier.isPrivate(m)) {
			System.out.println("private");
			modifiers = "private";
		} else if (Modifier.isAbstract(m)) {
			System.out.println("abstract");
			modifiers = "abstract";
		} else if (Modifier.isFinal(m)) {
			System.out.println("final");
			modifiers = "final";
		}
		return modifiers;

	}

	
	
	
	
	public void addProperty(String name, Object obj) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		String prop = Character.toUpperCase(name.charAt(0)) + name.substring(1);

		String mname = "get" + prop;
		Class[] types = new Class[] {};
		Method getMethod = obj.getClass().getMethod(mname, types);

		mname = "set" + prop;
		types = new Class[] { int.class };
		Method setMethod = obj.getClass().getMethod(mname, types);
	}

}
