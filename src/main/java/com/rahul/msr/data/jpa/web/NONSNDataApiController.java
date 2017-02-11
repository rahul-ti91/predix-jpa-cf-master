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

import com.rahul.msr.data.jpa.domain.NONSNData;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class NONSNDataApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String NONSNDATA = "/nonsndata";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_NONSNDATA_BY_ID = NONSNDATA + "/{id}";

	@RequestMapping(value = NONSNDATA, method = RequestMethod.GET)
	public Collection<NONSNData> customers() throws Exception {
		Collection<NONSNData> nonsndata = customerService.getNONSNData();
		return nonsndata;
	}
	
	@RequestMapping(value = NONSNDATA, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam String nonsndata, @RequestParam Date week) {
        return customerService.createNONSNData(applicationId, applicationName, nonsndata, week).getId();
    }
}
