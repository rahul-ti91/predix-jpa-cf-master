package com.rahul.msr.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.MSRReport;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@ComponentScan
@RestController
public class MSRReportApiController {
	@Autowired
	private CORESMSRService customerService;

	public static final String REPORT_GENERATOR = "/report";

	// public static final String SEARCH_APPLICATION = "/search";
	// public static final String GET_LEAVECALENDAR_BY_ID = LEAVECALNEDAR +
	// "/{id}";

	@RequestMapping(value = REPORT_GENERATOR, method = RequestMethod.GET)
	public MSRReport addCustomer(@RequestParam int month) {
		return customerService.getMSRReport(month);
	}

}
