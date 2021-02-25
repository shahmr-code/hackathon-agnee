package com.db.hackathon.onlineBanking.model;

public class CustomerDetails {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String aadharNumber;
	private String pancardNumber;
	private String Dob;
	private String email;
	private Address address;
	private String idCardDocument;
	private String signatureDocument;
	
	public CustomerDetails() {
		super();
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIdCardDocument() {
		return idCardDocument;
	}

	public void setIdCardDocument(String idCardDocument) {
		this.idCardDocument = idCardDocument;
	}

	public String getSignatureDocument() {
		return signatureDocument;
	}

	public void setSignatureDocument(String signatureDocument) {
		this.signatureDocument = signatureDocument;
	}

	@Override
	public String toString() {
		return "CustomerDetails [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", aadharNumber=" + aadharNumber + ", pancardNumber=" + pancardNumber + ", Dob=" + Dob + ", email="
				+ email + ", address=" + address + ", idCardDocument=" + idCardDocument + ", signatureDocument="
				+ signatureDocument + "]";
	}
}
