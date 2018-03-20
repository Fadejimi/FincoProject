package com.finco.customer;

import com.finco.account.IAccount;

public interface ICustomer {
	public void addAccount(IAccount acct);
	public void removeAccount(IAccount acct);
	public void sendEmailToCustomer();
}
