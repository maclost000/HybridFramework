package appium.framework;

import java.io.IOException;



import org.testng.annotations.Test;

import ecommercePageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyToastMessageTest extends Dependencies {
	
	
	
	@Test
	public void toastMessage() throws IOException, InterruptedException
	{
		//service=startServer();
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("GeneralStoreApp", true);
		LoginPage login = new LoginPage(driver);
		login.nameField.sendKeys("brandShoes");
		
		
	    driver.hideKeyboard();
	    login.radioButton.click();
	
	  
	    login.nameField.clear();
	    login.submitButton.click();	    
	    String toastMessage = login.toastMessage.getAttribute("Name");
	    System.out.println("Error Message is: "+toastMessage);
	    //service.stop();
	}

}
