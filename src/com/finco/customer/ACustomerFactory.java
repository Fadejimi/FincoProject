package com.finco.customer;


public abstract class ACustomerFactory implements ICustomerFactory {
	public abstract ICustomer getCustomer(String name,String state,
			String street,String city,String zip,String email);
	

}
