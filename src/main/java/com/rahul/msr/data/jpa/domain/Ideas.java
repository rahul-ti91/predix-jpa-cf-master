package com.rahul.msr.data.jpa.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ideas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2296512921467835525L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	
	private String ideaState;
	private String ideaDescription;
	private String businessBenefits;
	private String implamentationPlan;
	private String applicationName;
	private BigInteger applicationId;
	private Date creationDate;
	


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

	public String getIdeaState() {
		return ideaState;
	}

	public void setIdeaState(String ideaState) {
		this.ideaState = ideaState;
	}

	public String getIdeaDescription() {
		return ideaDescription;
	}

	public void setIdeaDescription(String ideaDescription) {
		this.ideaDescription = ideaDescription;
	}

	public String getBusinessBenefits() {
		return businessBenefits;
	}

	public void setBusinessBenefits(String businessBenefits) {
		this.businessBenefits = businessBenefits;
	}

	public String getImplamentationPlan() {
		return implamentationPlan;
	}

	public void setImplamentationPlan(String implamentationPlan) {
		this.implamentationPlan = implamentationPlan;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
