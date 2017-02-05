package com.rahul.msr.data.jpa.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Applications implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2039132016004929928L;

	@Id
	private BigInteger id;
	
	private String applicationName;
	
	public Applications() {
		// TODO Auto-generated constructor stub
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	
}
