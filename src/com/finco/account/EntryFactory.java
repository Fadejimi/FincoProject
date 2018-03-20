package com.finco.account;

import java.time.LocalDate;

public class EntryFactory implements IEntryFactory{
	
	private static IEntryFactory myInstance = new EntryFactory();
	
	private EntryFactory() {
		
	}
	
	public static IEntryFactory getInstance() {
		return myInstance;
	}

	public IEntry getEntry(IAccount account, String accountNumber, LocalDate date, double amount, EntryType entryType) {
		
		return new Entry(account, accountNumber, date, amount, entryType);
		
	}
}
