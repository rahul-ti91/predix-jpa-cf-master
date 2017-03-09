package com.rahul.msr.data.jpa.domain;

import java.util.List;

public class MSRReport {
	private List<CloseActivity> closeActivities;
	private List<Appreciations> appreciations;
	private List<CORESIssues> coresIssues;
	private List<DRCalendar> drcalendars;
	private List<Ideas> ideas;
	private List<NONSNData> nonsnDatas;
	private List<Outages> outages;
	private List<ReleaseCalendar> releaseCalendars;
	private List<Trainings> trainings;
	
	public List<CloseActivity> getCloseActivities() {
		return closeActivities;
	}
	public void setCloseActivities(List<CloseActivity> closeActivities) {
		this.closeActivities = closeActivities;
	}
	public List<Appreciations> getAppreciations() {
		return appreciations;
	}
	public void setAppreciations(List<Appreciations> appreciations) {
		this.appreciations = appreciations;
	}
	public List<CORESIssues> getCoresIssues() {
		return coresIssues;
	}
	public void setCoresIssues(List<CORESIssues> coresIssues) {
		this.coresIssues = coresIssues;
	}
	public List<DRCalendar> getDrcalendars() {
		return drcalendars;
	}
	public void setDrcalendars(List<DRCalendar> drcalendars) {
		this.drcalendars = drcalendars;
	}
	public List<Ideas> getIdeas() {
		return ideas;
	}
	public void setIdeas(List<Ideas> ideas) {
		this.ideas = ideas;
	}
	public List<NONSNData> getNonsnDatas() {
		return nonsnDatas;
	}
	public void setNonsnDatas(List<NONSNData> nonsnDatas) {
		this.nonsnDatas = nonsnDatas;
	}
	public List<Outages> getOutages() {
		return outages;
	}
	public void setOutages(List<Outages> outages) {
		this.outages = outages;
	}
	public List<ReleaseCalendar> getReleaseCalendars() {
		return releaseCalendars;
	}
	public void setReleaseCalendars(List<ReleaseCalendar> releaseCalendars) {
		this.releaseCalendars = releaseCalendars;
	}
	public List<Trainings> getTrainings() {
		return trainings;
	}
	public void setTrainings(List<Trainings> trainings) {
		this.trainings = trainings;
	}
	
}
