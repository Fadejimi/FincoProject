package com.bank.customer;

 import com.finco.customer.ACustomerFactory;
import com.finco.customer.CustomerFactory;
import com.finco.customer.ICustomer;
import com.finco.customer.ICustomerFactory;

public class CompanyCustomerFactory implements ICustomerFactory {
	String name;
	String state;
	String street;
	String city;
	String zip;
	String email;
	int noOfEmployee;
 	
	public CompanyCustomerFactory(String name, String state, String street,
			String city, String zip, int noOfEmployee, String email) {
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.noOfEmployee = noOfEmployee;
		this.email = email;
	}

	@Override
	public ICustomer getCustomer() {
		// TODO Auto-generated method stub
		return new CompanyCustomer(name, state, street, city, zip, email, noOfEmployee);
	}
 
	
	 
}
