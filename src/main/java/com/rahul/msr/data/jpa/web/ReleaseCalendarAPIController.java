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

import com.rahul.msr.data.jpa.domain.ReleaseCalendar;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@Component
@RestController
public class ReleaseCalendarAPIController {

	@Autowired
	private CORESMSRService customerService;

	public static final String RELEASECALENDAR = "/releasecalendar";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_DRCALENDAR_BY_ID = RELEASECALENDAR + "/{id}";

	@RequestMapping(value = RELEASECALENDAR, method = RequestMethod.GET)
	public Collection<ReleaseCalendar> customers() throws Exception {
		Collection<ReleaseCalendar> drcalendar = customerService.getReleaseCalendar();
		return drcalendar;
	}

	@RequestMapping(value = RELEASECALENDAR, method = RequestMethod.POST)
	public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId,
			@RequestParam Date releaseCompletionDate, @RequestParam Date upcomingReleaseDate) {
		return customerService
				.createReleaseCalendar(applicationId, applicationName, releaseCompletionDate, upcomingReleaseDate)
				.getId();
	}
}
