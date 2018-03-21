package com.bank.customer;

import com.finco.account.IAccount;
import com.finco.customer.ACustomer;
import com.finco.customer.ICustomer;

class PersonalCustomer extends ACustomer{

	String birthDate;

	PersonalCustomer(String name, String state, String street, String city,
			String zip,  String birthDate, String email) {
		super(name, state, street, city, zip, email);
		// TODO Auto-generated constructor stub
		this.setBirthDate( birthDate);
	}
	
	private void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	 

}
