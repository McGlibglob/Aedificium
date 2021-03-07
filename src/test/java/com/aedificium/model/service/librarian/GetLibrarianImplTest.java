package com.aedificium.model.service.librarian;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;
import com.aedificium.model.domain.Librarian;

public class GetLibrarianImplTest {

	
	Logger logger = LogManager.getLogger();
	
	Factory factory = Factory.getInstance();
	
	Librarian librarian = new Librarian("jbrindle", "234wer", "Ross", "Brindle");
	
	String ldap = librarian.getLdap();
	
	
	@Test
	public void test() throws ClassNotFoundException, LibrarianException, IOException, LogException, Throwable {
		
		Librarian librarian2 = new Librarian();
		
		//Get Store Librarian Impl
		IStoreLibrarian storeLibrarian;
		storeLibrarian = (IStoreLibrarian) factory.getService(IStoreLibrarian.NAME);
		
		//Store librarian 1 in db
		storeLibrarian.storeLibrarian(librarian);
		
		
		//Retrieve for db
		IGetLibrarian impl;
		impl = (IGetLibrarian) factory.getService(IGetLibrarian.NAME);
		
		librarian2 = impl.getLibrarian(ldap);
		
		assertTrue(librarian2.validate());
		
		//Validate Retrieval
		
		//Delete from db
		Session session = null;
		session = BaseSessionFactory.getSession();
		Transaction tranx = session.beginTransaction();
		session.delete(librarian);
		tranx.commit();
		session.close();
		

	}

}

