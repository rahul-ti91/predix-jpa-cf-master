package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.Ideas;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class IdeasApiController {

	@Autowired
	private CORESMSRService customerService;

	public static final String IDEAS = "/ideas";
	public static final String SEARCH_APPLICATION = "/search";
	public static final String GET_IDEAS_BY_ID = IDEAS + "/{id}";

	@RequestMapping(value = IDEAS, method = RequestMethod.GET)
	public Collection<Ideas> customers() throws Exception {
		Collection<Ideas> ideas = customerService.getIdeas();
		return ideas;
	}
	
	@RequestMapping(value = IDEAS, method = RequestMethod.POST)
    public BigInteger addCustomer(@RequestParam String applicationName, @RequestParam BigInteger applicationId, @RequestParam String businessBenefits, @RequestParam String ideaDescription, @RequestParam String ideaState, @RequestParam String implamentationPlan) {
        return customerService.createIdeas(applicationId, applicationName, businessBenefits, ideaDescription, ideaState, implamentationPlan).getId();
    }
}
