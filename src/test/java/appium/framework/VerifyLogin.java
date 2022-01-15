package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyLogin extends Dependencies {

	
	@Test
	public void verifyLoginFunction() throws InterruptedException, IOException
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
		service.stop();
	}
}
