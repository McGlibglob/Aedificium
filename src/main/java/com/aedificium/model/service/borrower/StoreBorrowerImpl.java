package com.aedificium.model.service.borrower;

import java.io.IOException;

import com.aedificium.model.domain.Borrower;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class StoreBorrowerImpl extends BaseSessionFactory implements IStoreBorrower {

	@Override
	public void storeBorrower(Borrower newBorrower) 
			throws BorrowerException, IOException, 
			ClassNotFoundException, LogException {
		
		createObject(newBorrower);
		
	}	
}
