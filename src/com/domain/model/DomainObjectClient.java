package com.domain.model;

public class DomainObjectClient {

	public static ReflectionManager reflectionManagerInstance = ReflectionManager
			.getInstance();

	public void createAttributesOfDomainObject(Class className)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException {
		reflectionManagerInstance
				.implementCreationOfAttributesForAnObject(className);
	}

	public void createMethodsOfDomainObject() {

	}

	public void implementVisibilityOnMethodsOfDomainObject() {

	}

}
