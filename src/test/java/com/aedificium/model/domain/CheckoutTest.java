package com.aedificium.model.domain;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

import org.junit.Test;

public class CheckoutTest {
	
	Logger logger = LogManager.getLogger();
	
	//Creation of a Checkout to be tested.
	Book book1 = new Book ("Becoming", 2018, false, "Obama, Michelle", "2048603256", "3jixfc9");
	Borrower borrower1 = new Borrower("glibglob", "2038301ab", "Morgan", "Wood");
	LocalDate dueDate1 = LocalDate.now().plusDays(14);
	boolean overdue1 = true;
	Checkout checkout1 = new Checkout(book1, borrower1, dueDate1, overdue1);
	
	//Creation of a Checkout to be tested.
	Book book2 = new Book ("The Thief", 2003, true, "Henning, Amy", "40698754323", "95ifk3cb");
	Borrower borrower2 = new Borrower("glibglob", "2038301ab", "Morgan", "Wood");
	LocalDate dueDate2 = LocalDate.now().plusDays(14);
	boolean overdue2 = true;
	Checkout checkout2 = new Checkout(book2, borrower2, dueDate2, overdue2);
	
	//Creation of a Checkout to be tested.
	Checkout checkout3 = new Checkout(book1, borrower1, dueDate1, overdue1);
		
	
	
	@Test
	public void testValidate() {
		assertTrue("Validates checkout", checkout1.validate());
		logger.debug("testValidateWorks() for Checkout class, in fact, works");
	}
	
	@Test
	public void testNotValidate() {
		Checkout checkout2 = new Checkout();
		assertFalse("Validates false checkout", checkout2.validate());
		logger.debug("testNotValidateWorks() for Checkout class, in fact, works");
		}
	
	@Test
	public void testCheckoutEquals() {
		assertTrue("Tests the equal checkout", checkout1.equals(checkout3));
		logger.debug("The testEqualWork() for Checkout class passes");
	}
	
	@Test
	public void testNotCheckoutEquals() {
		assertFalse("Tests the equal checkout", checkout1.equals(checkout2));
		logger.debug("The testNotEqualWork() for Checkout class passes");
	}

}
