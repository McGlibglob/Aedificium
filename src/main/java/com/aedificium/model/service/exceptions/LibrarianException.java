package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LibrarianException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652283488473875746L;
	public LibrarianException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);

	}
}
