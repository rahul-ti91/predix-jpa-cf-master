package com.rahul.msr.data.jpa.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Appreciations implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2671346215341818729L;

	@Id
	private BigInteger id;
	
	private String Appreciation;
	private String applicationName;
	private BigInteger applicationId;
	private Date creationDate;
	
	public Appreciations() {
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
	

	public BigInteger getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(BigInteger applicationId) {
		this.applicationId = applicationId;
	}

	public String getAppreciation() {
		return Appreciation;
	}

	public void setAppreciation(String appreciation) {
		Appreciation = appreciation;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
