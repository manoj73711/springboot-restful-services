package com.syntel.rest.webservices.springbootrestfulservices.versioning;

public class PersonV2 {
	
	Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}
	

}