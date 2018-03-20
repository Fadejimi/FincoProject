package com.finco.account;

import java.time.LocalDate;

public class EntryFactory implements IEntryFactory{
	
	private IEntryFactory myInstance = new EntryFactory();
	
	private EntryFactory() {
		
	}
	
	public IEntryFactory getInstance() {
		return myInstance;
	}

	public IEntry getEntry(String name, LocalDate date, double amount, EntryType entryType) {
		
		return new Entry(name, date, amount, entryType);
		
	}
}
