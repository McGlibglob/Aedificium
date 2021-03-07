package com.aedificium.model.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileLoadException extends Exception{


	private static final long serialVersionUID = -3592230412246586478L;

	public FileLoadException (String enteredData) {
		Logger logger = LogManager.getLogger();
		logger.warn(enteredData);

	}

}
