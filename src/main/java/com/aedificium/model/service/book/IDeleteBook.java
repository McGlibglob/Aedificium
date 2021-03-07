package com.aedificium.model.service.book;

import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.BookException;

public interface IDeleteBook extends IService {
	
	public final String NAME = "IDeleteBook";
	
	void deleteBook(String title) throws BookException;

}
