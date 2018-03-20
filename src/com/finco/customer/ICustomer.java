package com.finco.customer;

 import com.finco.account.IAccount;
import com.finco.account.IEntry;

public interface ICustomer {
	public void addAccount(IAccount acct);
	public void removeAccount(IAccount acct);
	public void sendEmailToCustomer(IEntry entry);
}
