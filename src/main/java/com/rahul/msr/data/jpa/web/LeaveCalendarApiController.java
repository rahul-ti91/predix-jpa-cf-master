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

import com.rahul.msr.data.jpa.domain.LeaveCalendar;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class LeaveCalendarApiController {
	@Autowired
	private CORESMSRService customerService;

	public static final String LEAVECALNEDAR = "/leavecalendar";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_LEAVECALENDAR_BY_ID = LEAVECALNEDAR + "/{id}";

	@RequestMapping(value = LEAVECALNEDAR, method = RequestMethod.GET)
	public Collection<LeaveCalendar> customers() throws Exception {
		Collection<LeaveCalendar> leaveCalendars = customerService.getLeaveCalendar();
		return leaveCalendars;
	}
	
	@RequestMapping(value = LEAVECALNEDAR, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam Date leaveEndDate, @RequestParam Date leaveStartDate, @RequestParam String backup, @RequestParam String leaveType) {
        return customerService.createLeaveCalendar(applicationId, applicationName, backup, leaveType, leaveEndDate, leaveStartDate).getId();
    }
}
