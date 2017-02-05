package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.Appreciations;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class AppreciationsApiController {
	
	@Autowired
	private CORESMSRService customerService;

	public static final String APPRECIATIONS = "/appreciations";
	public static final String SEARCH_APPRECIATION = "/search";
	public static final String GET_APPRECIATION_BY_ID = APPRECIATIONS + "/{id}";

	@RequestMapping(value = APPRECIATIONS, method = RequestMethod.GET)
	public Collection<Appreciations> customers() throws Exception {
		Collection<Appreciations> appreciation = customerService.getAppreciations();
		return appreciation;
	}
	
	@RequestMapping(value = APPRECIATIONS, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam String appreciation) {
        return customerService.createAppreciation(applicationName, applicationId, appreciation).getId();
    }
}
