package com.finco.account;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountManager implements Iterable<IAccount>{
	
	private List<IAccount> accountList = new ArrayList<IAccount>();

	private IEntryFactory entryFactory;
	
	public void addAccount(IAccount acc) {
		accountList.add(acc);
	}
	
	public void createEntry() {
		
	}
	
	public void generateReport() {
		
	}
	
	public void addInterestOnAccounts(double interest) {
		
	}
	
	@Override
	public Iterator<IAccount> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
