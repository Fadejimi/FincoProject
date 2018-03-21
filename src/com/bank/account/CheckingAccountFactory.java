package com.bank.account;

import com.finco.account.IAccount;
import com.finco.account.IAccountFactory;
import com.finco.customer.ICustomer;

public class CheckingAccountFactory implements IAccountFactory {

//	private static IAccountFactory myInstance = new CheckingAccountFactory();
//
//	private CheckingAccountFactory() {
//
//	}

//	public static IAccountFactory getInstance() {
//		return myInstance;
//	}

//	@Override
//	public IAccount getAccount(ICustomer customer, String accountNumber, double balance) {
//		return new CheckingAccount(customer, accountNumber, balance);
//	}

	private IAccount account;
	
	public CheckingAccountFactory(ICustomer customer, String accountNumber, double balance) {
		account = new CheckingAccount(customer, accountNumber, balance);
	}
	
	public IAccount getAccount() {
		return account;
	}
	
}
