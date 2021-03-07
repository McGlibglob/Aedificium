package com.aedificium.model.business;

import com.aedificium.model.service.Factory;
import com.aedificium.model.service.IService;

public abstract class ManagerSuperType {
	
		 //Creation of a Factory instance.
		 private Factory factory = Factory.getInstance();  
		 
		 //Method for the creation of a services instance.
		 protected IService getService(String name) throws ServiceLoadException {        
			 return factory.getService(name);    
		 } //End getService() method.

}//End of ManagerSuperType.
