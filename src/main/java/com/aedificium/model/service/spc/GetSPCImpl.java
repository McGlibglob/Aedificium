package com.aedificium.model.service.spc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aedificium.model.domain.SPC;
import com.aedificium.model.service.exceptions.SPCException;

public class GetSPCImpl implements IGetSPC {
	
	Logger logger = LogManager.getLogger();

	@Override
	public SPC getSPC() throws SPCException{
		SPC inputSPC = null;
		ObjectInputStream input = null;
		String fileName = "files/SPC/spc.out";
		
		try {
			input = new ObjectInputStream(new FileInputStream(fileName));
			inputSPC = (SPC) input.readObject();
			input.close();
			
			}
			catch(IOException e1) {
				System.out.println("IO values are not correct.");
				throw new SPCException("IO values are not correct.");
			}
			catch(ClassNotFoundException e2) {
				System.out.println("Class is not found");
			}

		
		return inputSPC;
	}

}
