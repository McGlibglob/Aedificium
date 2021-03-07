package com.aedificium.model.service.spc;

import java.io.IOException;

import com.aedificium.model.domain.SPC;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.SPCException;

public interface IGetSPC extends IService {
	
	public final String NAME = "IGetSPC";

	SPC getSPC() throws
	SPCException, IOException, ClassNotFoundException;
	
}
