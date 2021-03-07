package com.aedificium.model.business;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;

import org.junit.Test;

import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.CheckoutException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

import com.aedificium.model.domain.Checkout;

public class CheckoutMgrTest {
	
	CheckoutMgr checkoutMgr = new CheckoutMgr();

	@Test
	public void testCreateCheckout() 
			throws Throwable {
		
		String borrowerLdap = "chelton";
		String libLdap = "babyshoes";
		String item = "The Boad";
		String bookSticker = "12345";
		String fileName = "files/checkouts/" + item + ".out";
		File file = new File(fileName);
		
		//Run createCheckout()
		checkoutMgr.createCheckout(bookSticker, borrowerLdap, libLdap, item);
		
		//Tests
		assertTrue("Checks if the checkout file exists,",
				file.exists());
	}//End of testCreateCheckout() method.
	
	@Test
	public void testCheckInItem() 
			throws ServiceLoadException, 
			LibrarianException, 
			CheckoutException, 
			BookException, LogException, SQLException {
		
		String libLdap = "babyshoes";
		String item = "The Road";
		String fileName = "files/checkouts/" + item + ".out";
		File file = new File(fileName);
		
		checkoutMgr.checkInItem(item, libLdap);
		
		//Tests
		assertFalse("Checks that the file", 
				file.exists());
	}//End testCheckInItem() method.
	
	@Test
	public void testGetCheckout() 
			throws CheckoutException, 
			ServiceLoadException {
		
		//Local variables
		Checkout checkout;
		String item = "The Road";
		
		
		//Run getCheckout().
		checkout = checkoutMgr.getCheckout(item);
		assertTrue(checkout.validate());
		
	}//End testGetCheckout

}//End of CheckoutMgrTest.
