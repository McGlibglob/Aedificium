package com.aedificium.model.service.librarian;

import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.LibrarianException;

public interface IVerifyLibrarian extends IService {
	
	public final String NAME = "IVerifyLibrarian";
	
	//Method to check if ldap is an librarian.
	boolean verifyLib(String ldap) 
			throws LibrarianException;

}
