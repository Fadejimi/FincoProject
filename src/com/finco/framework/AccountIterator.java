package com.finco.framework;

/*
 * Not used in the application
 */


import java.util.Iterator;
import java.util.List;

public class AccountIterator implements Iterator<IAccount>{

	private List<IAccount> accountList;
	
	public AccountIterator(List<IAccount> list) {
		this.accountList = list;
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public IAccount next() {
		// TODO Auto-generated method stub
		return null;
	}

}
