package com.db.hackathon.onlineBanking.service;

import java.util.concurrent.ExecutionException;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.db.hackathon.onlineBanking.model.CustomerDetails;

public interface BusinessService {
	
	public String createCustomer(CustomerDetails customerDetails) throws InterruptedException, ExecutionException;
	public CustomerDetails getCustomerDetails(String customerId) throws InterruptedException, ExecutionException;
	public String updateCustomerDetails(CustomerDetails customerDetails) throws InterruptedException, ExecutionException;
	public String deleteCustomerDetails(String customerId);
}
