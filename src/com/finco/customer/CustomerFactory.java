package com.finco.customer;


public class CustomerFactory implements ICustomerFactory {

	ICustomerFactory instance  = new CustomerFactory();
	
	
	public ICustomerFactory getInstance() {
		return instance;
	}

	
	@Override
	public ICustomer getCustomer(String name,String state,
			String street,String city,String zip,String email) {
 		return new Customer(name, state, street, city, zip, email);
	}
	

}
