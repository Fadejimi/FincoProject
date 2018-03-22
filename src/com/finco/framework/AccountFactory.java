package com.finco.framework;

import com.finco.framework.ICustomer;

public class AccountFactory implements IAccountFactory{
	
//	private static IAccountFactory myInstance = new AccountFactory();
	
	private IAccount account;
	
	public AccountFactory() {
		
	}
	
	public AccountFactory(ICustomer customer, String accountNumber, double balance) {
		account = new Account(customer, accountNumber, balance);
	}
	
//	public static IAccountFactory getInstance() {
//		return myInstance;
//	}

	@Override
	public IAccount getAccount() {
		return account;
	}

//	@Override
//	public IAccount getAccount(ICustomer customer, String accountNumber, double balance) {
//		
//		return new Account(customer, accountNumber, balance);
//	}
	
	

}
