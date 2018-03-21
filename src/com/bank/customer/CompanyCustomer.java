package com.bank.customer;

import com.finco.customer.ACustomer;
 
public class CompanyCustomer extends ACustomer {

	int noOfEmployee;
	
	public CompanyCustomer(String name, String state, String street,
			String city, String zip, String email,int noOfEmployee) {
		super(name, state, street, city, zip, email);
		// TODO Auto-generated constructor stub
		this.setNoOfEmployee(noOfEmployee);
 		
	}

	private void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	

}
