package com.aedificium.model.service.librarian;

import java.io.IOException;
import java.sql.SQLException;

import com.aedificium.model.domain.Librarian;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public interface IStoreLibrarian extends IService {
	
	public final String NAME = "IStoreLibrarian";
	
		//Method to store a new librarian.
		void storeLibrarian(Librarian newLibrarian) 
				throws LibrarianException, IOException, 
				ClassNotFoundException, LogException, SQLException; 
		
}//End of IRetrieveLibrarianInfo.