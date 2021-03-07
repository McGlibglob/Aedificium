package com.aedificium.model.service.librarian;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aedificium.model.domain.Librarian;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class GetLibrarianImpl implements IGetLibrarian {
	
	public Librarian getLibrarian(String ldap) 
			throws LibrarianException {
		
		Librarian librarian = new Librarian();
		
		//Retrieve for db
				Session session = BaseSessionFactory.getSession();
				Transaction transx = session.beginTransaction();
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(Librarian.class);
				criteria.add(Restrictions.ilike("ldap", ldap));
				@SuppressWarnings("unchecked")
				List<Librarian> resultList = criteria.list();
				librarian = (Librarian) resultList.get(0);
				transx.commit();
				BaseSessionFactory.closeSessionAndFactory();
		
		return librarian;
	}//End getLibrarian() method.
	
}//End GetLibrarianImpl class.
