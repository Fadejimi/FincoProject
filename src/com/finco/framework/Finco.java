package com.finco.framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.finco.framework.AccountManager;
import com.finco.framework.FincoFrm;


public class Finco {
	
	public static void main(String [] args) {
		AccountManager acctManager = new AccountManager();
		FincoFrm fincoFrame = new FincoFrm(); 
		FincoController controller = new FincoController(fincoFrame, acctManager);
		
		fincoFrame.setVisible(true);
	}
}
