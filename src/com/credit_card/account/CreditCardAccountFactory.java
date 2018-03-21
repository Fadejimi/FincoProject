package com.credit_card.account;

import com.bank.customer.CompanyCustomer;
import com.bank.customer.PersonalCustomer;
import com.finco.account.IAccount;
import com.finco.customer.ICustomer;

public class CreditCardAccountFactory {
private IAccount acct;
		public CreditCardAccountFactory (){
	
		}
		
	public IAccount getAccount(ICustomer customer, String accountNumber, double balance,String type) {
		if(type.equals("gold")){
			acct = new GoldAccount(customer, accountNumber, balance);
		}
		else if(type.equals("silver")){
			acct = new SilverAccount(customer, accountNumber, balance);
		}
		else if(type.equals("bronze")){
			acct = new BronzeAccount(customer, accountNumber, balance);
		} 
		return acct;
	}
}
