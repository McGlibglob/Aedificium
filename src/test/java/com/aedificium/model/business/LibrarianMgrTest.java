package com.aedificium.model.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
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

public class LibrarianMgrTest {
	

	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	
	//Name and initialize a librarian with properties.
	private Librarian librarian1 = 
			new Librarian ("jadefowler", "2076510", "Jade", "Foweler");
	String ldap = librarian1.getLdap();
	
	private Librarian librarian2;

	//Name and create and instance of LibrarianMgr
	LibrarianMgr librarianMgr = new LibrarianMgr();
	
	



	//Run test where the instance of LibrarianMgr call its createLibrarian Method and 
	//use "librarian1" as the argument.
	
	@Test
	public void testVerifiyLib() throws ServiceLoadException, LibrarianException {
		boolean verLib;
		String librarianLdap = "babyshoes";
		verLib = librarianMgr.verifyLib(librarianLdap);
		assertTrue("Check if the librarian given is in the system",
				verLib);
	}//End of testVerifyLib() method.
	
	@Test
	public void testNotVerifiedLib() throws ServiceLoadException, LibrarianException {
			boolean verLib;
			String librarianLdap = "dustinlang";
			verLib = librarianMgr.verifyLib(librarianLdap);
			assertFalse("Check if the librarian given is in the system",
					verLib);
		
	}//End of testNotVerifyLib() method.
	
	@Test
	public void testLibrarianMgr() throws ServiceLoadException, LibrarianException, LogException, SQLException
	{
		
		librarianMgr.createLibrarian(librarian1);
		
		librarian2 = librarianMgr.getLibrarian(ldap);
		
		assertTrue(librarian2.validate());
		
		//Delete from db
				Session session = null;
				session = BaseSessionFactory.getSession();
				Transaction tranx = session.beginTransaction();
				session.delete(librarian1);
				tranx.commit();
				session.close();

	}///End of testCreateLibrarian test.
	
	

}// End of LibrarianMgrTest

