package com.finco.customer;

public interface ICustomerFactory {
public ICustomer getCustomer(String name,String state,
		String street,String city,String zip,String email);
}
