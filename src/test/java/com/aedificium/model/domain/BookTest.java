package com.aedificium.model.domain;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

public class BookTest {
	
	Logger logger = LogManager.getLogger();

	@Test
	public void testValidateWorks() {
		Book book1 = new Book("The House of Leaves", 2000, true, 
				"Danielewski, Mark Z.", "0375703764", "aoeirujd");  //Creates new Book object with attributes
		assertTrue("Validates Book object", book1.validate());
			logger.debug("testValidateWorks() for Book, in fact, works");
	}
	
	@Test
	public void testNotValidateWorks() {
		Book book2 = new Book();  //Creates another book object with attributes
		assertFalse("Validates book object", book2.validate());
			logger.debug("testNotValidateWorks() for book, in fact, works");
	}
	
	@Test
	public void testEqualWorks() {
		Book book1 = new Book("The House of Leaves", 2000, true, 
				"Danielewski, Mark Z.", "0375703764", "aoeirujd");
		Book book2 = new Book("The House of Leaves", 2000, true, 
				"Danielewski, Mark Z.", "0375703764", "aoeirujd");
		//Run an assertTrue method to compare the two objects for equality
		assertTrue("Tests that equal() passes", book1.equals(book2));
			logger.debug("The testEqualWork() for book method passes");
	}
	
	@Test
	public void testNotEqualWorks() {
		Book book1 = new Book("The House of Leaves", 2000, true, 
				"Danielewski, Mark Z.", "0375703764", "aoeirujd");
		Book book2 = new Book("Head First", 2005, false, 
				"Sierra, Kathy.", "0596009208", "4jrc9");
		//Run an assertFalse method to compare the two objects for equality
		assertFalse("Tests that equal() fails", book1.equals(book2));
			logger.debug("The tesNottEqualWork() for book method passes");
	}
	

}