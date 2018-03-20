package com.finco.account;

import java.time.LocalDate;

public interface IEntry {
	
	public IAccount getAccount();

	public String getAccountNumber();

	public LocalDate getDate();

	public double getTransactionAmount();

	public EntryType getEntryType();

}
