package com.finco.framework;

 import com.finco.framework.IAccount;
import com.finco.framework.IEntry;

public interface ICustomer {
	public void addAccount(IAccount acct);
	public void removeAccount(IAccount acct);
	public void sendEmailToCustomer(IEntry entry);
}
