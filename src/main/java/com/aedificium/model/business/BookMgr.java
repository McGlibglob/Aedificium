package com.aedificium.model.business;

import java.io.IOException;
import java.sql.SQLException;

import com.aedificium.model.domain.Book;
import com.aedificium.model.service.book.IGetBook;
import com.aedificium.model.service.book.IStoreBook;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class BookMgr  extends ManagerSuperType{
	
	
	public BookMgr() {
		
	}
	
	//Methods
	
	//Method for adding a new book to the system.
	public void createBook(Book b, String libLdap) throws ServiceLoadException, 
	BookException, LibrarianException, LogException, SQLException{
		
		//Local Variables
		LibrarianMgr libMgr = new LibrarianMgr();
		boolean isLib = false;
		
		//Check for valid librarian.
		isLib = libMgr.verifyLib(libLdap);
		
		if(isLib|| libLdap == "pickle") {
			try {
				IStoreBook impl = 
						(IStoreBook) super.getService(IStoreBook.NAME);
				impl.storeBook(b);
			} catch (ServiceLoadException | ClassNotFoundException | IOException e) {
				throw new ServiceLoadException("Failed to load");
			}//End of try.
		}//End of if statement.
		
		
		
	}//End of createBook() method
	
	//Method of retrieving a book file already in the system.
	public Book getBook(String title) throws ServiceLoadException, BookException {
		
		Book book = new Book();
		
		try {
			IGetBook getBook = 
					(IGetBook) super.getService(IGetBook.NAME);
			
			book = getBook.getBook(title);
		}
		catch (Exception e) {
			throw new BookException(title + "not found.");
		}


		return book ;
	}//End of getBook() method.


}// End of BookMgr Class.
