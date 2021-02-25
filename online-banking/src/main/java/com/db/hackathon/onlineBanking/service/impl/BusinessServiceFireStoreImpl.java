package com.db.hackathon.onlineBanking.service.impl;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.db.hackathon.onlineBanking.model.CustomerDetails;
import com.db.hackathon.onlineBanking.service.BusinessService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service("BusinessServiceFireStore")
public class BusinessServiceFireStoreImpl implements BusinessService {

	public static final String COLLECTION_NAME="customers";  
	 
	@Override
	public String createCustomer(CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
		System.out.println("Customer details:" + customerDetails);
		Firestore dbFirestore = FirestoreClient.getFirestore();  
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(customerDetails.getFirstName()).set(customerDetails);  
		return collectionsApiFuture.get().getUpdateTime().toString(); 
	}

	@Override
	public CustomerDetails getCustomerDetails(String customerId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();  
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(customerId);  
		ApiFuture<DocumentSnapshot> future = documentReference.get();  
		DocumentSnapshot document = future.get();  
		CustomerDetails customerDetails = null;  
		if(document.exists()) {  
			customerDetails = document.toObject(CustomerDetails.class); 
		}
		return customerDetails;  
	}

	@Override
	public String updateCustomerDetails(CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();  
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(customerDetails.getFirstName()).set(customerDetails);  
		return collectionsApiFuture.get().getUpdateTime().toString();  
	}

	@Override
	public String deleteCustomerDetails(String customerId) {
		 Firestore dbFirestore = FirestoreClient.getFirestore();  
		 ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(customerId).delete();  
		 return "Document with Patient ID "+customerId+" has been deleted";  
	}

}
