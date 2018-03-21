package com.bank.account;

import com.finco.account.IAccountFactory;

public class AbstractAccountFactory {
	
	private static IAccountFactory accountFactory = null;
	
	public static IAccountFactory getFactory(String type) {
		if(type.equals("checking")) {
			accountFactory = CheckingAccountFactory.getInstance();
		} else if(type.equals("savings")) {
			accountFactory = SavingsAccountFactory.getInstance();
		}
		return accountFactory;
	}

}
