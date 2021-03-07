package com.aedificium.model.service.librarian;

import com.aedificium.model.domain.Librarian;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.LibrarianException;

public interface IGetLibrarian extends IService {
	
	public final String NAME = "IGetLibrarian";

	//Method to retrieve a librarian's file based on ldap.
	Librarian getLibrarian(String librarianFile) 
			throws LibrarianException, 
			ClassNotFoundException;
}
