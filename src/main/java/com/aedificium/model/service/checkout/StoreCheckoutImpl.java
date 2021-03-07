package com.aedificium.model.service.checkout;

import java.io.IOException;

import com.aedificium.model.domain.Checkout;
import com.aedificium.model.service.exceptions.CheckoutException;
import com.aedificium.model.service.hibernate.BaseSessionFactory;

public class StoreCheckoutImpl extends BaseSessionFactory implements IStoreCheckout {

	@Override
	public void checkoutItem(Checkout newCheckout) throws CheckoutException, IOException, 
	ClassNotFoundException  {
		
		createObject(newCheckout);


	}

}
