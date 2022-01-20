package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ecommercePageObjects.HomePage;
import ecommercePageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckHomePageTest extends Dependencies {
	
	//@Parameters({"itemName"})
	@Test
	public void verifyHome() throws InterruptedException, IOException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("GeneralStoreApp", true);
		
		LoginPage login = new LoginPage(driver);
		login.nameField.sendKeys("Shoes");
		
		
	    driver.hideKeyboard();
	    login.radioButton.click();
		login.countryBox.click();
		

		
		Utilities scroll = new Utilities(driver);
		scroll.scrollText("Brazil");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
		
		Thread.sleep(3000);
		login.countryName.click();
		login.submitButton.click();
		Thread.sleep(3000);
		
		HomePage home = new HomePage(driver);
		home.toolBar.getText();
		String title = home.toolBar.getText();
		System.out.println("HomePage Title is: "+title);

		
		String firstProduct = home.product.getText();
		System.out.println("TopList ProductName is: "+ firstProduct);
		
		String expectedName = "Air Jordan 4 Retro";
		 
		 
		if(firstProduct.equalsIgnoreCase(expectedName))
		{
			System.out.println("It is  displaying the correct  Products Page Successfully:"+ firstProduct);
			
		}
		else
		{
			System.out.println("It is  failed to display the Product Page");
		}
		
		service.stop();
	}
	
	@BeforeTest
	public void killServer() throws InterruptedException, IOException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(7000);
	}

}
