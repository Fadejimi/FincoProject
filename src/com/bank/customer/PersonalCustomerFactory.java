package com.bank.customer;

 import com.finco.customer.ACustomerFactory;
import com.finco.customer.CustomerFactory;
import com.finco.customer.ICustomer;
import com.finco.customer.ICustomerFactory;

public class PersonalCustomerFactory implements ICustomerFactory {

	static ICustomerFactory instance  = new PersonalCustomerFactory();
	
	private PersonalCustomerFactory() {
	}
	
	public static ICustomerFactory getInstance() {
		return instance;
	}

	@Override
	public ICustomer getCustomer(String name, String state, String street,
			String city, String zip, String email) {
		// TODO Auto-generated method stub
		return  new PersonalCustomer(name, state, street, city, zip, email);
	}
 
	
	 
}
