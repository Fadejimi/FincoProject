package com.credit_card.account;

import com.bank.customer.CompanyCustomer;
import com.bank.customer.PersonalCustomer;
import com.finco.account.IAccount;
import com.finco.account.IAccountFactory;
import com.finco.customer.ICustomer;

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
