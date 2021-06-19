package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("reseller")
public class Reseller extends User {

	@Column(unique = true)
	private String code;

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	@Override
	public String toString() {

		return "Reseller [code=" + code + ", getId()=" + getId() + ", getUsername()=" + getUserName() + ", getName()=" + getName() + "]";
	}
}
