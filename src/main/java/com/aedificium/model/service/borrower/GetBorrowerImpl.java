package com.aedificium.model.service.borrower;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aedificium.model.domain.Borrower;
import com.aedificium.model.service.exceptions.BorrowerException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class GetBorrowerImpl implements IGetBorrower {

	public Borrower getBorrower(String ldap) throws BorrowerException {

		Borrower borrower = new Borrower();
		
		//Retrieve for db
				Session session = BaseSessionFactory.getSession();
				Transaction transx = session.beginTransaction();
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(Borrower.class);
				criteria.add(Restrictions.ilike("ldap", ldap));
				@SuppressWarnings("unchecked")
				List<Borrower> resultList = criteria.list();
				borrower = (Borrower) resultList.get(0);
				transx.commit();
				BaseSessionFactory.closeSessionAndFactory();
		
		return borrower;
	}//End getBorrower() method.

}//End GetBorrowerImpl Class
