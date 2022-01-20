package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import ecommercePageObjects.CartPage;
import ecommercePageObjects.HomePage;
import ecommercePageObjects.LoginPage;
import ecommercePageObjects.WebPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebViewCheckTest extends Dependencies{

	
	@Test()
	public void webAutomation() throws InterruptedException, IOException
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
		
		HomePage home = new HomePage(driver);
		home.addCart.get(0).click();
		
		home.openCart.click();
		
		Thread.sleep(3000);
		
		CartPage cart = new CartPage(driver);
		cart.checkBox.click();
		
		cart.goButton.click();
		
		
		Thread.sleep(5000);
		
		Set<String> contexts = driver.getContextHandles();
		for(String contextNames:contexts)
		{
			System.out.println(contextNames);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Automation Testing");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		//service.stop();
	}
	
	
}
