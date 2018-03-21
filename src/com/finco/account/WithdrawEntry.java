package com.finco.account;

import java.time.LocalDate;

public class WithdrawEntry extends AEntry {

	public WithdrawEntry() {

	}

	public WithdrawEntry(IAccount account, String accountNumber, LocalDate date, double amt, EntryType entryType) {
		super(account, accountNumber, date, amt, entryType);
	}

	@Override
	public double getUpdatedBalance(double balance) {
		return balance += super.getTransactionAmount();
	}

}
