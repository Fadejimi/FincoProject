package com.bank.customer;

 import com.finco.customer.ACustomerFactory;
import com.finco.customer.CustomerFactory;
import com.finco.customer.ICustomer;
import com.finco.customer.ICustomerFactory;

public class CompanyCustomerFactory implements ICustomerFactory {

	static ICustomerFactory instance  = new CompanyCustomerFactory();
	
	private CompanyCustomerFactory() {
	}
	
	public static ICustomerFactory getInstance() {
		return instance;
	}

	@Override
	public ICustomer getCustomer(String name, String state, String street,
			String city, String zip, String email) {
		// TODO Auto-generated method stub
		return  new CompanyCustomer(name, state, street, city, zip, email);
	}
 
	
	 
}
