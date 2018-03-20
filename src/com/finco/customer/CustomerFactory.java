package com.finco.customer;

public class CustomerFactory implements ICustomerFactory {

	@Override
	public Customer getCustomer(String name,String state,
			String street,String city,String zip,String email) {
 		return new Customer(name, state, street, city, zip, email);
	}
	

}
