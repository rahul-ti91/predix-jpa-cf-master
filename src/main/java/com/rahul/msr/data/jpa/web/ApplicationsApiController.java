package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.Applications;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class ApplicationsApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String APPLICATIONS = "/applications";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_APPLICATION_BY_ID = APPLICATIONS + "/{id}";

	@RequestMapping(value = APPLICATIONS, method = RequestMethod.GET)
	public Collection<Applications> customers() throws Exception {
		Collection<Applications> applications = customerService.getApplications();
		return applications;
	}

	@RequestMapping(value = APPLICATIONS, method = RequestMethod.POST)
	public BigInteger addCustomer(@RequestParam String applicationName) {
		return customerService.createApplication(applicationName).getId();
	}

}
