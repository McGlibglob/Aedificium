package com.aedificium.model.service.book;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.domain.Book;
import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class DeleteBookImplTest {

	
	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	//name a book object
	private Book book1  = new Book 
			("The Shaving", 2002, false, "Slappy McCrackin", "922222229", "wryrdh35");
	
	
	@Test
	public void test() throws ServiceLoadException, BookException {
		
		
		BaseSessionFactory bsf = new BaseSessionFactory();
		
		bsf.createObject(book1);
		
		IDeleteBook deleteBook;
		deleteBook = (IDeleteBook) factory.getService(IDeleteBook.NAME);
		
		deleteBook.deleteBook("The Shaving");
	}

}
