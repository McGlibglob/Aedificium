package com.aedificium.model.service.book;

import java.io.IOException;

import com.aedificium.model.domain.Book;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class StoreBookImpl extends BaseSessionFactory  implements IStoreBook {

	

	@Override
	public void storeBook(Book newBook) 
			throws BookException, IOException, 
			ClassNotFoundException, LogException {
		
		createObject(newBook);
		
	}	
	
	
}


