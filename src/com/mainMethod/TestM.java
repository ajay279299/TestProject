package com.mainMethod;

import com.domain.model.DomainObjectClient;
import com.dto.Issuer;

public class TestM {

	/**
	 * @param args
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
		DomainObjectClient domainObject = new DomainObjectClient();
		domainObject.createAttributesOfDomainObject(Issuer.class);
	}

}
