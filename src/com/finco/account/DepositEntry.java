package com.finco.account;

import java.time.LocalDate;

public class DepositEntry extends AEntry{
	
	public DepositEntry() {
		
	}
	
	public DepositEntry(IAccount account, String accountNumber, LocalDate date, 
			double amt, EntryType entryType) {
		super(account, accountNumber, date, amt, entryType);
	}

	@Override
	public double getUpdatedBalance(double balance) {
		return balance += super.getTransactionAmount();
	}

	
}
