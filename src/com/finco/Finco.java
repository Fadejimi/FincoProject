package com.finco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.finco.account.AccountManager;
import com.finco.gui.FincoFrm;


public class Finco {
	
	public static void main(String [] args) {
		AccountManager acctManager = new AccountManager();
		FincoFrm bankFrame = new FincoFrm(); 
		Controller controller = new Controller(bankFrame, acctManager);
		
		bankFrame.setVisible(true);
	}
}
