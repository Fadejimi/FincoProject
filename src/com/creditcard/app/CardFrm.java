package com.creditcard.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

import com.finco.framework.AbstractFrame;

import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class CardFrm extends AbstractFrame
{
    /****
     * init variables in the object
     ****/
    private DefaultTableModel model;
    private JTable JTable1;
    CardFrm myframe;
    
	public CardFrm()
	{
		super("Bank Application.");
		
		myframe = this;

		
		
        JTable1 = getTable();
        	
		JButton_Card.setText("Credit Card Account");
		addButton(JButton_Card, 24, 20, 192, 33);
		
		JButton_Report.setText("Generate Reports");
		addButton(JButton_Report, 240,20,192,33);
		
		JButton_Deposit.setText("Deposit");
		addButton(JButton_Deposit,468,104,96,33);
		
		JButton_Withdraw.setText("Withdraw");
		addButton(JButton_Withdraw,468,20,106,33);
		
		JButton_Addinterest.setText("Add interest");
		addButton(JButton_Addinterest,468,164,96,33);
		
		JButton_Exit.setText("Exit");
		addButton(JButton_Exit, 468,248,96,31);
		
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		
		
	}

	
	


	//javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_Card = new javax.swing.JButton();
	javax.swing.JButton JButton_Report = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	public javax.swing.JButton getJButton_Card() {
		return JButton_Card;
	}

	public javax.swing.JButton getJButton_Report() {
		return JButton_Report;
	}

	public javax.swing.JButton getJButton_Deposit() {
		return JButton_Deposit;
	}


	public javax.swing.JButton getJButton_Withdraw() {
		return JButton_Withdraw;
	}

	public javax.swing.JButton getJButton_Addinterest() {
		return JButton_Addinterest;
	}

	public javax.swing.JButton getJButton_Exit() {
		return JButton_Exit;
	}

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == CardFrm.this)
				BankFrm_windowClosing(event);
		}
	}
	
	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
	    
	}


	@Override
	public DefaultTableModel getTableModel() {
		// TODO Auto-generated method stub
		model = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
        //JTable1.setModel(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("State");
        model.addColumn("Account Type");
        model.addColumn("Amount");
        
        return model;
	}
}
