package com.bank;

import com.bank.gui.BankFrm;
import com.finco.account.AccountManager;

public class Bank {
	
	public static void main(String [] args) {
		AccountManager acctManager = new AccountManager();
		BankFrm bankFrame = new BankFrm(); 
		BankController controller = new BankController(bankFrame, acctManager);
		
		bankFrame.setVisible(true);
	}
}