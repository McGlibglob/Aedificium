package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8960538946025748056L;
	
	public CheckoutException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);

	}


}
