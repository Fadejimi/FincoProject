package com.bank.app;

import com.finco.framework.CustomerFactory;
import com.finco.framework.ICustomer;

public class BankCustomerFactory extends CustomerFactory{
	
	private ICustomer customer;
	
	public BankCustomerFactory() {
	}
	
	public BankCustomerFactory(String name,String state,
			String street,String city,String zip,String email, String birthDate) {
		customer = new PersonalCustomer(name, state, street, city, zip, birthDate, email);
	}
	
	public BankCustomerFactory(String name,String state,
			String street,String city,String zip,String email, int noOfEmployees) {
		customer = new CompanyCustomer(name, state, street, city, zip, email, noOfEmployees);
	} 
	
	public ICustomer getCustomer() {
		return customer;
	}

}
