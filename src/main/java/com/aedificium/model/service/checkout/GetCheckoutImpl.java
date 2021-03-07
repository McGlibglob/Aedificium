package com.aedificium.model.service.checkout;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.aedificium.model.domain.Checkout;
import com.aedificium.model.service.exceptions.CheckoutException;

public class GetCheckoutImpl implements IGetCheckout {
	
	@Override
	public Checkout getCheckout(String checkoutTitle) 
			throws CheckoutException {
		
		Checkout inputCheckout = null;
		ObjectInputStream input = null;
		String checkoutFile = "files/checkouts/" 
		+ checkoutTitle + ".out"; 
		
		try {
			input = new ObjectInputStream
					(new FileInputStream(checkoutFile));
			inputCheckout = (Checkout) input.readObject();
			input.close();
		}
		
		catch(IOException e1) {
			System.out.println("IO values are not correct.");
			throw new CheckoutException
			("IO values are not correct.");
		}
		catch(ClassNotFoundException e2) {
			System.out.println("Class is not found");
		}
		
		return inputCheckout;
	}//End of getCheck() method.

}//End of GetCheckoutImpl class
