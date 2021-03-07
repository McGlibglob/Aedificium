package com.aedificium.model.service.book;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aedificium.model.domain.Book;

public class GetBookImplTest {

	Logger logger = LogManager.getLogger();
	
	Factory factory = Factory.getInstance();
	
	Book book = new Book("Fight Club", 1998, false, "Chuck Palunuk", "059483756", "3ed4rf");
	
	String bookTitle = book.getTitle();

	Book book2 = new Book();


	@Test
	public void testGetBook() 
			throws ServiceLoadException, 
			BookException, ClassNotFoundException, IOException, LogException, Throwable {
		
		Book book2 = new Book();
		//Get Store Book Impl
		IStoreBook storeBook;
		storeBook = (IStoreBook) factory.getService(IStoreBook.NAME);
		
		//Store book 1 in db
		storeBook.storeBook(book);
		
		
		//Retrieve for db
		IGetBook impl;
		impl = (IGetBook) factory.getService(IGetBook.NAME);
		
		book2 = impl.getBook(bookTitle);
		
		//Validate Retrieval
		assertTrue(book2.validate());
		
		//Delete from db
		Session session = null;
		session = BaseSessionFactory.getSession();
		Transaction tranx = session.beginTransaction();
		session.delete(book);
		tranx.commit();
		session.close();
	}

	


}