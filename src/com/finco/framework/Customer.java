package com.finco.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

 import com.finco.framework.IAccount;
import com.finco.framework.IEntry;
 

public class Customer implements ICustomer{
	private String name;
	private String state;
	private String street;
	private String city;
	private String zip;
	private String email;
	IEntry entry;
	IAutomatedEmail autoEmail;
	List<IAccount> accnts;
	
	Customer(String name,String state,String street,String city,String zip,String email){
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.email = email;
		accnts = new ArrayList();
		 
		
	}
	
	public void addAccount(IAccount acct){
		accnts.add(acct);
	}
	public void removeAccount(IAccount acct){
		Iterator it = accnts.iterator();
		while (it.hasNext()){
			if (it.next().equals(acct)){
				it.remove();
			}
		}
	}
	public void sendEmailToCustomer(IEntry entry){
		this.entry = entry;
 		autoEmail = new AutomatedEmail(entry.getEntryType().toString(), entry.getTransactionAmount(),
				entry.getAccount().getCurrentBalance());
		autoEmail.excute();
	}

}
