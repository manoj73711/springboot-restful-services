package com.syntel.rest.webservices.springbootrestfulservices.versioning;

public class PersonV1 {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}

}
