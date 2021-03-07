package com.aedificium.model.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aedificium.model.service.book.GetBookImplTest;
import com.aedificium.model.service.book.StoreBookTest;
import com.aedificium.model.service.borrower.GetBorrowerImplTest;
import com.aedificium.model.service.borrower.StoreBorrowerImplTest;
import com.aedificium.model.service.checkout.StoreCheckoutImplTest;
import com.aedificium.model.service.hibernate.BaseSessionFactoryTest;
import com.aedificium.model.service.librarian.GetLibrarianImplTest;
import com.aedificium.model.service.librarian.StoreLibImplTest;
import com.aedificium.model.service.librarian.VerifyLibrarianImplTest;
import com.aedificium.model.service.spc.GetSPCImplTest;
import com.aedificium.model.service.spc.StoreSPCImplTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	FactoryTest.class, 
	StoreBookTest.class, 
	GetBookImplTest.class, 
	StoreBorrowerImplTest.class, 
	GetBorrowerImplTest.class, 
	StoreLibImplTest.class, 
	GetLibrarianImplTest.class, 
	VerifyLibrarianImplTest.class, 
	StoreSPCImplTest.class,
	GetSPCImplTest.class,
	StoreCheckoutImplTest.class,
	BaseSessionFactoryTest.class,
	DOMFactoryTest.class
	})

public class AllServicesTests {

}
