package com.creditcard.app;

import com.finco.framework.Finco;
import com.creditcard.app.CardFrm;
import com.finco.framework.IController;
import com.finco.framework.AccountManager;

public class CreditCard extends Finco{

	public static void main(String[] args) {
		AccountManager acctManager = new AccountManager();
		CardFrm cardFrame = new CardFrm(); 
		IController controller = new CardController(cardFrame, acctManager);
		
		cardFrame.setVisible(true);
	}

}
