package com.finco.customer;

public class CustomerFactory implements ICustomerFactory {

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return new Customer(null, null, null, null, null, null);
	}
	

}
