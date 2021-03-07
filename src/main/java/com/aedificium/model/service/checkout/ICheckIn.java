package com.aedificium.model.service.checkout;

import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.CheckoutException;

public interface ICheckIn extends IService {
	
	public final String NAME = "ICheckIn";
	
	void checkItemIn(String checkoutTitle) throws CheckoutException;

}
