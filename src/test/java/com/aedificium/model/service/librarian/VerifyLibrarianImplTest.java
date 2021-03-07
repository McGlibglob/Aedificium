package com.aedificium.model.service.librarian;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.domain.Librarian;

public class VerifyLibrarianImplTest {
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	//name a librarian object
	private Librarian librarian1;
	
	Logger logger = LogManager.getLogger();
	
	@Before
	public void setUp() throws Exception {

		//Create an instance of a  librarian with values
		
		librarian1 = new Librarian ("babyshoes", "39104", "Scott", "McGrorey");

	}//End of setUp() method.

	@Test
	public void testVerifyLibrarian() 
			throws ServiceLoadException, LibrarianException {
		boolean isLibrarian;
		String ldap = librarian1.getLdap();
		IVerifyLibrarian verfiyImpl;
		verfiyImpl = (IVerifyLibrarian) 
				factory.getService(IVerifyLibrarian.NAME);
		try {
			isLibrarian = verfiyImpl.verifyLib(ldap);
		} catch (Exception e) {
		 throw new LibrarianException("File not found");
		}
		assertTrue("Tests if ldap is a librarian", isLibrarian);
		logger.debug("The googler is a librarian, test works");
	}//End of testVerifyLibrarian() method.
	
	@Test
	public void testVerifyNotLibrarian() 
			throws ServiceLoadException, LibrarianException {
		boolean isLibrarian;
		String ldap = "johndlink";
		IVerifyLibrarian verfiyImpl;
		verfiyImpl = (IVerifyLibrarian) 
				factory.getService(IVerifyLibrarian.NAME);
		try {
			isLibrarian = verfiyImpl.verifyLib(ldap);
		} catch (Exception e) {
		 throw new LibrarianException("File not found");
		}
		assertFalse("Tests if ldap is a librarian", isLibrarian);
		logger.debug("The googler is not a librarian, test works");
	}  //End of testVerifyNotLibrarain() method.

	@Test
	public void testVerifyLibrarianBackDoor() 
			throws ServiceLoadException, LibrarianException {
		boolean isLibrarian;
		String backdoor = "pickle";
		
		IVerifyLibrarian verfiyImpl;
		verfiyImpl = (IVerifyLibrarian) 
				factory.getService(IVerifyLibrarian.NAME);
		
		isLibrarian = verfiyImpl.verifyLib(backdoor);
		
		assertTrue("Tests if backdoor works", isLibrarian);
		logger.debug("The googler is a librarian, test works");
	}//End of testVerifyLibrarian() method.
	
	
	
}//End of VerifyLibrarianImplTest class.
