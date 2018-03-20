package com.finco.account;

public interface IBalanceStrategy {

	public double getUpdatedBalance(double balance, double transactionAmt);
	
}
