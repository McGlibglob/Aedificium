package application.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aedificium.model.business.AllBusinessTests;
import com.aedificium.model.service.AllServicesTests;

import com.aedificium.model.domain.AllTestsDomain;

@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class,
				AllTestsDomain.class, 
				AllServicesTests.class})

public class AllApplicationTest {

}
