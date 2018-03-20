package com.finco.account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountManager implements Iterable<IAccount>{
	
	private List<IAccount> accountList = new ArrayList<IAccount>();

	private IEntryFactory entryFactory = EntryFactory.getInstance();
	
	public void addAccount(IAccount acc) {
		accountList.add(acc);
	}
	
	public void createEntry(String accountNumber, LocalDate date, double amount, EntryType entryType) {
		
		IAccount account = this.getAccount(accountNumber);
		
		IEntry entry = entryFactory.getEntry(account, accountNumber, date,amount, entryType);
		
	}
	
	public void generateReport() {
		
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
	
	@Override
	public Iterator<IAccount> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
