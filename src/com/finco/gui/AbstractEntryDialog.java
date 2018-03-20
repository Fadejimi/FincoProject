package com.finco.gui;

public class AbstractEntryDialog extends javax.swing.JDialog{
	private AbstractFrame parentframe;
	
	public AbstractEntryDialog(AbstractFrame parentFrame, String title) {
		super(parentFrame);
		
		setTitle(title);
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
	}
}
