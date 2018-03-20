package com.bank.account;

import com.finco.account.IAccount;
import com.finco.account.IAccountFactory;
import com.finco.customer.ICustomer;

public class CheckingAccountFactory implements IAccountFactory{

	@Override
	public IAccount getAccount(ICustomer customer, String accountNumber, double balance) {
		return null;
	}

}
