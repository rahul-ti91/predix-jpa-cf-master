package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.CloseActivity;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class CloseActivityApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String CLOSEACTIVITY = "/closeactivity";
	public static final String SEARCH_CLOSEACTIVITY = "/search";
	public static final String GET_CLOSEACTIVITY_BY_ID = CLOSEACTIVITY + "/{id}";

	@RequestMapping(value = CLOSEACTIVITY, method = RequestMethod.GET)
	public Collection<CloseActivity> customers() throws Exception {
		Collection<CloseActivity> closeActivity = customerService.getCloseActivities();
		return closeActivity;
	}
	
	@RequestMapping(value = CLOSEACTIVITY, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam String description, @RequestParam String frequency, @RequestParam Date activityDate) {
        return customerService.createCloseActivity(activityDate, applicationId, applicationName, description, frequency).getId();
    }
}
