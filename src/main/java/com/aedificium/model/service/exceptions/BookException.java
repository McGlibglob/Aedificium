package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookException extends Exception {




	/**
	 * 
	 */
	private static final long serialVersionUID = 8928726699691673548L;

	public BookException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);

	}

}
