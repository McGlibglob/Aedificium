package com.aedificium.view.presentation;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.aedificium.model.business.LibrarianMgr;
import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.domain.Librarian;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class AddLibrarianUI extends JInternalFrame{

	private static final long serialVersionUID = -8174121894819741308L;
	
	//Name and set up all widgets.
	JLabel ldapLbl = new JLabel("New Librarian LDAP");
	JTextField ldapFld = new JTextField (20);
	
	JLabel badgeIdLbl = new JLabel("Scan Badge");
	JTextField badgeIdFld = new JTextField (20);
	
	JLabel firstNameLbl = new JLabel("First Name");
	JTextField firstNameFld = new JTextField (20);
	
	JLabel lastNameLbl = new JLabel("Last Name");
	JTextField lastNameFld = new JTextField (20);

	JButton addLibBtn = new JButton("Add Librarian");
	
	
	//Constructor
	public AddLibrarianUI (String name) {
		super(name);
		
		//Get container.
		Container container = getContentPane();
		
		//Set container of GridLayout
		container.setLayout((new GridLayout(5,2)));
		
		//Place widgets.
		container.add(ldapLbl);
		container.add(ldapFld);
		
		container.add(badgeIdLbl);
		container.add(badgeIdFld);
		
		container.add(firstNameLbl);
		container.add(firstNameFld);
		
		container.add(lastNameLbl);
		container.add(lastNameFld);
		
		container.add(addLibBtn);
		
		//Create a Action Listener for the 'addLibBtn'.
		addLibBtn.addActionListener (
				new ActionListener() {
					public void actionPerformed (ActionEvent event) {
						Librarian librarian = new Librarian();
						librarian.setLdap(ldapFld.getText());
						librarian.setBadgeId(badgeIdFld.getText());
						librarian.setFirstName(firstNameFld.getText());
						librarian.setLastName(lastNameFld.getText());
						LibrarianMgr librarianMgr = new LibrarianMgr();
						
						try {
							librarianMgr.createLibrarian(librarian);
							
						} catch (ServiceLoadException e) {
							e.printStackTrace();
						} catch (LibrarianException e) {
							e.printStackTrace();
						}//End of try/catch/
						catch (LogException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}//End of actionPerformed() method.
				}
			);//End of addLibBtn.addActionListener
	
		
		pack();
		setVisible(true);
	}//End of Constructor.


}//End of of AddLibrarian class.