package com.ref;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

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

	public void implementCreationOfAttributeForAnObject(Class className)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException {
		Field[] declareFieldArray = className.getDeclaredFields();
		for (int i = 0; i < declareFieldArray.length; i++) {
			Field privateStringField = className
					.getDeclaredField(declareFieldArray[i].getName());
			privateStringField.setAccessible(true);

			Object value = privateStringField.get(className.newInstance());
			privateStringField.set(className.newInstance(), value);

		}

	}

	public void getClassAtRuntimeUsingReflection(Class className)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException {

		System.out
				.println("**************************************************************");

		Field[] declareFieldArray = className.getDeclaredFields();
		for (int i = 0; i < declareFieldArray.length; i++) {
			Field privateStringField = className
					.getDeclaredField(declareFieldArray[i].getName());
			privateStringField.setAccessible(true);
			Type type = privateStringField.getType();
			int modifiersInIntegerValue = privateStringField.getModifiers();
			System.out.println("Field Name:->" + declareFieldArray[i].getName()
					+ ", type:->" + type + ", and modifiers:-> "
					+ modifiersInIntegerValue);

		}
		System.out
				.println("**************************************************************");

	}

}
