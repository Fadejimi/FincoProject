package com.creditcard.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bank.app.BankAccountFactory;
import com.bank.app.BankCustomerFactory;
import com.bank.app.BankFrm;
import com.bank.app.JDialog_AddPAcc;
import com.creditcard.app.CreditCardAccountFactory;
import com.creditcard.app.CardFrm;
import com.creditcard.app.JDialog_AddCard;
import com.finco.framework.IController;
import com.finco.framework.AAccount;
import com.finco.framework.AccountManager;
import com.finco.framework.EntryType;
import com.finco.framework.IAccount;
import com.finco.framework.IAccountFactory;
import com.finco.framework.CustomerFactory;
import com.finco.framework.ICustomer;
import com.finco.framework.ICustomerFactory;
import com.finco.framework.AbstractEntryDialog;
import com.finco.framework.JDialog_Entry;

public class CardController implements IController{
	CardFrm frame;
	AccountManager manager;
	JButton buttonCard;
	JButton buttonReports;
	JButton buttonAddInterest;
	JButton buttonDeposit;
	JButton buttonWithdraw;
	ICustomerFactory customerFactory;
	IAccountFactory accountFactory;
	String accountnr, clientName,street,city,zip,state,accountType,email,amountDeposit,expiryDate;
	boolean newaccount;
    private Object rowdata[];
    private DefaultTableModel model;
    private JTable JTable1;
    String accnr = null;
    int selection = -1;
	
	public CardController(CardFrm frame, AccountManager manager) {
		this.frame = frame;
		this.manager = manager;
		
		buttonCard = this.frame.getJButton_Card();
		buttonReports = this.frame.getJButton_Report();
		buttonAddInterest = this.frame.getJButton_Addinterest();
		buttonDeposit = this.frame.getJButton_Deposit();
		buttonWithdraw = this.frame.getJButton_Withdraw();
		
		rowdata = new Object[8];
		//model = frame.getTableModel();
		JTable1 = frame.getTable();
		model = (DefaultTableModel) JTable1.getModel();
		//JTable1.setModel(model);
		
		buttonCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createCardAccount();
			}
		});
		
		buttonReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createReports();
			}
		});
		
		buttonAddInterest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				addInterest();
			}
		});
		
		buttonDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				deposit();
			}
		});
		
		buttonWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				withdraw();
			}
		});
	}
	
	
	private void createCardAccount() {
		JDialog_AddCard pac = new JDialog_AddCard(frame, this);
		pac.setBounds(450, 20, 300, 390);
		pac.show();

		if (newaccount){
			customerFactory = new CustomerFactory(clientName, state, street, 
					city, zip, email);
			ICustomer customer = customerFactory.getCustomer();
			accountFactory = new CreditCardAccountFactory(customer, accountnr, 0.00, accountType, 
					expiryDate);
			IAccount account = accountFactory.getAccount();
			manager.addAccount(account);
			// add row to table
			//System.out.println("account number" + accountnr);
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = state;
            rowdata[4] = accountType;
            rowdata[5] = "0";
            //System.out.println(accountnr + ", " + clientName + ", " + city);
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            model.fireTableDataChanged();
            newaccount=false;
            
        }
	}
	
	private void createReports() {
		
	}
	
	public String getAccountnr() {
		return accountnr;
	}

	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmount(String amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public String getAccnr() {
		return accnr;
	}

	public void setAccnr(String accnr) {
		this.accnr = accnr;
	}
	
	public void setExpiryDate(String date) {
		this.expiryDate = date;
	}
	
	public boolean isNewaccount() {
		return newaccount;
	}

	public void setNewaccount(boolean newaccount) {
		this.newaccount = newaccount;
	}

	private void addInterest() {
		manager.addInterestOnAccounts(0.15);
		updateAccounts();
	}
	
	private void updateAccounts() {
		int count = 0;
		Iterator iterator = manager.iterator();
		while(iterator.hasNext()) {
			AAccount acc = (AAccount) iterator.next();
			model.setValueAt(String.valueOf(acc.getCurrentBalance()),count, 5);
			count++;
		}
	}
	
	private boolean setAccnr() {
		selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String)model.getValueAt(selection, 0);
			return true;
		}
		return false;
	}
	
	private double getAmount(AbstractEntryDialog wd) {
		Double amount = null;
		
		//Show the dialog for adding withdraw amount for the current mane
		wd.setAccnr(accnr);
		wd.setBounds(430, 15, 275, 140);
		wd.show();
		
		// compute new amount
		if (amountDeposit != null) {
			amount = Double.parseDouble(amountDeposit);
			amountDeposit = null;
		}
		
        return amount;
	}
	
	private void deposit() {
		if (setAccnr()) {
			AbstractEntryDialog dialog = new JDialog_Entry(frame, accnr, this,"Deposit");
			Double deposit = getAmount(dialog);
			if (deposit != null && accnr != null) {
				manager.createEntry(accnr, LocalDate.now(), deposit, EntryType.DEPOSIT);
				model.setValueAt(String.valueOf(manager.getEntryBalance()),selection, 5);
			}
			accnr = null;
		}
	}
	
	private void withdraw() {
		if (setAccnr()) {
			AbstractEntryDialog dialog = new JDialog_Entry(frame, accnr, this, "Withdraw");
			Double withdraw = getAmount(dialog);
			if (withdraw != null && accnr != null) {
				manager.createEntry(accnr, LocalDate.now(), withdraw, EntryType.WITHDRAW);
				model.setValueAt(String.valueOf(manager.getEntryBalance()),selection, 5);
			}
			accnr = null;
		}
	}
}
