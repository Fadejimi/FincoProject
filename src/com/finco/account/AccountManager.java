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
	
	public void createEntry(String name, LocalDate date, double amount, EntryType entryType) {
		IEntry entry = entryFactory.getEntry(name, date,amount, entryType);
	}
	
	public void generateReport() {
		
	}
	
	public void addInterestOnAccounts(double interest) {
		for(IAccount account: accountList) {
			account.addInterest(interest);
		}
	}
	
	@Override
	public Iterator<IAccount> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
