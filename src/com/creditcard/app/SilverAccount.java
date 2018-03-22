package com.creditcard.app;

import com.finco.framework.AAccount;
import com.finco.framework.IEntry;
import com.finco.framework.ICustomer;

public class SilverAccount extends AAccount{
	private static double interest = 0.08;
	private String date;
	
	public SilverAccount(ICustomer customer, String accNumber, double balance, String date) {
		super(customer, accNumber, balance);
		this.date = date;
	}
	
	public SilverAccount(ICustomer customer, String accNumber) {
		super(customer, accNumber);
	}
	
	public void addEntry(IEntry entry) {
		super.addEntry(entry);
	}
	
	public void notifyCustomer(IEntry entry) {
		super.notifyCustomer(entry);
	}
	
	public void addInterest(double interest) {
		super.addInterest(this.interest);
	}
	
	public double executeTransaction(IEntry entry) {
		return super.executeTransaction(entry);
	}

}

