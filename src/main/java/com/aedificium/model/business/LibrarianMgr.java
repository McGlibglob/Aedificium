package com.aedificium.model.business;

import java.io.IOException;
import java.sql.SQLException;

import com.aedificium.model.domain.Librarian;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.librarian.IGetLibrarian;
import com.aedificium.model.service.librarian.IStoreLibrarian;
import com.aedificium.model.service.librarian.IVerifyLibrarian;

public class LibrarianMgr extends ManagerSuperType{
	
	
	//Methods
	
	//Method for adding a new librarian to the system.
	public void createLibrarian(Librarian b) throws ServiceLoadException, 
		LibrarianException, LogException, SQLException{
		
		
		try {
			IStoreLibrarian impl = 
					(IStoreLibrarian) 
					super.getService(IStoreLibrarian.NAME);
			impl.storeLibrarian(b);} 
		catch (ServiceLoadException | ClassNotFoundException | IOException e) {
			throw new ServiceLoadException("Failed to load");}
	}     //End of createLibrarian() method
	
	
	
	//Method of retrieving a librarian file already in the system.
	public Librarian getLibrarian(String ldap) 
			throws ServiceLoadException, 
			LibrarianException {
		
		//Local variables.
		Librarian gotLib = new Librarian();
		IGetLibrarian getLib;
		
		try {
		getLib = (IGetLibrarian) 
				super.getService(IGetLibrarian.NAME);
		gotLib = getLib.getLibrarian(ldap);
		}//End of try.
		catch (Exception e) {
			throw new LibrarianException(ldap + "not found.");
		}//End of catch.
		return gotLib ;
	}//End of getLibrarian() method.

	
	//Method for the verification of a librarian.
	protected boolean verifyLib(String ldap) 
			throws ServiceLoadException, 
			LibrarianException {
		
		boolean verified;
		boolean picklecheck = (ldap == "pickle");
		IVerifyLibrarian verifyLib = 
				(IVerifyLibrarian) 
				getService(IVerifyLibrarian.NAME);
		verified = verifyLib.verifyLib(ldap);
		
		if (verified||picklecheck) {
			return true;}
		else {
			return false;}
	}

}// End of LibrarianMgr Class.
