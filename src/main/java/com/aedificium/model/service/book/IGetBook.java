package com.aedificium.model.service.book;

import com.aedificium.model.domain.Book;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.BookException;

public interface IGetBook extends IService{
	
	public final String NAME = "IGetBook";
	
	Book getBook(String bookFile) throws BookException;

}
