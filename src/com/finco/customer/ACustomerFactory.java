package com.finco.customer;


public abstract class ACustomerFactory implements ICustomerFactory {
	@Override
	public abstract ICustomer getCustomer();
	

}
