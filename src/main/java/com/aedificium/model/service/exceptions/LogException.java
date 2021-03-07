package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 861876657638341734L;
		
	
	public LogException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.error(enteredData);
	}
}
