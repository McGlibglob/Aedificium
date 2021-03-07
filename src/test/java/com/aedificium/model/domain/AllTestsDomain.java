package com.aedificium.model.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BookTest.class, BorrowerTest.class, CheckoutTest.class, LibrarianTest.class, SPCTest.class })
public class AllTestsDomain {

}
