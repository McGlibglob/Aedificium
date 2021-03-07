package com.aedificium.model.service.spc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.aedificium.model.domain.SPC;
import com.aedificium.model.service.exceptions.SPCException;

public class StoreSPCImpl implements IStoreSPC {
	
	
	public void storeSPC(SPC newSPC) throws SPCException, IOException, ClassNotFoundException {
		ObjectOutputStream output = null;
		SPC outputSPC = newSPC;
		
		
		try {
			output = new ObjectOutputStream (new FileOutputStream
					("files/SPC/spc.out"));
			output.writeObject(outputSPC);
			output.flush();
			output.close();
		}
		catch(IOException e3) {
			System.out.println("IO values are not correct.");
			throw new SPCException("IO values are not correct.");
		}

		
	}//End of storeSPC() method.
	
}//End of StoreSPCImpl

