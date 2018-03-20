package com.finco.account;

import com.finco.customer.ICustomer;

public class AccountFactory implements IAccountFactory{
	
	private static IAccountFactory myInstance = new AccountFactory();
	
	private AccountFactory() {
		
	}
	
	public static IAccountFactory getInstance() {
		return myInstance;
	}

	@Override
	public IAccount getAccount(ICustomer customer, String accountNumber, double balance) {
		
		return new Account(customer, accountNumber, balance);
	}

}
