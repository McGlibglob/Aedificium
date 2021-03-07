package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BorrowerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7198284627967601735L;
	
	public BorrowerException (String enteredData) {
		
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);
		
	}

}
