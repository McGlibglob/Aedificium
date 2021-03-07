package com.aedificium.model.business;

import java.sql.SQLException;
import java.time.LocalDate;

import com.aedificium.model.domain.*;
import com.aedificium.model.service.checkout.ICheckIn;
import com.aedificium.model.service.checkout.IGetCheckout;
import com.aedificium.model.service.checkout.IStoreCheckout;
import com.aedificium.model.service.exceptions.BookException;
import com.aedificium.model.service.exceptions.CheckoutException;
import com.aedificium.model.service.exceptions.LibrarianException;
import com.aedificium.model.service.exceptions.LogException;

public class CheckoutMgr extends ManagerSuperType{

	
	//Method for adding a new checkout to the system.
	public void createCheckout(String bookSticker, String ldapBorrower, 
			String ldapLibrarian, String itemTitle) 
			
					throws Throwable{
		
		// LOCAL VARIABLES
		
		Book item = new Book();  //Create Book object book for input into checkout.
		Borrower borrower = new Borrower();//Create Borrower object borrower.
		LocalDate dueDate= LocalDate.now().plusDays(14);
		BookMgr bookMgr = new BookMgr();
		BorrowerMgr borrowerMgr = new BorrowerMgr();
		LibrarianMgr libMgr = new LibrarianMgr();
		boolean verifiedLib = false;
		

		//Verify Librarian is a librarian.
		verifiedLib = libMgr.verifyLib(ldapLibrarian);
		
		//If statement to check if Librarian is verified.
		if (verifiedLib) {
			
			//RetrieveBook and set to item.
			item = bookMgr.getBook(itemTitle);
			
			//Change boolean state of items "checkedOut" to false.
			item.setCheckedOut(true);
			bookMgr.createBook(item, ldapLibrarian);
			
			//Retrieve borrower and set to borrower object.
			borrower = borrowerMgr.getBorrower(ldapBorrower);
			
		}//End of if.
		
		//Create Checkout object and set arguments.
		Checkout checkout = new Checkout(item, borrower, dueDate, false);
		
		IStoreCheckout retrieveCheckoutInfo;
		try {
			retrieveCheckoutInfo = (IStoreCheckout) 
					super.getService(IStoreCheckout.NAME);
			retrieveCheckoutInfo.checkoutItem(checkout);}
		catch(Exception e) {
			throw new CheckoutException
			("testStoreCheckout is not working");}

	}//End of createCheckout() method.
	
	//Method for the checking in of an item.
	public String checkInItem(String itemTitle, String libLdap) 
			throws ServiceLoadException, LibrarianException,
			CheckoutException, BookException, LogException, SQLException{
		
		//LOCAL VARIABLES
		String message;
		boolean verifiedLib = false;
		Book item = new Book();
		BookMgr bookMgr = new BookMgr();
		LibrarianMgr libMgr = new LibrarianMgr();
		
		//Verify Librarian is a librarian.
		verifiedLib = libMgr.verifyLib(libLdap);
		
		//If statement to check if Librarian is verified.
		if (verifiedLib) {
			ICheckIn impl;
			impl = (ICheckIn) 
					super.getService(ICheckIn.NAME);
			impl.checkItemIn(itemTitle);
			
			//Change boolean state of items "checkedOut" to false.
			item = bookMgr.getBook(itemTitle);
			item.setCheckedOut(false);
			bookMgr.createBook(item, libLdap);
			
			//Set message to user.
			message = itemTitle + " is checked back into the system.";
		}//End of if.
		else
			//Set message to user for if librarian is not in system.
			message = "Librarian not verified.";
		//End of else
		
		return message;
	}//End of checkInItem.
	
	public Checkout getCheckout(String title) 
			throws CheckoutException, 
			ServiceLoadException {
		Checkout checkout = new Checkout();
		IGetCheckout impl;

		impl = (IGetCheckout) 
				super.getService(IGetCheckout.NAME);
		try {
			checkout = impl.getCheckout(title);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkout;
	}

}//End of CheckoutMgr class.
