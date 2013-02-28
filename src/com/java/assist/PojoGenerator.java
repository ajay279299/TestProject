package com.java.assist;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class PojoGenerator {

	public static Class generate(String className,
			Map<String, Class<?>> properties) throws NotFoundException,
			CannotCompileException {

		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);

		// add this to define a super class to extend
		// cc.setSuperclass(resolveCtClass(MySuperClass.class));

		// add this to define an interface to implement
		cc.addInterface(resolveCtClass(Serializable.class));

		for (@SuppressWarnings("rawtypes")
		Entry entry : properties.entrySet()) {
			cc.addField(new CtField(resolveCtClass((Object) entry.getValue()),
					(String) entry.getKey(), cc));

			// add getter
			cc.addMethod(generateGetter(cc, entry.getKey(), entry.getValue()));

			// add setter
			cc.addMethod(generateSetter(cc, entry.getKey(), entry.getValue()));
		}

		return cc.toClass();
	}

	private static CtMethod generateGetter(CtClass declaringClass,
			Object object, Object object2) throws CannotCompileException {

		String getterName = "get"
				+ ((String) object).substring(0, 1).toUpperCase()
				+ ((String) object).substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public ").append(((CtClass) object2).getName()).append(" ")
				.append(getterName).append("(){").append("return this.")
				.append(object).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	private static CtMethod generateSetter(CtClass declaringClass,
			Object object, Object object2) throws CannotCompileException {

		String setterName = "set"
				+ ((String) object).substring(0, 1).toUpperCase()
				+ ((String) object).substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public void ").append(setterName).append("(")
				.append(((CtClass) object2).getName()).append(" ")
				.append(object).append(")").append("{").append("this.")
				.append(object).append("=").append(object).append(";")
				.append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	private static CtClass resolveCtClass(Object object)
			throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		return pool.get(((CtClass) object).getName());
	}

	public static void main(String[] args) throws NotFoundException,
			CannotCompileException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			SecurityException, InvocationTargetException, NoSuchMethodException {

		Map<String, Class<?>> props = new HashMap<String, Class<?>>();
		props.put("foo", Integer.class);
		props.put("bar", String.class);

		Class<?> clazz = PojoGenerator.generate(
				"net.javaforge.blog.javassist.Pojo$Generated", props);

		Object obj = clazz.newInstance();

		System.out.println("Clazz: " + clazz);
		System.out.println("Object: " + obj);
		System.out.println("Serializable? " + (obj instanceof Serializable));

		for (final Method method : clazz.getDeclaredMethods()) {
			System.out.println(method);
		}

		// set property "bar"
		clazz.getMethod("setBar", String.class).invoke(obj, "Hello World!");

		// get property "bar"
		String result = (String) clazz.getMethod("getBar").invoke(obj);
		System.out.println("Value for bar: " + result);

	}

}
