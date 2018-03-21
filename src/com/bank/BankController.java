package com.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bank.account.AbstractAccountFactory;
import com.bank.account.CheckingAccount;
import com.bank.account.CheckingAccountFactory;
import com.bank.account.SavingsAccount;
import com.bank.account.SavingsAccountFactory;
import com.bank.customer.PersonalCustomerFactory;
import com.bank.customer.AbstractCustomerFactory;
import com.bank.customer.CompanyCustomer;
import com.bank.customer.CompanyCustomerFactory;
import com.bank.customer.PersonalCustomer;
import com.bank.gui.BankFrm;
import com.bank.gui.JDialog_AddPAcc;
import com.finco.Controller;
import com.finco.account.AAccount;
import com.finco.account.Account;
import com.finco.account.AccountFactory;
import com.finco.account.AccountManager;
import com.finco.account.EntryType;
import com.finco.account.IAccount;
import com.finco.account.IAccountFactory;
import com.finco.customer.CustomerFactory;
import com.finco.customer.ICustomer;
import com.finco.customer.ICustomerFactory;
import com.finco.gui.AbstractEntryDialog;
import com.finco.gui.FincoFrm;
import com.finco.gui.JDialog_Entry;

public class BankController implements Controller {
	BankFrm frame;
	AccountManager manager;
	JButton buttonPerAC;
	JButton buttonCompAC;
	JButton buttonAddInterest;
	JButton buttonDeposit;
	JButton buttonWithdraw;
	ICustomerFactory customerFactory;
	IAccountFactory accountFactory;
	String accountnr, clientName,street,city,zip,state,accountType,email,amountDeposit,noEmployees;
	String birthdate;
	boolean newaccount;
    private Object rowdata[];
    private DefaultTableModel model;
    private JTable JTable1;
    String accnr = null;
    int selection = -1;
	
	public BankController(BankFrm frame, AccountManager manager) {
		this.frame = frame;
		this.manager = manager;
		
		buttonPerAC = this.frame.getJButton_PerAC();
		buttonCompAC = this.frame.getJButton_CompAC();
		buttonAddInterest = this.frame.getJButton_Addinterest();
		buttonDeposit = this.frame.getJButton_Deposit();
		buttonWithdraw = this.frame.getJButton_Withdraw();
		
		rowdata = new Object[8];
		//model = frame.getTableModel();
		JTable1 = frame.getTable();
		model = (DefaultTableModel) JTable1.getModel();
		//JTable1.setModel(model);
		
		buttonPerAC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createPersonalAccount();
			}
		});
		
		buttonCompAC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createCompanyAccount();
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
	
	private IAccountFactory getAccountFactory(ICustomer customer, String accountnr, 
			double balance, String acctType) {
		if (acctType.equals("checkings")) {
			return new CheckingAccountFactory(customer, accountnr, balance);
		}
		else {
			return new SavingsAccountFactory(customer, accountnr, balance);
		}
	}
	
	private void createPersonalAccount() {
		JDialog_AddPAcc pac = new JDialog_AddPAcc(frame, this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
			customerFactory = new PersonalCustomerFactory(clientName, state, street, 
					city, zip, birthdate, email);
			ICustomer customer = customerFactory.getCustomer();
			accountFactory = getAccountFactory(customer, accountnr, 0, accountType);
			IAccount account = accountFactory.getAccount();
			manager.addAccount(account);
			// add row to table
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
	
	private void createCompanyAccount() {
		JDialog_AddPAcc pac = new JDialog_AddPAcc(frame, this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
			int emps = Integer.parseInt(noEmployees);
			customerFactory = new CompanyCustomerFactory(clientName, state, street, 
					city, zip, emps, email);
			ICustomer customer = customerFactory.getCustomer();
			accountFactory = getAccountFactory(customer, accountnr, 0, accountType);
			IAccount account = accountFactory.getAccount();
			manager.addAccount(account);
			// add row to table
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
	
	public void setNoEmployees(String employees) {
		this.noEmployees = employees;
	}

	
	public boolean isNewaccount() {
		return newaccount;
	}

	public void setNewaccount(boolean newaccount) {
		this.newaccount = newaccount;
	}
	
	public void setBirthdate(String date) {
		this.birthdate = date;
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
