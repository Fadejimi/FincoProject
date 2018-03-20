package com.bank.customer;

 import com.finco.customer.ACustomerFactory;
import com.finco.customer.ICustomer;
import com.finco.customer.ICustomerFactory;

public class CustomerFactory extends ACustomerFactory {


	 String name;
	 String state;
	 String street;
	 String city;
	 String zip;
	 String email;
	 String type;
	 public CustomerFactory (String name, String state, String street,
				String city, String zip, String email,String type) {
			// TODO Auto-generated constructor stub
 		     this.type = type;
			 this.name = name;
			 this.state = state;
			 this.street = street;
		 	 this.city = city;
			 this.zip = zip;
			 this.email = email;
		}

	@Override
	public ICustomer getCustomer() {
		// TODO Auto-generated method stub
		
		if(type.equals("Personal")){
		return new PersonalCustomer(name, state, street, city, zip, email, city);
		}
		else {
			return new CompanyCustomer(name, state, street, city, zip, email, city);
		}
	}
 
	
	 
}
