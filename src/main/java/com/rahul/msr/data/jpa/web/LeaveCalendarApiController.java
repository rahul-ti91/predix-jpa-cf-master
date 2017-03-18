package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public static final String LEAVECALENDARDATE = "/leavedate";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_LEAVECALENDAR_BY_ID = LEAVECALNEDAR + "/{id}";
	public static final String GET_LEAVECALENDARDATE_BY_ID = LEAVECALENDARDATE + "/{id}";

	@RequestMapping(value = LEAVECALNEDAR, method = RequestMethod.GET)
	public Collection<LeaveCalendar> customers() throws Exception {
		Collection<LeaveCalendar> leaveCalendars = customerService.getLeaveCalendar();
		return leaveCalendars;
	}

	@RequestMapping(value = LEAVECALNEDAR, method = RequestMethod.POST)
	public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId,
			@RequestParam Date leaveEndDate, @RequestParam Date leaveStartDate, @RequestParam String backup,
			@RequestParam String leaveType, @RequestParam String associate) {
		return customerService.createLeaveCalendar(applicationId, applicationName, associate, backup, leaveType,
				leaveEndDate, leaveStartDate).getId();
	}

	@RequestMapping(value = GET_LEAVECALENDAR_BY_ID, method = RequestMethod.PUT)
	public void updateLeave(@PathVariable String id, @RequestBody LeaveCalendar leaveCalendar) {
		// BigInteger id = leaveCalendar.getId();
		System.out.println("Id of the leave : " + id);
		customerService.updateLeave(new BigInteger(id), leaveCalendar);
	}

	@RequestMapping(value = GET_LEAVECALENDARDATE_BY_ID, method = RequestMethod.PUT)
	public void updateLeaveDate(@PathVariable String id, @RequestBody Date date) {
		// BigInteger id = leaveCalendar.getId();
		System.out.println("Id of the leave : " + id);
		customerService.updateLeaveDate(new BigInteger(id), date);
	}

	@RequestMapping(value = GET_LEAVECALENDAR_BY_ID, method = RequestMethod.DELETE)
	public void deleteLeave(@PathVariable String id) {
		customerService.deleteLeave(new BigInteger(id));
	}
}
