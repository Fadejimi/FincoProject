package com.bank.account;

import com.finco.account.AAccount;
import com.finco.account.IEntry;
import com.finco.customer.ICustomer;

public class SavingsAccount extends AAccount{
	
	public SavingsAccount(ICustomer customer, String accNumber, double balance) {
		super(customer, accNumber, balance);
	}
	
	public SavingsAccount(ICustomer customer, String accNumber) {
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
