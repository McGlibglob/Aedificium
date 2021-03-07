package com.aedificium.model.service.spc;

import java.io.IOException;

import com.aedificium.model.domain.SPC;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.SPCException;

public interface IStoreSPC extends IService {
	
	public final String NAME = "IStoreSPC";
	
	void storeSPC(SPC spc) throws
		SPCException, IOException, ClassNotFoundException;
}
