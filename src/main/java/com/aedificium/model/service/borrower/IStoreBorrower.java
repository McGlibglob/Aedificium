package com.aedificium.model.service.borrower;

import java.io.IOException;
import java.sql.SQLException;

import com.aedificium.model.domain.Borrower;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LogException;

public interface IStoreBorrower extends IService {
	
	public final String NAME = "IStoreBorrower";

	
	//For the storing of user input information about a new borrower.
	void storeBorrower(Borrower newBorrower) 
			throws BorrowerException, 
			IOException, 
			ClassNotFoundException, LogException, SQLException;
	
}//End of IStoreBorrower
