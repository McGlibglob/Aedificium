package com.aedificium.model.service.book;

import java.io.IOException;
import java.sql.SQLException;

import com.aedificium.model.domain.Book;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LogException;

public interface IStoreBook extends IService{
	
	public final String NAME = "IStoreBook";

	//Creates new book object with user input data
		void storeBook(Book newBook) throws 
			BookException, IOException, 
			ClassNotFoundException, LogException, SQLException; 

		
}//End of IStore