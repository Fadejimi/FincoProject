package com.bank.app;

import com.bank.app.BankFrm;
import com.finco.framework.Finco;
import com.finco.framework.AccountManager;

public class Bank extends Finco{
	
	public static void main(String [] args) {
		AccountManager acctManager = new AccountManager();
		BankFrm bankFrame = new BankFrm(); 
		BankController controller = new BankController(bankFrame, acctManager);
		
		bankFrame.setVisible(true);
	}
}