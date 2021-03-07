package com.aedificium.model.service.book;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aedificium.model.domain.Book;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class DeleteBookImpl extends BaseSessionFactory implements IDeleteBook{

	
	public void deleteBook(String title) throws BookException {
		
		Session session = getSession();
		Book book = new Book();
		
		Transaction transx = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.ilike("title", title));
		@SuppressWarnings("unchecked")
		List<Book> resultList = criteria.list();
		book = (Book) resultList.get(0);
		transx.commit();
		BaseSessionFactory.closeSessionAndFactory();
		
		
		deleteObject(book);
		
	}

}
