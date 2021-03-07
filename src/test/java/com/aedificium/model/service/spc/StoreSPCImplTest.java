package com.aedificium.model.service.spc;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.Factory;
import com.aedificium.model.service.exceptions.SPCException;
import com.aedificium.model.domain.SPC;

public class StoreSPCImplTest {

	
	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	
	private SPC spc = new SPC();

	@Test
	public void testStoreSPC()
		throws SPCException, 
		ServiceLoadException, 
		ClassNotFoundException, 
		IOException
	{
		IStoreSPC storageSPC;
		String fileName = "files/SPC/spc.out";
		File file = new File(fileName);
		
		try {
			storageSPC = (IStoreSPC) factory.getService(IStoreSPC.NAME);

			storageSPC.storeSPC(spc);
			assertTrue(file.exists());
			logger.debug("The storeSPC() method works");
		}catch(Exception e) {
			throw new SPCException("testStoreSPC is not working");
			
		}
		
		
	}

}
