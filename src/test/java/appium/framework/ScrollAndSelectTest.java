package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ecommercePageObjects.HomePage;
import ecommercePageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollAndSelectTest extends Dependencies{

	
	@Test()
	public void ScrollSelect() throws InterruptedException, IOException
	{
		//service=startServer();
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("GeneralStoreApp", true);
		LoginPage login = new LoginPage(driver);
		login.nameField.sendKeys("brandShoes");
		
		
	    driver.hideKeyboard();
	    login.radioButton.click();
		login.countryBox.click();
		

		
		Utilities scroll = new Utilities(driver);
		scroll.scrollText("Brazil");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
		
		Thread.sleep(3000);
		login.countryName.click();
		login.submitButton.click();
		scroll.scrollText("LeBron Soldier 12 ");
		
		HomePage home = new HomePage(driver);
		
		
		int count = home.productList.size();
		
		for(int i=0;i<count;i++)
		{
			String productName= home.productList.get(i).getText();
			if(productName.contains("LeBron Soldier 12 "))
			{
				home.addCart.get(i).click();
				break;
			}
			
		}
		//service.stop();
	}
}
