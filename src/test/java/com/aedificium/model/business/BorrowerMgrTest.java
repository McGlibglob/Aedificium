package com.aedificium.model.business;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

import com.aedificium.model.domain.Borrower;

public class BorrowerMgrTest {
	
	//Name and initialize a borrower with properties.
	private Borrower borrower1 = 
			new Borrower ("joshmiddleton", "45764", "Josh", "Middleton");
	
	String ldap = borrower1.getLdap();
	
	private Borrower borrower2;
	//Name and create and instance of BorrowerMgr
	BorrowerMgr borrowerMgr = new BorrowerMgr();



	//Run test where the instance of BorrowerMgr call its createBorrower Method and 
	//use "borrower1" as the argument.
	
	
	@Test
	public void testBorrowerMgr() 
			throws ServiceLoadException, BorrowerException, LibrarianException, LogException, Throwable
	{
		borrowerMgr.createBorrower(borrower1, "babyshoes");
		
		borrower2 = borrowerMgr.getBorrower(ldap);
		
		assertTrue(borrower2.validate());
		
		//Delete from db
				Session session = null;
				session = BaseSessionFactory.getSession();
				Transaction tranx = session.beginTransaction();
				session.delete(borrower1);
				tranx.commit();
				session.close();
	}//End of testGetBorrower test.

}// End of BorrowerMgrTest

