package com.bank.account;

import com.finco.account.IAccount;
import com.finco.account.IAccountFactory;
import com.finco.customer.ICustomer;

public class SavingsAccountFactory implements IAccountFactory {

//	private static IAccountFactory myInstance = new SavingsAccountFactory();
//
//	private SavingsAccountFactory() {
//
//	}
//
//	public static IAccountFactory getInstance() {
//		return myInstance;
//	}
//
//	@Override
//	public IAccount getAccount(ICustomer customer, String accountNumber, double balance) {
//		return new SavingsAccount(customer, accountNumber, balance);
//	}
	
	private IAccount account;
	
	public SavingsAccountFactory(ICustomer customer, String accountNumber, double balance) {
		account = new SavingsAccount(customer, accountNumber, balance);
	}
	
	public IAccount getAccount() {
		return account;
	}

}
