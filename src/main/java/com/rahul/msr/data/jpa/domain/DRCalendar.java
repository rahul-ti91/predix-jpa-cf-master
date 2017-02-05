package com.rahul.msr.data.jpa.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DRCalendar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4052826197341625247L;

	@Id
	private BigInteger id;
	
	private Date drCompletionDate;
	private Date upcomingDRDate;
	private String applicationName;
	private BigInteger applicationId;
	private Date creationDate;
	
	public DRCalendar() {
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

	public Date getDrCompletionDate() {
		return drCompletionDate;
	}

	public void setDrCompletionDate(Date drCompletionDate) {
		this.drCompletionDate = drCompletionDate;
	}

	public Date getUpcomingDRDate() {
		return upcomingDRDate;
	}

	public void setUpcomingDRDate(Date upcomingDRDate) {
		this.upcomingDRDate = upcomingDRDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
