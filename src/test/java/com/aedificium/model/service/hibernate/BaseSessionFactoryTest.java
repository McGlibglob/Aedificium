package com.aedificium.model.service.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.aedificium.model.domain.Book;

public class BaseSessionFactoryTest {

	

	@Test
	public void testSession() {
		
		
		Session session = BaseSessionFactory.getSession();
		
		assertTrue(session != null);
		
		BaseSessionFactory.closeSessionAndFactory();
		
		
	}//End of testSession() method
	
	@Test
	public void testCreateClass() {
		
		Book book1  = new Book 
				("The Grote", 1998, false, "Cormac McCarthy", "936110549", "picles");
		
		BaseSessionFactory bsf = new BaseSessionFactory();
		bsf.createObject(book1);
		bsf.deleteObject(book1);
		
	}//End of testCreateClass() method

}//End of BaseSessionFactory
