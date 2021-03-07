package com.aedificium.model.service;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.aedificium.model.business.ServiceLoadException;
import com.aedificium.model.service.book.DeleteBookImpl;
import com.aedificium.model.service.book.GetBookImpl;
import com.aedificium.model.service.book.IDeleteBook;
import com.aedificium.model.service.book.IGetBook;
import com.aedificium.model.service.book.IStoreBook;
import com.aedificium.model.service.book.StoreBookImpl;
import com.aedificium.model.service.borrower.GetBorrowerImpl;
import com.aedificium.model.service.borrower.IGetBorrower;
import com.aedificium.model.service.borrower.IStoreBorrower;
import com.aedificium.model.service.borrower.StoreBorrowerImpl;
import com.aedificium.model.service.checkout.CheckInImpl;
import com.aedificium.model.service.checkout.ICheckIn;
import com.aedificium.model.service.checkout.IStoreCheckout;
import com.aedificium.model.service.checkout.StoreCheckoutImpl;
import com.aedificium.model.service.librarian.GetLibrarianImpl;
import com.aedificium.model.service.librarian.IGetLibrarian;
import com.aedificium.model.service.librarian.IStoreLibrarian;
import com.aedificium.model.service.librarian.IVerifyLibrarian;
import com.aedificium.model.service.librarian.StoreLibImpl;
import com.aedificium.model.service.librarian.VerifyLibrarianImpl;
import com.aedificium.model.service.spc.GetSPCImpl;
import com.aedificium.model.service.spc.IGetSPC;
import com.aedificium.model.service.spc.IStoreSPC;
import com.aedificium.model.service.spc.StoreSPCImpl;



public class FactoryTest {
	
	Factory factory = Factory.getInstance();
	Logger logger = LogManager.getLogger();

	@Before  
	public void setUp() throws Exception {

		
	}// End of setUp method.
	
	
	@Test
	public void testGetImplName() throws Exception {
		String iBook = IStoreBook.NAME;
		String iDeleteBook = IDeleteBook.NAME;
		String iBorrower = IStoreBorrower.NAME;
		String iLibrarian = IStoreLibrarian.NAME;
		String iCheckout = IStoreCheckout.NAME;
		String iCheckIn = ICheckIn.NAME;
		String iGetBook = IGetBook.NAME;
		String iGetBorrower = IGetBorrower.NAME;
		String iGetLib = IGetLibrarian.NAME;
		String iVerifyLib = IVerifyLibrarian.NAME;
		String iStoreSPC = IStoreSPC.NAME;
		String iGetSPC = IGetSPC.NAME;
		
		


		
		String bookImpl = Factory.getImplName(iBook);
		String deleteBookImpl = Factory.getImplName(iDeleteBook);
		String borrowerImpl = Factory.getImplName(iBorrower);
		String librarianImpl = Factory.getImplName(iLibrarian);
		String checkoutImpl = Factory.getImplName(iCheckout);
		String checkInImpl = Factory.getImplName(iCheckIn);
		String getBookImpl = Factory.getImplName(iGetBook);
		String getBorrowerImpl = Factory.getImplName(iGetBorrower);
		String getLibImpl = Factory.getImplName(iGetLib);
		String verifyLibImpl = Factory.getImplName(iVerifyLib);
		String storeSPCImpl = Factory.getImplName(iStoreSPC);
		String getSPCImpl = Factory.getImplName(iGetSPC);
		
		

		
		assertTrue("Checks that book  impl is pulled", 
				bookImpl.equals("com.aedificium.model.service.book.StoreBookImpl"));
		logger.debug("IStoreBook pulls StoreBookImpl");
		
		assertTrue("Checks that delete book  impl is pulled", 
				deleteBookImpl.equals("com.aedificium.model.service.book.DeleteBookImpl"));
		logger.debug("IDeleteBook pulls DeleteBookImpl");
			
		assertTrue("Checks that borrower impl is pulled", 
				borrowerImpl.equals("com.aedificium.model.service.borrower.StoreBorrowerImpl"));
		logger.debug("IStoreBorrower pulls StoreBorrowerImpl");
		
		assertTrue("Checks that librarian impl is pulled", 
				librarianImpl.equals("com.aedificium.model.service.librarian.StoreLibImpl"));
		logger.debug("IStoreLibrarian pulls StoreLibrarianImpl");
		
		assertTrue("Checks that checkout impl is pulled", 
				checkoutImpl.equals("com.aedificium.model.service.checkout.StoreCheckoutImpl"));
		logger.debug("ICheckout pulls StoreCheckout");
		
		assertTrue("Checks that checkIn impl is pulled", 
				checkInImpl.equals("com.aedificium.model.service.checkout.CheckInImpl"));
		logger.debug("ICheckIn pulls CheckInImpl");
		
		assertTrue("Checks that get book impl is pulled", 
				getBookImpl.equals("com.aedificium.model.service.book.GetBookImpl"));
		logger.debug("IGetBook pulls StoreGetImpl");
		
		assertTrue("Checks that get borrrower impl is pulled", 
				getBorrowerImpl.equals("com.aedificium.model.service.borrower.GetBorrowerImpl"));
		logger.debug("IGetBorrower pulls GetBorrowerImpl");
		
		assertTrue("Checks that get librarian impl is pulled", 
				getLibImpl.equals("com.aedificium.model.service.librarian.GetLibrarianImpl"));
		logger.debug("IGetLibrarian pulls GetLibrarianImpl");
		
		assertTrue("Checks that verify librarian impl is pulled", 
				verifyLibImpl.equals("com.aedificium.model.service.librarian.VerifyLibrarianImpl"));
		logger.debug("IVerifyLibrarian pulls VerifyLibrarianImpl");
		
		assertTrue("Checks that store SPC impl is pulled", 
				storeSPCImpl.equals("com.aedificium.model.service.spc.StoreSPCImpl"));
		logger.debug("IStoreSPC pulls StoreSPCImpl");
		
		assertTrue("Checks that get SPC impl is pulled", 
				getSPCImpl.equals("com.aedificium.model.service.spc.GetSPCImpl"));
		logger.debug("IGetSPC pulls GetSPCImpl");
		
		
		

	}  // End testGetImplNameTest test.
	
	@Test
	public void testGetBook() {
		IGetBook book = null;
		
		try {
			String inputReq = IGetBook.NAME;

			book = (IGetBook)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Book interface is implimented with the factory", 
					book instanceof GetBookImpl);
			logger.debug("IGetBook pulls GetBookImpl");

	}  // End testGetBook test.
	
	@Test
	public void testDeleteBook() {
		IDeleteBook book = null;
		
		try {
			String inputReq = IDeleteBook.NAME;

			book = (IDeleteBook)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Book interface is implimented with the factory", 
					book instanceof DeleteBookImpl);
			logger.debug("IDeleteBook pulls DeleteBookImpl");

	}  // End testGetBook test.
	
	@Test
	public void testStoreCheckout() {
		IStoreCheckout checkout = null;
		
		try {
			String inputReq = IStoreCheckout.NAME;

			checkout = (IStoreCheckout)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
		
			e.printStackTrace();
		}
			assertTrue("The Checkout interface is implimented with the factory", 
					checkout instanceof StoreCheckoutImpl);	

	}  // End testCheckout test.
	
	@Test
	public void testCheckIn() {
		ICheckIn impl = null;
		
		try {
			String inputReq = ICheckIn.NAME;

			impl = (ICheckIn)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
		
			e.printStackTrace();
		}
			assertTrue("The Checkout interface is implimented with the factory", 
					impl instanceof CheckInImpl);	

	}  // End testCheckout test.
	
	@Test
	public void testStoreBook() {
		IStoreBook book = null;
		
		try {
			String inputReq = IStoreBook.NAME;

			book = (IStoreBook)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Book interface is implimented with the factory", 
					book instanceof StoreBookImpl);	

	}  // End testGetBook test.
	
	@Test
	public void testGetBorrower() {
		IGetBorrower borrower = null;
		
		try {
			String inputReq = IGetBorrower.NAME;

			borrower = (IGetBorrower)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Borrower interface is implimented with the factory", 
					borrower instanceof GetBorrowerImpl);	

	}  // End testGetBorrower test.
	
	@Test
	public void testGetLibrarian() {
		IGetLibrarian lib = null;
		
		try {
			String inputReq = IGetLibrarian.NAME;

			lib = (IGetLibrarian)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Librarian interface is implimented with the factory", 
					lib instanceof GetLibrarianImpl);	

	}  // End testGetBorrower test.
	
	@Test
	public void testVerifyLibrarian() {
		IVerifyLibrarian lib = null;
		
		try {
			String inputReq = IVerifyLibrarian.NAME;

			lib = (IVerifyLibrarian)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Librarian interface is implimented with the factory", 
					lib instanceof VerifyLibrarianImpl);	

	}  // End testGetBorrower test.

	@Test
	public void testStoreLibrarian() {
		IStoreLibrarian storeLib = null;
		
		try {
			String inputReq = IStoreLibrarian.NAME;

			storeLib = (IStoreLibrarian)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The store lib interface is implimented with the factory", 
					storeLib instanceof StoreLibImpl);	

	}  // End testStoreLibrarian test.
	
	@Test
	public void testStoreSPC() {
		IStoreSPC storeSPC = null;
		
		try {
			String inputReq = IStoreSPC.NAME;

			storeSPC = (IStoreSPC)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The store SPC interface is implimented with the factory", 
					storeSPC instanceof StoreSPCImpl);	

	}  // End testStoreSPC() test.
	
	@Test
	public void testGetSPC() {
		IGetSPC getSPC = null;
		
		try {
			String inputReq = IGetSPC.NAME;

			getSPC = (IGetSPC)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The get SPC interface is implimented with the factory", 
					getSPC instanceof GetSPCImpl);	

	}  // End testGetSPC() test.
	
	@Test
	public void testStoreBorrower() {
		IStoreBorrower borrower = null;
		
		try {
			String inputReq = IStoreBorrower.NAME;

			borrower = (IStoreBorrower)factory.getService(inputReq);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertTrue("The Borrower interface is implimented with the factory", 
					borrower instanceof StoreBorrowerImpl);

	}//End of testStoreBorrower() method.
	

	
}// End of FactoryTest