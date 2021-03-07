package com.aedificium.model.service.checkout;

import java.io.File;

public class CheckInImpl implements ICheckIn {
	
	public void checkItemIn(String checkoutTitle) {
		
		String fileName = "files/checkouts/" + checkoutTitle + ".out";
		File file = new File(fileName);
		
		if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
		
	}

}
