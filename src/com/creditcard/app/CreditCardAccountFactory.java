package com.creditcard.app;

import com.bank.app.CompanyCustomer;
import com.bank.app.PersonalCustomer;
import com.finco.framework.IAccount;
import com.finco.framework.IAccountFactory;
import com.finco.framework.ICustomer;

public class CreditCardAccountFactory implements IAccountFactory {
	private IAccount acct;
	
	public CreditCardAccountFactory (ICustomer customer, String accountNumber, double balance,String type,
			String date){
		if(type.equals("gold")){
			acct = new GoldAccount(customer, accountNumber, balance, date);
		}
		else if(type.equals("silver")){
			acct = new SilverAccount(customer, accountNumber, balance, date);
		}
		else if(type.equals("bronze")){
			acct = new BronzeAccount(customer, accountNumber, balance, date);
		} 
	}
		
	public IAccount getAccount() {
		
		return acct;
	}
}
