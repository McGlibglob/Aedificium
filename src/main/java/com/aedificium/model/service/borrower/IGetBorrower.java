package com.aedificium.model.service.borrower;

import com.aedificium.model.domain.Borrower;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.BorrowerException;

public interface IGetBorrower extends IService {
	
	public final String NAME = "IGetBorrower";
	
	Borrower getBorrower(String borrowerFile) throws BorrowerException;
}
