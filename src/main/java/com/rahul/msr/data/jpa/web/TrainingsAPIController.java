package com.rahul.msr.data.jpa.web;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.msr.data.jpa.domain.Trainings;
import com.rahul.msr.data.jpa.service.CORESMSRService;

@Component
@RestController
public class TrainingsAPIController {

	@Autowired
	private CORESMSRService customerService;

	public static final String TRAININGS = "/trainings";
	public static final String SEARCH_CORESISSUES = "/search";
	public static final String GET_CORESISSUES_BY_ID = TRAININGS + "/{id}";

	@RequestMapping(value = TRAININGS, method = RequestMethod.GET)
	public Collection<Trainings> customers() throws Exception {
		Collection<Trainings> coresissues = customerService.getTrainings();
		return coresissues;
	}

	@RequestMapping(value = TRAININGS, method = RequestMethod.POST)
	public BigInteger addCustomer(@RequestParam Integer empId, @RequestParam String empName,
			@RequestParam String trainingName, @RequestParam String trainingType) {
		return customerService.createTraining(empId, empName, trainingName, trainingType).getId();
	}
}
