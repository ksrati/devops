package com.customer.customerManagement.model;


import java.time.LocalDate;




public class Customer {

	private long customer_ID;
	private String first_name;
	private String last_name;
	private LocalDate dob;
	private String address;
	private int phone;


	public long getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(long customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}




	public Customer() {
	}

	public Customer(long customer_ID, String first_name, String last_name, LocalDate dob, String address, int phone
			) {
		super();
		this.customer_ID = customer_ID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		
	}


}
