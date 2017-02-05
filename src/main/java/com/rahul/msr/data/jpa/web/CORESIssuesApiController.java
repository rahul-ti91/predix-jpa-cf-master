package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.CORESIssues;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class CORESIssuesApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String CORESISSUES = "/coresissues";
	public static final String SEARCH_CORESISSUES = "/search";
	public static final String GET_CORESISSUES_BY_ID = CORESISSUES + "/{id}";

	@RequestMapping(value = CORESISSUES, method = RequestMethod.GET)
	public Collection<CORESIssues> customers() throws Exception {
		Collection<CORESIssues> coresissues = customerService.getIssues();
		return coresissues;
	}
	
	@RequestMapping(value = CORESISSUES, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam String issue) {
        return customerService.createIssue(applicationId, applicationName, issue).getId();
    }
}
