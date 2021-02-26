package com.db.hackathon.onlineBanking.model;


import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Entity(name = "Customers")
public class CustomerDetails {
	
	@Id
	private Long id;

	private String firstName;
	private String lastName;
	private String aadharNumber;
	private String dob;
	private String email;
	private String idCardDocument;
	private String pancardNumber;
	private String phoneNumber;
	private String signatureDocument;
	private Address address;
	
	public CustomerDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCardDocument() {
		return idCardDocument;
	}

	public void setIdCardDocument(String idCardDocument) {
		this.idCardDocument = idCardDocument;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSignatureDocument() {
		return signatureDocument;
	}

	public void setSignatureDocument(String signatureDocument) {
		this.signatureDocument = signatureDocument;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", aadharNumber="
				+ aadharNumber + ", dob=" + dob + ", email=" + email + ", idCardDocument=" + idCardDocument
				+ ", pancardNumber=" + pancardNumber + ", phoneNumber=" + phoneNumber + ", signatureDocument="
				+ signatureDocument + ", address=" + address + "]";
	}

}
