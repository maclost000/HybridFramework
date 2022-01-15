package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyToastMessage extends Dependencies {
	
	
	
	@Test
	public void toastMessage() throws IOException, InterruptedException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("brandShoes");
	    driver.hideKeyboard();
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).clear();
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    
	    String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("Name");
	    System.out.println("Error Message is: "+toastMessage);
	    service.stop();
	}

}
