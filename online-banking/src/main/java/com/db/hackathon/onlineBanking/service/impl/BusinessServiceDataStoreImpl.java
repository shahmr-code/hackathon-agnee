package com.db.hackathon.onlineBanking.service.impl;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.hackathon.onlineBanking.repository.CustomerRepository;
import com.db.hackathon.onlineBanking.exception.DatastoreException;
import com.db.hackathon.onlineBanking.model.CustomerDetails;
import com.db.hackathon.onlineBanking.service.BusinessService;

@Service("BusinessServiceDataStore")
public class BusinessServiceDataStoreImpl implements BusinessService {
	
	@Autowired
	CustomerRepository customerRepository;

	public static final String COLLECTION_NAME="customers";  
	 
	@Override
	public String createCustomer(CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
		System.out.println("Customer details:" + customerDetails);
		CustomerDetails resp = customerRepository.save(customerDetails);
		return resp.toString(); 
	}

	@Override
	public CustomerDetails getCustomerDetails(String customerId) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCustomerDetails(CustomerDetails customerDetails)
			throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomerDetails(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public CustomerDetails getCustomerDetails(String customerId) throws InterruptedException, ExecutionException {
		Optional<CustomerDetails> response = customerRepository.findById(customerId);
		  
		
		return response.get();  
	}

	@Override
	public String updateCustomerDetails(CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
		//customerRepository.performTransaction(null)
		return null;
	}

	@Override
	public String deleteCustomerDetails(String customerId) {
		String result = null;
		try {
		if(customerRepository.existsById(customerId)) {
		customerRepository.deleteById(customerId);
		result = "true";
		}
		
	}catch (IllegalArgumentException ex) {
		throw new DatastoreException("Error deleting customer due to Null Customer Id", ex);
	}
		return result;
	}*/
}
