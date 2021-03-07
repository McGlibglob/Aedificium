package com.aedificium.model.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BookMgrTest.class, BorrowerMgrTest.class,  LibrarianMgrTest.class })
public class AllBusinessTests {

}
