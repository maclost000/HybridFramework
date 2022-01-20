package appium.framework;



import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ecommercePageObjects.CartPage;
import ecommercePageObjects.HomePage;
import ecommercePageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SumOfProductTest extends Dependencies {
	
	
	
	
	@Test
	public void totalValidation() throws InterruptedException, IOException
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
		home.addCart.get(1).click();
		home.openCart.click();
		Thread.sleep(3000);
		
		CartPage cart = new CartPage(driver);
		
		String amount1= cart.product1.get(0).getText();
		
		amount1 = amount1.substring(1);
		Double firstProductPrice = Double.parseDouble(amount1);
		System.out.println("First Product Price value is: "+firstProductPrice);
		
		String amount2= cart.product1.get(1).getText();
		
		amount2 = amount2.substring(1);
		Double secondProductPrice = Double.parseDouble(amount2);
		System.out.println("Second Product Price value is: "+secondProductPrice);

		String amount3= cart.totalPrice.getText();
		amount3 = amount3.substring(1);
		Double totalPurchaseAmount = Double.parseDouble(amount3);
		System.out.println("Total Purchase amount is: "+totalPurchaseAmount);
		
		Double sumOfProducts = firstProductPrice+secondProductPrice;
		System.out.println("Sum of two products is "+sumOfProducts);
		
		if (totalPurchaseAmount.equals(sumOfProducts))
		{
			System.out.println("Total Validation is successfull");
			
		}
		else
		{
			System.out.println("Total validation is Failed");
		}
		//service.stop();
		
	}

}
