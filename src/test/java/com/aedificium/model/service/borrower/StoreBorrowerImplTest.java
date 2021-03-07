package com.aedificium.model.service.borrower;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

import com.aedificium.model.domain.Borrower;

public class StoreBorrowerImplTest {
	
	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	//name a borrower object
	Borrower borrower1 = new Borrower("chrishofer" , "126453" , "Chris" , "Hofer");
	Borrower borrower2 = new Borrower();
	


	@Test
	public void testStoreBorrowerJDBC() 
		throws ServiceLoadException, 
		ClassNotFoundException, 
		BorrowerException, IOException, 
		BorrowerException, LogException, 
		Throwable {
	
		
		
		//Get Store Borrower Impl
		IStoreBorrower storeBorrower;
		storeBorrower = (IStoreBorrower) factory.getService(IStoreBorrower.NAME);
		
		//Store borrower 1 in db
		storeBorrower.storeBorrower(borrower1);
		
		
		//Retrieve for db
		Session session = BaseSessionFactory.getSession();
		Transaction transx = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Borrower.class);
		criteria.add(Restrictions.ilike("ldap", "chrishofer"));
		@SuppressWarnings("unchecked")
		List<Borrower> resultList = criteria.list();
		borrower2 = (Borrower) resultList.get(0);
		transx.commit();
		BaseSessionFactory.closeSessionAndFactory();
		
		//Validate Retrieval
		assertTrue(borrower2.validate());
		
		//Delete from db
		session = BaseSessionFactory.getSession();
		transx = session.beginTransaction();
		session.delete(borrower1);
		transx.commit();
		BaseSessionFactory.closeSessionAndFactory();
	}
}
	
