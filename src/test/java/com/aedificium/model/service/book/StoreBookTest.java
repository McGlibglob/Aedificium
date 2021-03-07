package com.aedificium.model.service.book;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

import com.aedificium.model.domain.Book;

public class StoreBookTest {

	
	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	//name a book object
	private Book book1  = new Book 
			("The Road", 1998, false, "Cormac McCarthy", "936110549", "0v0emj4");

	@Test
	public void testStoreBookJDBC() 
			throws ServiceLoadException, 
			ClassNotFoundException, 
			BookException, IOException, 
			LogException, Throwable {
		
		BaseSessionFactory bsf = new BaseSessionFactory();

		Book book2 = new Book();
		//Get Store Book Impl
		IStoreBook storeBook;
		storeBook = (IStoreBook) factory.getService(IStoreBook.NAME);
		
		//Store book 1 in db
		storeBook.storeBook(book1);
		
		
		//Retrieve for db
		Session session = BaseSessionFactory.getSession();
		Transaction transx = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.ilike("title", "The Road"));
		@SuppressWarnings("unchecked")
		List<Book> resultList = criteria.list();
		book2 = (Book) resultList.get(0);
		transx.commit();
		BaseSessionFactory.closeSessionAndFactory();
		
		//Validate Retrieval
		assertTrue(book2.validate());
		
		//Delete from db
		bsf.deleteObject(book1);
		
	}

}
