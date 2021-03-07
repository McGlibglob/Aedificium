package com.aedificium.model.domain;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

public class LibrarianTest {
	
	Logger logger = LogManager.getLogger();

	@Test
	public void testValidateWorks() {
		Librarian librarian1 = new Librarian("danharper", "044de92", "Daniel", "Harper");  //Creates new librarian object with attributes
		assertTrue("Validates Librarian object", librarian1.validate());
		logger.debug("testValidateWorks() for Librarian, in fact, works");
	}
	
	@Test
	public void testNotValidateWorks() {
		Librarian librarian2 = new Librarian();  //Creates another librarian object with attributes
		assertFalse("Validates librarian object", librarian2.validate());
		logger.debug("testNotValidateWorks() for Librarian, in fact, works");
	}
	
	@Test
	public void testEqualWorks() {
		Librarian librarian1 = new Librarian("danharper", "044de92", "Daniel", "Harper");
		Librarian librarian2 = new Librarian("danharper", "044de92", "Daniel", "Harper");
		//Run an assertTrue method to compare the two objects for equality
		assertTrue("Tests that equal() passes", librarian1.equals(librarian2));
		logger.debug("The testEqualWork() method passes for Librarian!");
	}

	@Test
	public void testNotEqualWorks() {
		Librarian librarian1 = new Librarian("danharper", "044de92", "Daniel", "Harper");
		Librarian librarian2 = new Librarian("dfuenffinger", "e9d92c3", "Daniel", "Fuenffinger");
		//Run an assertTrue method to compare the two objects for equality
		assertFalse("Tests that equal() false", librarian1.equals(librarian2));
		logger.debug("The testNotEqualWorks() method works for Librarian");
	}
}
