package com.finco.framework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountManager {
	
	private List<IAccount> accountList = new ArrayList<IAccount>();

	private IEntryFactory entryFactory = EntryFactory.getInstance();
	
	private double updatedAccountBalance;
	
	public void addAccount(IAccount acc) {
		accountList.add(acc);
	}
	
	public void createEntry(String accountNumber, LocalDate date, double amount, EntryType entryType) {
		
		IAccount account = this.getAccount(accountNumber);
		
		IEntry entry = entryFactory.getEntry(account, accountNumber, date,amount, entryType);
		account.addEntry(entry);
		updatedAccountBalance = account.getCurrentBalance();
	}
	
	public Iterator<IAccount> generateReport() {
		return this.accountList.iterator();
	}
	
	public void addInterestOnAccounts(double interest) {
		for(IAccount account: accountList) {
			account.addInterest(interest);
		}
	}
	
	public IAccount getAccount(String accountNumber) {
		for(IAccount account: accountList) {
			if(accountNumber.equals(account.getAccountNumber()))
				return account;
		}
		return null;
	}
	
	public double getEntryBalance() {
		return updatedAccountBalance;
	}

	public Iterator<IAccount> iterator() {
		return accountList.iterator();
	}
	
}
