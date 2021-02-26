package com.db.hackathon.onlineBanking.repository;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.hackathon.onlineBanking.model.CustomerDetails;

@Repository
public interface CustomerRepository extends DatastoreRepository<CustomerDetails, String>{
	
	/*@Query("select * from  |com.example.Singer| where last_name = @lastName")
	Slice<CustomerDetails> findCustomersByLastName(@Param("lastName") String lastName, Pageable pageable);

	@Query("select * from  |com.example.Singer| where firstBand = @firstName")
	List<CustomerDetails> findCustomersByFirstName(@Param("firstName") String firstName);*/
}