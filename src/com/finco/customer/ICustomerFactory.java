package com.finco.customer;

public interface ICustomerFactory {
public Customer getCustomer(String type,String name, String state, String street, String city,
		String zip, String email);
}
