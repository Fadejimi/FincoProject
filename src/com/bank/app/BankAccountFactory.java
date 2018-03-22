package com.bank.app;

import com.finco.framework.AccountFactory;
import com.finco.framework.IAccount;
import com.finco.framework.ICustomer;

public class BankAccountFactory extends AccountFactory{
	
	private IAccount account;
	
	public BankAccountFactory(ICustomer customer, String accountNumber, double balance, 
			String accountType) {
		if(accountType.equals("savings"))
			account = new SavingsAccount(customer, accountNumber, balance);
		else if(accountType.equals("checking"))
			account = new CheckingAccount(customer, accountNumber, balance);
		
	}
	
	public IAccount getAccount() {
		
		return account;
	}

}
