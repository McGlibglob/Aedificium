package com.aedificium.view.presentation;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.aedificium.model.business.CheckoutMgr;
import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.CheckoutException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class CheckInUI extends JInternalFrame {

	private static final long serialVersionUID = 6147164917818629875L;
	
	//Naming of widgets
	JLabel titleLbl = new JLabel("Title");
	JTextField titleFld = new JTextField (50);
	
	JLabel libLdapLbl = new JLabel("Librarian's LDAP");
	JTextField libLdapFld = new JTextField (20);
	
	JButton addCheckInBtn = new JButton("Check in Item");
	
	//Constructor with arguments.
		public CheckInUI (String name) {
			super(name);
		
			//Create container
			Container container = getContentPane();
			
			//Make container a GridLayout.
			container.setLayout(new GridLayout(3,2));
			
			//Place widgets.
			container.add(titleLbl);
			container.add(titleFld);
			
			container.add(libLdapLbl);
			container.add(libLdapFld);
			
			container.add(addCheckInBtn);
			
			addCheckInBtn.addActionListener(
					new ActionListener() {
						public void actionPerformed (ActionEvent event) {
							CheckoutMgr checkoutMgr = new CheckoutMgr();
							
							String title = titleFld.getText();
							String ldapLib = libLdapFld.getText();
							
							try {
								checkoutMgr.checkInItem(title, ldapLib);
							} catch (ServiceLoadException |
									LibrarianException |
									CheckoutException |
									BookException | LogException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}});
			
			pack();
			setVisible(true);
		}//End CheckInUI constructor
		
		

}//End CheckInUI class.
