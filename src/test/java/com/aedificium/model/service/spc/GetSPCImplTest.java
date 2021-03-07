package com.aedificium.model.service.spc;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.SPCException;
import com.aedificium.model.domain.SPC;

public class GetSPCImplTest {
	
	Logger logger = LogManager.getLogger();
	
	Factory factory = Factory.getInstance();
	
	SPC spc = new SPC();
	

	@Test
	public void testGetSPC() throws SPCException {

		IGetSPC getSPC;
		try {
			getSPC = (IGetSPC) factory.getService(IGetSPC.NAME);
			
			spc = getSPC.getSPC();
			assertTrue(spc.validate());
			logger.debug("The getSPC() method works");
		}catch(Exception e) {
			throw new SPCException("SPC file not found.");
		
	}
		
	}

}
