package com.aedificium.model.service;

import com.aedificium.model.business.ServiceLoadException;

public class Factory {

	private Factory() {}//Constructor
	
	private static Factory factory = new Factory();
	
	public static Factory getInstance() {
		return factory;
	}
	
	
	@SuppressWarnings("deprecation")
	public IService getService(String servicesName) throws ServiceLoadException {
		String reqService = null;
		
		
		
		try 
		{
			reqService = getImplName(servicesName);
			Class<?> c = Class.forName(reqService);
			return (IService)c.newInstance();
		} 
		
		catch (Exception e) 
		{
			servicesName = servicesName + " not loaded";
			throw new ServiceLoadException(servicesName);
		}
		
	}//End of getIServices method
	
	static String getImplName(String name) throws Exception{
		String iServiceReq = name;
		String impl = null;
		DOMFactory domfactory = new DOMFactory();
		impl = domfactory.getAttribute(iServiceReq);
		
		 return impl;
	}   //End of getImplName.
	



}//End of Factory Class
