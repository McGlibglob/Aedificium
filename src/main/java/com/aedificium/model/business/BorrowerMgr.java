package com.aedificium.model.business;

import java.io.IOException;
import java.sql.SQLException;

import com.aedificium.model.domain.Borrower;
import com.aedificium.model.service.borrower.IGetBorrower;
import com.aedificium.model.service.borrower.IStoreBorrower;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class BorrowerMgr extends ManagerSuperType{
	
	
	//Methods
	
	//Method for adding a new borrower to the system.
	public void createBorrower(Borrower b, String libLdap) throws ServiceLoadException, 
	BorrowerException, LibrarianException, LogException, SQLException{
		
		//Local Variables
		LibrarianMgr libMgr = new LibrarianMgr();
		boolean isLib;
		
		//Check for valid librarian.
		isLib = libMgr.verifyLib(libLdap);
		
		if(isLib) {
			try {
				IStoreBorrower retrieveBorrowerInfo = 
						(IStoreBorrower) 
						super.getService(IStoreBorrower.NAME);
				retrieveBorrowerInfo.storeBorrower(b);} 
			catch (ServiceLoadException | ClassNotFoundException | IOException e) {
				throw new ServiceLoadException("Failed to load");}
		}//End of if
		
		
		
	}//End of createBorrower() method
	
	//Method of retrieving a borrower file already in the system.
	public Borrower getBorrower(String ldap) 
			throws ServiceLoadException, 
			BorrowerException {
		
		Borrower gotBorrower = new Borrower();

		
		try {
			IGetBorrower getBorrower = 
					(IGetBorrower) super.getService(IGetBorrower.NAME);
		
		gotBorrower = getBorrower.getBorrower(ldap);
		}
		catch (Exception e) {
			throw new BorrowerException(ldap + "not found.");
		}


		return gotBorrower ;
	}//End of getBorrower() method.


}// End of BorrowerMgr Class.
