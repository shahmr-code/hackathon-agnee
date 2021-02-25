package com.db.hackathon.repository;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import com.db.hackathon.onlineBanking.model.CustomerDetails;

public interface CustomerRepository extends DatastoreRepository<CustomerDetails, String>{
	
	@Query("select * from  |com.example.Singer| where last_name = @lastName")
	Slice<CustomerDetails> findCustomersByLastName(@Param("lastName") String lastName, Pageable pageable);

	@Query("select * from  |com.example.Singer| where firstBand = @firstName")
	List<CustomerDetails> findCustomersByFirstName(@Param("firstName") String firstName);

	/*
	 * @Override public Iterable<CustomerDetails> findAll(Sort sort) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public Page<CustomerDetails> findAll(Pageable pageable) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends CustomerDetails> S save(S entity) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends CustomerDetails> Iterable<S> saveAll(Iterable<S>
	 * entities) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public Optional<CustomerDetails> findById(String id) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public boolean existsById(String id) { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public Iterable<CustomerDetails> findAll() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Iterable<CustomerDetails> findAllById(Iterable<String> ids)
	 * { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public long count() { // TODO Auto-generated method stub return 0;
	 * }
	 * 
	 * @Override public void deleteById(String id) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void delete(CustomerDetails entity) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll(Iterable<? extends CustomerDetails> entities)
	 * { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public <S extends CustomerDetails> Optional<S> findOne(Example<S>
	 * example) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends CustomerDetails> Iterable<S> findAll(Example<S>
	 * example) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends CustomerDetails> Iterable<S> findAll(Example<S>
	 * example, Sort sort) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends CustomerDetails> Page<S> findAll(Example<S>
	 * example, Pageable pageable) { // TODO Auto-generated method stub return null;
	 * }
	 * 
	 * @Override public <S extends CustomerDetails> long count(Example<S> example) {
	 * // TODO Auto-generated method stub return 0; }
	 * 
	 * @Override public <S extends CustomerDetails> boolean exists(Example<S>
	 * example) { // TODO Auto-generated method stub return false; }
	 * 
	 * @Override public <A> A
	 * performTransaction(Function<DatastoreRepository<CustomerDetails, String>, A>
	 * operations) { // TODO Auto-generated method stub return null; }
	 */

}
