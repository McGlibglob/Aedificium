package com.aedificium.view.presentation;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.aedificium.model.business.BookMgr;
import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.domain.Book;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class AddBookUI extends JInternalFrame {

	private static final long serialVersionUID = -2925343194277160467L;

	// Naming of widgets
	JLabel titleLbl = new JLabel("Title");
	JTextField titleFld = new JTextField(50);

	JLabel authorLbl = new JLabel("Author (Last, First Middle");
	JTextField authorFld = new JTextField(25);

	JLabel yearPubLbl = new JLabel("Year Published");
	JTextField yearPubFld = new JTextField(4);

	JLabel isbnLbl = new JLabel("ISBN (No spaces/hyphons)");
	JTextField isbnFld = new JTextField(13);

	JLabel stickerIDLbl = new JLabel("Scan Book's RFID Sticker");
	JTextField stickerIDFld = new JTextField(25);

	JLabel libLdapLbl = new JLabel("Librarian's LDAP");
	JTextField libLdapFld = new JTextField(20);

	JButton addBookBtn = new JButton("Add Book");

	// Methods

	// Constructor with arguments
	public AddBookUI(String name) {
		super(name);

		// Create container.
		Container container = getContentPane();

		// Make container a GridLayout.
		container.setLayout(new GridLayout(7, 2));

		// Place widgets
		container.add(titleLbl);
		container.add(titleFld);

		container.add(authorLbl);
		container.add(authorFld);

		container.add(isbnLbl);
		container.add(isbnFld);

		container.add(yearPubLbl);
		container.add(yearPubFld);

		container.add(stickerIDLbl);
		container.add(stickerIDFld);

		container.add(libLdapLbl);
		container.add(libLdapFld);

		container.add(addBookBtn);

		addBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				// Local variables
				Book book = new Book();
				String title = titleFld.getText();
				String yearString = yearPubFld.getText();
				String author = authorFld.getText();
				String stickerID = stickerIDFld.getText();
				String libLdap = libLdapFld.getText();
				int year = Integer.parseInt(yearString);
				String isbn = isbnFld.getText();

				book.setTitle(title);
				book.setYearPublished(year);
				book.setIsbn(isbn);
				book.setAuthor(author);
				book.setStickerID(stickerID);
				book.setCheckedOut(false);

				System.out.println(book.toString());
				BookMgr bookMgr = new BookMgr();
				try {
					bookMgr.createBook(book, libLdap);

				} catch (ServiceLoadException e) {
					e.printStackTrace();

				} catch (BookException e) {
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

			}// End of actionPerformed

		});// End of addBookBtn.addActionListener.

		pack();
		setVisible(true);

	}// End of AddBookUI constructor.

}// End of AddBookUI class.
