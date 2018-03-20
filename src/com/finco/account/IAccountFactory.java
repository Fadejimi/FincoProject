package com.finco.account;

import com.finco.customer.ICustomer;

public interface IAccountFactory {
	
	public IAccount getAccount(ICustomer customer, String accountNumber, double balance);

}
