package com.bank.app;

 import com.finco.framework.ACustomer;
 
public class PersonalCustomer extends ACustomer{

	String birthDate;

	public PersonalCustomer(String name, String state, String street, String city,
			String zip,  String birthDate, String email) {
		super(name, state, street, city, zip, email);
		// TODO Auto-generated constructor stub
		this.setBirthDate( birthDate);
	}
	
	private void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	 

}
