package com.aedificium.model.domain;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

public class BorrowerTest {
	
	Logger logger = LogManager.getLogger();

	@Test
	public void testValidateWorks() {
		Borrower borrower1 = new Borrower("chelton", "394a39b", "Curtis", "Helton");  //Creates new borrower object with attributes
		assertTrue("Validates Borrower object", borrower1.validate());
			logger.debug("testValidateWorks() for borrower, in fact, works");
	}
	
	@Test
	public void testNotValidateWorks() {
		Borrower borrower2 = new Borrower();  //Creates another borrower object with attributes
		assertFalse("Validates Borrower object", borrower2.validate());
			logger.debug("testNotValidateWorks() for Borrower, in fact, works");
	}
	
	@Test
	public void testEqualWorks() {
		Borrower borrower1 = new Borrower("chelton", "394a39b", "Curtis", "Helton");
		Borrower borrower2 = new Borrower("chelton", "394a39b", "Curtis", "Helton");
		//Run an assertTrue method to compare the two objects for equality
		assertTrue("Tests that equal() passes", borrower1.equals(borrower2));
		logger.debug("The testEqualWork() method passes for Borrower!");
	}

	@Test
	public void testNotEqualWorks() {
		Borrower borrower1 = new Borrower("chelton", "394a39b", "Curtis", "Helton");
		Borrower borrower2 = new Borrower("chrishofer", "a610c78", "Chris", "Hofer");
		//Run an assertTrue method to compare the two objects for equality
		assertFalse("Tests that equal() false", borrower1.equals(borrower2));
		logger.debug("The testNotEqualWorks() method works for Borrower");
	}
}
