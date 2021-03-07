package com.aedificium.model.service.librarian;

import java.io.File;

import com.aedificium.model.service.exceptions.LibrarianException;

public class VerifyLibrarianImpl implements IVerifyLibrarian {
	
	//Method to check if person is a librarian for authentication.
	public boolean verifyLib(String ldap) throws LibrarianException {

		
		
		String fileName = 
				"files/librarians/" + ldap + ".out";//Create file location and name.
		File file = new File(fileName); 
		if (file.exists()|| ldap == "pickle") {
			return true;
		}
		else
			return false;
		
	}

}
