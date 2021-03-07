package com.aedificium.view.presentation;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.aedificium.model.business.BorrowerMgr;
import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.domain.Borrower;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class AddBorrowerUI extends JInternalFrame{


	private static final long serialVersionUID = 3211488763458264363L;
	
	JLabel borLdapLbl = new JLabel("New Borrower's LDAP");
	JTextField borLdapFld = new JTextField (20);
	
	JLabel badgeIdLbl = new JLabel("Scan Badge");
	JTextField badgeIdFld = new JTextField (20);
	
	JLabel firstNameLbl = new JLabel("First Name");
	JTextField firstNameFld = new JTextField (20);
	
	JLabel lastNameLbl = new JLabel("Last Name");
	JTextField lastNameFld = new JTextField (20);

	JButton addBorrowerBtn = new JButton("Add Borrower");
	
	JLabel libLdapLbl = new JLabel("Librarian's LDAP");
	JTextField libLdapFld = new JTextField (20);
	
	public AddBorrowerUI (String name) {
		super(name);
		
		//Get container.
		Container container = getContentPane();
		
		//Set container of GridLayout
		container.setLayout((new GridLayout(6,2)));
		
		//Place widgets.
		container.add(borLdapLbl);
		container.add(borLdapFld);
		
		container.add(badgeIdLbl);
		container.add(badgeIdFld);
		
		container.add(firstNameLbl);
		container.add(firstNameFld);
		
		container.add(lastNameLbl);
		container.add(lastNameFld);
		
		container.add(libLdapLbl);
		container.add(libLdapFld);

		container.add(addBorrowerBtn);
		
		
		//Add Borrower Button Action
		addBorrowerBtn.addActionListener(
				new ActionListener() {
					public void actionPerformed (ActionEvent event) {
						
						Borrower borrower = new Borrower();
						borrower.setLdap(borLdapFld.getText());
						borrower.setBadgeId(badgeIdFld.getText());
						borrower.setFirstName(firstNameFld.getText());
						borrower.setLastName(lastNameFld.getText());
						BorrowerMgr borrowerMgr = new BorrowerMgr();
						String libLdap = libLdapFld.getText();
						
						try {
							borrowerMgr.createBorrower(borrower, libLdap);
							
						} catch (ServiceLoadException e) {
							e.printStackTrace();
						} catch (BorrowerException e) {
							e.printStackTrace();
						} catch (LibrarianException e) {

							e.printStackTrace();
						} catch (LogException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}//End of actionPerformed() method.
				}
		);//End of addBorrowerBtn.addActionListener.
		
		
		
		pack();
		setVisible(true);
		
	}//End of constructor.
	

}//End of AddBorrowerUI class.
