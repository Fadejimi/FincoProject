package com.credit_card.account;

import com.finco.account.IAccount;
import com.finco.account.IAccountFactory;
import com.finco.customer.ICustomer;

public class SilverFactory implements IAccountFactory{

	@Override
	public IAccount getAccount(ICustomer customer, String accountNumber,
			double balance) {
		// TODO Auto-generated method stub
		return new SilverAccount(customer, accountNumber, balance);
	}

}
