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
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.CheckoutException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class CheckOutUI extends JInternalFrame{


	private static final long serialVersionUID = 3767370803586204067L;
	
	//Naming of widgets
		JLabel titleLbl = new JLabel("Title");
		JTextField titleFld = new JTextField (50);
		
		JLabel borrowerLdapLbl = new JLabel("Borrower LDAP");
		JTextField borrowerLdapFld = new JTextField (20);
		
		JLabel libLdapLbl = new JLabel("Librarian's LDAP");
		JTextField libLdapFld = new JTextField (20);
		
		JLabel bookStickerLbl = new JLabel("Book Sticker");
		JTextField bookStickerFld = new JTextField (45);
		
		JButton addCheckoutBtn = new JButton("Check out Item");
	
		
	//Constructor with arguments.
	public CheckOutUI (String name) {
		super(name);
		
		//Create container
		Container container = getContentPane();
		
		//Make container a GridLayout.
		container.setLayout(new GridLayout(4,2));
		
		//Place widgets.
		container.add(titleLbl);
		container.add(titleFld);
		
		container.add(borrowerLdapLbl);
		container.add(borrowerLdapFld);
		
		container.add(libLdapLbl);
		container.add(libLdapFld);
		
		container.add(bookStickerLbl);
		container.add(bookStickerFld);
		
		container.add(addCheckoutBtn);
		
		addCheckoutBtn.addActionListener(
				new ActionListener() {
					public void actionPerformed (ActionEvent event) {
						
						//Local variables
						
						CheckoutMgr checkoutMgr = new CheckoutMgr();

						String title = titleFld.getText();
						String ldapBorrower = borrowerLdapFld.getText();
						String ldapLibrarian = libLdapFld.getText();
						String bookSticker = bookStickerFld.getText();
						
						try {
							checkoutMgr.createCheckout
							(bookSticker, ldapBorrower, ldapLibrarian, title);
						} catch (ServiceLoadException | 
								CheckoutException | 
								LibrarianException | 
								BookException| 
								BorrowerException | LogException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//End of try/catch.
 catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}//End of actionPerformed() method.
					
		});//End of addCheckButton.addActionListener.
		
		
		pack();
		setVisible(true);
	}//End of CheckoutUI constructor.

		
}//End of CheckoutUI
