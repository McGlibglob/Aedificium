package com.aedificium.model.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class SPCTest {
	
	Logger logger = LogManager.getLogger();
	
	SPC spc = new SPC();

	@Test  //Also tests the bookExists() method
	public void testAddRemoveBook() {
		Book book1 = new Book(
				"The House of Leaves", 2000, true, 
				"Danielewski, Mark Z.", "0375703764", "aoeirujd");
		spc.addBook(book1);
		assertTrue(spc.bookExists(book1));
		spc.removeBook(book1.getStickerID());
		assertFalse(spc.bookExists(book1));
		logger.debug("testAddRemoveBook() for SPC class works.");
	}
	
	@Test  //Also tests the borrowerExists() method
	public void testAddBorrower() {
		Borrower borrower1 = new Borrower("chrishofer", "a610c78", "Chris", "Hofer");
		spc.addBorrower(borrower1);
		assertTrue(spc.borrowerExists(borrower1));
		spc.removeBorrower(borrower1.getBadgeId());
		assertFalse(spc.borrowerExists(borrower1));
		logger.debug("testAddRemoveBorrower() for SPC class works.");
	}

	@Test  //Also tests the librarianExists() method
	public void testAddRemoveLibrarian() {
		Librarian librarian1 = new Librarian("danharper", "044de92", "Daniel", "Harper");
		spc.addLibrarian(librarian1);
		assertTrue(spc.librarianExists(librarian1));
		spc.removeLibrarian(librarian1.getBadgeId());
		assertFalse(spc.librarianExists(librarian1));
		logger.debug("testAddRemoveLibrarian() for SPC class works.");
	}
	
	@Test  //Also tests the checkoutExists() method
	public void testAddRemoveCheckout() {
		Book book1 = new Book(
				"The House of Leaves", 2000, true, 
				"Danielewski, Mark Z.", "0375703764", "aoeirujd");
		Borrower borrower1 = new Borrower("chrishofer", "a610c78", "Chris", "Hofer");
		LocalDate dueDate1 = LocalDate.now().plusDays(14);
		boolean overdue1 = true;
		Checkout checkout1 = new Checkout(book1, borrower1, dueDate1, overdue1);
		spc.addCheckout(checkout1);
		assertTrue(spc.checkoutExists(book1));
		spc.removeCheckout(book1.getStickerID());
		assertFalse(spc.checkoutExists(book1));
		logger.debug("testAddRemoveCheckout() for SPC class works.");
	}
	
	@Test  //Also tests the checkoutExists() method
	public void testValidate() {
		SPC spc = new SPC();
		assertTrue(spc.validate());
		logger.debug("testValidate() for SPC class works.");
	}

}
