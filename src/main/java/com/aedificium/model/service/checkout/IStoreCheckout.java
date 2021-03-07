package com.aedificium.model.service.checkout;

import java.io.IOException;

import com.aedificium.model.domain.Checkout;
import com.aedificium.model.service.IService;
import com.aedificium.model.service.exceptions.CheckoutException;
import com.aedificium.model.service.exceptions.LogException;

public interface IStoreCheckout extends IService {
	
	public final String NAME = "IStoreCheckout";
	
	void checkoutItem(Checkout newCheckout) 
			throws CheckoutException, 
			IOException, 
			ClassNotFoundException, LogException, Throwable;
	


}//End IStoreCheckout interface.
