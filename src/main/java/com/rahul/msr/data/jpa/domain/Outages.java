package com.rahul.msr.data.jpa.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Outages implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583955757689009987L;

	@Id
	private BigInteger id;
	
	private Date outageDate;
	private String startTime;
	private String duration;
	private String outageType;
	private boolean rcaDone;
	private String outageReason;
	private String applicationName;
	private BigInteger applicationId;
	private Date createdDate;
	
	public Outages() {
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

	public Date getOutageDate() {
		return outageDate;
	}

	public void setOutageDate(Date outageDate) {
		this.outageDate = outageDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getOutageType() {
		return outageType;
	}

	public void setOutageType(String outageType) {
		this.outageType = outageType;
	}

	public boolean isRcaDone() {
		return rcaDone;
	}

	public void setRcaDone(boolean rcaDone) {
		this.rcaDone = rcaDone;
	}

	public String getOutageReason() {
		return outageReason;
	}

	public void setOutageReason(String outageReason) {
		this.outageReason = outageReason;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
