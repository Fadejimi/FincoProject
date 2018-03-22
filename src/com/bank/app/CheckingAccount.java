package com.bank.app;

import com.finco.framework.AAccount;
import com.finco.framework.IEntry;
import com.finco.framework.ICustomer;

public class CheckingAccount extends AAccount{
	
	public CheckingAccount(ICustomer customer, String accNumber, double balance) {
		super(customer, accNumber, balance);
	}
	
	public CheckingAccount(ICustomer customer, String accNumber) {
		super(customer, accNumber);
	}
	
	public void addEntry(IEntry entry) {
		super.addEntry(entry);
	}
	
	public void notifyCustomer(IEntry entry) {
		super.notifyCustomer(entry);
	}
	
	public void addInterest(double interest) {
		super.addInterest(interest);
	}
	
	public double executeTransaction(IEntry entry) {
		return super.executeTransaction(entry);
	}

}
