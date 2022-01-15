package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckHomePage extends Dependencies {
	
	
	@Test
	public void verifyHome() throws InterruptedException, IOException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("brandShoes");
	    driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Brazil']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		String title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		System.out.println("HomePage Title is: "+title);

		
		String firstProduct = driver.findElement(By.xpath("//*[@text='Air Jordan 4 Retro']")).getText();
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
		Thread.sleep(6000);
	}

}
