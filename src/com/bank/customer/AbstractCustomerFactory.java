package com.bank.customer;

import com.bank.account.SavingsAccountFactory;
import com.finco.customer.ICustomerFactory;

public class AbstractCustomerFactory {
	
private static ICustomerFactory customerFactory = null;
	
	private AbstractCustomerFactory() {
		
	}
	
	public static ICustomerFactory getFactory(String type) {
		if(type.equals("personal")) {
			customerFactory = PersonalCustomerFactory.getInstance();
		} else if(type.equals("company")) {
			customerFactory = CompanyCustomerFactory.getInstance();
		}
		return customerFactory;
	}


}
