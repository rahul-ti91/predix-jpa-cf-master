package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.WeeklyHighlights;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@Component
@RestController
public class WeeklyHighlightsAPIController {

	@Autowired
	private CORESMSRService customerService;

	public static final String WEEKLY = "/weeklyhighlights";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_NONSNDATA_BY_ID = WEEKLY + "/{id}";

	@RequestMapping(value = WEEKLY, method = RequestMethod.GET)
	public Collection<WeeklyHighlights> customers() throws Exception {
		Collection<WeeklyHighlights> nonsndata = customerService.getWeeklyHighlights();
		return nonsndata;
	}

	@RequestMapping(value = WEEKLY, method = RequestMethod.POST)
	public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId,
			@RequestParam String highlights, @RequestParam Date week) {
		return customerService.createWeeklyHighlights(applicationId, applicationName, highlights, week).getId();
	}
}
