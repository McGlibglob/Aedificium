package com.aedificium.model.service.checkout;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.aedificium.model.service.Factory;
import com.aedificium.model.domain.*;

public class StoreCheckoutImplTest {
	
	
	Logger logger = LogManager.getLogger();
	
	//name a services factory object
	Factory factory = Factory.getInstance();
	
	Book book = new Book("The Snowman", 1984, false, "Nesbo, Jo" , "852365412", "12swe");
	Borrower borrower = new Borrower("chrishofer" , "126453" , "Chris" , "Hofer");
	
	LocalDate dueDate = LocalDate.now().plusDays(14);
	
	Checkout checkout = new Checkout(book, borrower, dueDate, false);
	
	@Test
	public void testStoreCheckout() 
			throws Throwable {
		
		

		//Get Store Checkout Impl
		IStoreCheckout impl;
		impl = (IStoreCheckout) factory.getService(IStoreCheckout.NAME);
		
		//Store book 1 in db
		impl.checkoutItem(checkout);

		
	}

}
