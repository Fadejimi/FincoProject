package com.bank.customer;

 import com.finco.customer.ACustomerFactory;
import com.finco.customer.CustomerFactory;
import com.finco.customer.ICustomer;
import com.finco.customer.ICustomerFactory;

public class PersonalCustomerFactory implements ICustomerFactory {

	String name;
	String state;
	String street;
	String city;
	String zip;
	String email;
	String birthDate;
 	
	public PersonalCustomerFactory(String name, String state, String street,
			String city, String zip, String birthDate, String email) {
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.birthDate = birthDate;
		this.email = email;
	}

	@Override
	public ICustomer getCustomer() {
		// TODO Auto-generated method stub
		return new PersonalCustomer(name, state, street, city, zip, birthDate, email);
	}
 
	
	 
}
