package com.bank.app;

import com.finco.framework.ICustomer;
import com.finco.framework.ICustomerFactory;

public class PersonalCustomerFactory implements ICustomerFactory {

	String name;
	String state;
	String street;
	String city;
	String zip;
	String email;
	String birthDate;
 	
	public PersonalCustomerFactory(String name, String state, String street,
			String city, String zip, String birthDate, String email) {
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.birthDate = birthDate;
		this.email = email;
	}

	@Override
	public ICustomer getCustomer() {
		// TODO Auto-generated method stub
		return new PersonalCustomer(name, state, street, city, zip, birthDate, email);
	}
 
	
	 
}
