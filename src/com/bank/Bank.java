package com.bank;

import com.bank.gui.BankFrm;
import com.finco.Finco;
import com.finco.account.AccountManager;

public class Bank extends Finco{
	
	public static void main(String [] args) {
		AccountManager acctManager = new AccountManager();
		BankFrm bankFrame = new BankFrm(); 
		BankController controller = new BankController(bankFrame, acctManager);
		
		bankFrame.setVisible(true);
	}
}