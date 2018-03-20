package com.finco.account;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.finco.customer.ICustomer;

public class Account implements IAccount{

	private ICustomer customer;
	private String accountNumber;
	private double balance;
	
	private List<IEntry> entryList = new ArrayList<IEntry>();
	
	private IBalanceStrategy balanceTransaction;
	
	public Account(ICustomer customer, String accNumber, double balance) {
		this.customer = customer;
		this.accountNumber = accNumber;
		this.balance = balance;
	}
	
	public void addEntry(IEntry entry) {
		this.setCurrentBalance(executeTransaction(entry));
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
	public double executeTransaction(IEntry entry) {
		
		if(entry.getEntryType() == EntryType.DEPOSIT) {
			balanceTransaction = new DepositStrategy();
		} else if(entry.getEntryType() == EntryType.WITHDRAW) {
			balanceTransaction = new WithdrawStrategy();
		}
		return balanceTransaction.getUpdatedBalance(this.getCurrentBalance(), entry.getTransactionAmount());
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

	public Iterator<IEntry> getEntryListIterator() {
		return entryList.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	
	
	
}
