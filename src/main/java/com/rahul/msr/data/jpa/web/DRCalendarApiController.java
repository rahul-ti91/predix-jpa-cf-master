package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.DRCalendar;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class DRCalendarApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String DRCALNEDAR = "/drcalendar";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_DRCALENDAR_BY_ID = DRCALNEDAR + "/{id}";

	@RequestMapping(value = DRCALNEDAR, method = RequestMethod.GET)
	public Collection<DRCalendar> customers() throws Exception {
		Collection<DRCalendar> drcalendar = customerService.getDRCalendar();
		return drcalendar;
	}
	
	@RequestMapping(value = DRCALNEDAR, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam Date drCompletionDate, @RequestParam Date upcomingDRDate) {
        return customerService.createDRCalendar(applicationId, applicationName, drCompletionDate, upcomingDRDate).getId();
    }
}
