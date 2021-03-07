package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HibernateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5971568735604261021L;
	
	public HibernateException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);
	}
}
