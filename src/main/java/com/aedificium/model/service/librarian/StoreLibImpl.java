package com.aedificium.model.service.librarian;

import java.io.IOException;

import com.aedificium.model.domain.Librarian;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class StoreLibImpl extends BaseSessionFactory implements IStoreLibrarian {

	@Override
	public void storeLibrarian(Librarian newLibrarian) throws LibrarianException, 
		IOException, ClassNotFoundException, LogException {

		createObject(newLibrarian);

	}

}
