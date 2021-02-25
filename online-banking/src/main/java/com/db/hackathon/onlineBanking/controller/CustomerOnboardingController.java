package com.db.hackathon.onlineBanking.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.onlineBanking.model.CustomerDetails;
import com.db.hackathon.onlineBanking.service.BusinessService;

@RestController
public class CustomerOnboardingController {

	@Autowired
	private BusinessService businessService;

	@PostMapping(value = "/createCustomer", consumes = "application/json")
	public String createCustomer(@RequestBody CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
		return businessService.createCustomer(customerDetails);
	}

	@GetMapping(value = "/getCustomerDetails")
	public CustomerDetails getCustomerDetails(@RequestParam String name) throws InterruptedException, ExecutionException {
		return businessService.getCustomerDetails(name);
	}

	@PutMapping(value = "/updateCustomerDetails", consumes = "application/json")
	public String updateCustomerDetails(@RequestBody CustomerDetails CustomerDetails) throws InterruptedException, ExecutionException {
		return businessService.updateCustomerDetails(CustomerDetails);
	}

	@DeleteMapping(value = "/deleteCustomerDetails")
	public String deleteCustomerDetails(@RequestParam String name) {
		return businessService.deleteCustomerDetails(name);
	}
}
