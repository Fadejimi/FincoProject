package com.finco.customer;


public class CustomerFactory implements ICustomerFactory {

	 String name;
	 String state;
	 String street;
 	 String city;
	 String zip;
	 String email;
	
	
	private CustomerFactory() {
	}


	
	@Override
	public ICustomer getCustomer() {
 		return new Customer(name, state, street, city, zip, email);
	}
	

}
