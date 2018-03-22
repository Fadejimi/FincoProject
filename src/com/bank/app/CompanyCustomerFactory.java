package com.bank.app;

import com.finco.framework.ICustomer;
import com.finco.framework.ICustomerFactory;

public class CompanyCustomerFactory implements ICustomerFactory {
	String name;
	String state;
	String street;
	String city;
	String zip;
	String email;
	int noOfEmployee;
 	
	public CompanyCustomerFactory(String name, String state, String street,
			String city, String zip, int noOfEmployee, String email) {
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.noOfEmployee = noOfEmployee;
		this.email = email;
	}

	@Override
	public ICustomer getCustomer() {
		// TODO Auto-generated method stub
		return new CompanyCustomer(name, state, street, city, zip, email, noOfEmployee);
	}
 
	
	 
}
