package com.finco.framework;


public abstract class ACustomerFactory implements ICustomerFactory {
	public abstract ICustomer getCustomer(String name,String state,
			String street,String city,String zip,String email);
}
