package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SPCException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6525345149320671826L;
	
	public SPCException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);
	}

}
