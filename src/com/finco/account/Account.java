package com.finco.account;

import java.util.ArrayList;
import java.util.List;

import com.finco.customer.ICustomer;

public class Account implements IAccount{

	private ICustomer customer;
	private String accountNumber;
	private double balance;
	
	private List<IEntry> entryList = new ArrayList<IEntry>();
	
	private IBalanceStrategy balanceTranscation;
	
	public Account(ICustomer customer, String accNumber, double balance) {
		this.customer = customer;
		this.accountNumber = accNumber;
		this.balance = balance;
	}
	
	public void addEntry(IEntry entry) {
		entryList.add(entry);
		this.notifyCustomer(entry);
	}
	
	public void notifyCustomer(IEntry entry) {
		customer.sendEmailToCustomer(entry);
	}
	
	public void addInterest(double interest) {
		balance += interest * balance;
	}
	
	// does it get the strategy reference
	public void setTransactionStrategy(IBalanceStrategy strategy) {
		this.balanceTranscation = strategy;
	}
	
	public void setCurrentBalance(double balance) {
		this.balance = balance;
	}
	
	public double getCurrentBalance() {
		return balance;
	}

	public ICustomer getCustomer() {
		return customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public List<IEntry> getEntryList() {
		return entryList;
	}
	
	
	
}
