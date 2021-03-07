package com.aedificium.model.service.checkout;

import com.aedificium.model.domain.Checkout;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.CheckoutException;

public interface IGetCheckout extends IService {
	
	public final String NAME = "IGetCheckout";
	
	Checkout getCheckout(String checkoutFile) 
			throws CheckoutException, 
			ClassNotFoundException;

}
