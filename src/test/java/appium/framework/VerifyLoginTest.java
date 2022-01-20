package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ecommercePageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyLoginTest extends Dependencies {

	
	@Test
	public void verifyLoginFunction() throws InterruptedException, IOException
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
		//service.stop();
	}
}
