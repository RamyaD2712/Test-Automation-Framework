package com.ui.pojo;

public class User {

	private String emailAddress;
	private String password;
	private String pincode;
	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		//this.pincode = pincode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}*/
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
}
