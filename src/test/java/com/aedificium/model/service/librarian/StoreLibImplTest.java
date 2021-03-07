package com.aedificium.model.service.librarian;

import static org.junit.Assert.*;

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
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;
import com.aedificium.model.domain.Librarian;

public class StoreLibImplTest {

	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	//name a book object
	
	Librarian librarian1 = new Librarian("chrishofer" , "126453" , "Chris" , "Hofer");
	Librarian librarian2 = new Librarian();
	
	@Test
	public void test() 
			throws ClassNotFoundException, LibrarianException, 
			IOException, LogException, ServiceLoadException, Exception {
		
		
		Librarian librarian2 = new Librarian();
		//Get Store Librarian Impl
		IStoreLibrarian storeLibrarian;
		storeLibrarian = (IStoreLibrarian) factory.getService(IStoreLibrarian.NAME);
		
		//Store librarian 1 in db
		storeLibrarian.storeLibrarian(librarian1);
		
		
		//Retrieve for db
		Session session = BaseSessionFactory.getSession();
		Transaction transx = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Librarian.class);
		criteria.add(Restrictions.ilike("ldap", "chrishofer"));
		@SuppressWarnings("unchecked")
		List<Librarian> resultList = criteria.list();
		librarian2 = (Librarian) resultList.get(0);
		transx.commit();
		BaseSessionFactory.closeSessionAndFactory();
		
		//Validate Retrieval
		assertTrue(librarian2.validate());
		
		//Delete from db
		session = BaseSessionFactory.getSession();
		transx = session.beginTransaction();
		session.delete(librarian1);
		transx.commit();
		BaseSessionFactory.closeSessionAndFactory();
		}

}
