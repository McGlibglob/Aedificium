package com.aedificium.model.service.borrower;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

import com.aedificium.model.domain.Borrower;

public class GetBorrowerImplTest {

	Logger logger = LogManager.getLogger();
	
	Factory factory = Factory.getInstance();
	
	Borrower borrower = new Borrower("jbrindle", "234wer", "Ross", "Brindle");
	
	String ldap = borrower.getLdap();
	
	
	@Test
	public void test() throws ClassNotFoundException, BorrowerException, IOException, LogException, Throwable {
		
		Borrower borrower2 = new Borrower();
		
		//Get Store Borrower Impl
		IStoreBorrower storeBorrower;
		storeBorrower = (IStoreBorrower) factory.getService(IStoreBorrower.NAME);
		
		//Store borrower 1 in db
		storeBorrower.storeBorrower(borrower);
		
		
		//Retrieve for db
		IGetBorrower impl;
		impl = (IGetBorrower) factory.getService(IGetBorrower.NAME);
		
		borrower2 = impl.getBorrower(ldap);
		
		assertTrue(borrower2.validate());
		
		//Validate Retrieval
		
		//Delete from db
		Session session = null;
		session = BaseSessionFactory.getSession();
		Transaction tranx = session.beginTransaction();
		session.delete(borrower);
		tranx.commit();
		session.close();
		

	}

}
