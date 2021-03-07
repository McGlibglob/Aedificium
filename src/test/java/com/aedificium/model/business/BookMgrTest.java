package com.aedificium.model.business;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

import com.aedificium.model.domain.Book;

public class BookMgrTest {
	
	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	
	//Name and initialize a book with properties.
	private Book book1 = 
			new Book ("Something Borrowed", 2005, false, 
					"Something Griffin", "9005582200", "12543");
	String title = book1.getTitle();

	//Name and create and instance of BookMgr
	BookMgr bookMgr = new BookMgr();



	//Run test where the instance of BookMgr call its createBook Method and 
	//use "book1" as the argument.
	
	
	@Test
	public void testBookMgr() throws ServiceLoadException, BookException, LibrarianException, LogException, Throwable
	{
		bookMgr.createBook(book1, "babyshoes");
		
		Book book2 = new Book();
		
		book2 = bookMgr.getBook(title);
		
		assertTrue(book2.validate());
		
		//Delete from db
				Session session = null;
				session = BaseSessionFactory.getSession();
				Transaction tranx = session.beginTransaction();
				session.delete(book1);
				tranx.commit();
				session.close();
	
	}
}// End of BookMgrTest

