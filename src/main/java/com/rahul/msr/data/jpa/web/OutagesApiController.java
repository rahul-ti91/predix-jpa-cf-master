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

import com.rahul.msr.data.jpa.domain.Outages;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class OutagesApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String OUTAGES = "/outages";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_DRCALENDAR_BY_ID = OUTAGES + "/{id}";

	@RequestMapping(value = OUTAGES, method = RequestMethod.GET)
	public Collection<Outages> customers() throws Exception {
		Collection<Outages> outages = customerService.getOutages();
		return outages;
	}
	
	@RequestMapping(value = OUTAGES, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam String duration, @RequestParam boolean rcaDone, @RequestParam String outageType, @RequestParam String outageReason, @RequestParam Date outageDate, @RequestParam String startTime) {
        return customerService.createOutage(applicationId, applicationName, duration, rcaDone, outageType, outageDate, outageReason, startTime).getId();
    }
}
