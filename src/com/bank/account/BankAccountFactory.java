package com.bank.account;

import com.finco.account.AccountFactory;
import com.finco.account.IAccount;
import com.finco.customer.ICustomer;

public class BankAccountFactory extends AccountFactory{
	
	private IAccount account;
	
	public BankAccountFactory() {
		account = null;
	}
	
	public IAccount getAccount(ICustomer customer, String accountNumber, double balance, 
			String accountType) {
		
		if(accountType.equals("savings"))
			account = new SavingsAccount(customer, accountNumber, balance);
		else if(accountType.equals("checking"))
			account = new CheckingAccount(customer, accountNumber, balance);
		return account;
	}

}
