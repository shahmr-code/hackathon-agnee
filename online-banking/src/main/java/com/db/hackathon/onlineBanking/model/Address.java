package com.db.hackathon.onlineBanking.model;

public class Address {

	private String addressLine1;
	private String addressline2;
	private String pinCode;
	private String state;
	private String landmark;
	
	public Address() {
		super();
	}

	public Address(String addressLine1, String addressline2, String pinCode, String state, String landmark) {
		super();
		this.addressLine1 = addressLine1;
		this.addressline2 = addressline2;
		this.pinCode = pinCode;
		this.state = state;
		this.landmark = landmark;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressline2=" + addressline2 + ", pinCode=" + pinCode
				+ ", state=" + state + ", landmark=" + landmark + "]";
	}
}
