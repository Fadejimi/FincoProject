package com.credit_card;


import com.credit_card.gui.CardFrm;
import com.finco.Finco;
import com.finco.IController;
import com.finco.account.AccountManager;

public class CreditCard extends Finco{

	public static void main(String[] args) {
		AccountManager acctManager = new AccountManager();
		CardFrm cardFrame = new CardFrm(); 
		IController controller = new CardController(cardFrame, acctManager);
		
		cardFrame.setVisible(true);
	}

}
