package com.finco.framework;

public class DepositStrategy implements IBalanceStrategy{

	// Not implemented
	@Override
	public double getUpdatedBalance(double balance, double transactionAmt) {
		return balance += transactionAmt;
	}

}
