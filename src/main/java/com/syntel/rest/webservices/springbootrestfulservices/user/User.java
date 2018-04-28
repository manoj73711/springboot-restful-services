package com.syntel.rest.webservices.springbootrestfulservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="All the details about the user")
public class User {
	
	private Integer id;
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name shoud have atleast 2 characters")
	private String name;
	@Past
	@ApiModelProperty(notes="Birthdate should be past")
	private Date birth_date;
	
	public User() {

	}
	public User(Integer id, String name, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.birth_date = birth_date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
}
