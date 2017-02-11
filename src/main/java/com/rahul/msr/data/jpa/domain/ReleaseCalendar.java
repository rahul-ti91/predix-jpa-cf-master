package com.rahul.msr.data.jpa.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReleaseCalendar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6707314592894665297L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	private Date releaseCompletionDate;
	private Date upcomingReleaseDate;
	private String applicationName;
	private BigInteger applicationId;
	private Date creationDate;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getReleaseCompletionDate() {
		return releaseCompletionDate;
	}

	public void setReleaseCompletionDate(Date releaseCompletionDate) {
		this.releaseCompletionDate = releaseCompletionDate;
	}

	public Date getUpcomingReleaseDate() {
		return upcomingReleaseDate;
	}

	public void setUpcomingReleaseDate(Date upcomingReleaseDate) {
		this.upcomingReleaseDate = upcomingReleaseDate;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
