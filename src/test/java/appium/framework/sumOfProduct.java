package appium.framework;



import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class sumOfProduct extends Dependencies {
	
	
	
	
	@Test
	public void totalValidation() throws InterruptedException, IOException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Shoes");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Chad\"));");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='Chad']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		amount1 = amount1.substring(1);
		Double firstProductPrice = Double.parseDouble(amount1);
		System.out.println("First Product Price value is: "+firstProductPrice);
		
		String amount2= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		amount2 = amount2.substring(1);
		Double secondProductPrice = Double.parseDouble(amount2);
		System.out.println("Second Product Price value is: "+secondProductPrice);

		String amount3= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
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
		service.stop();
		
	}

}
