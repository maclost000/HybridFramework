package apiDemosApp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appium.framework.Dependencies;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AccessWifi extends Dependencies {
	
	
	
	
	@Test
	public void wifiAccess() throws InterruptedException, IOException
	
	{
		service=startServer();
		
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
		driver.findElement(By.xpath("//*[@text='Preference']")).click();
		driver.findElementByAndroidUIAutomator("text(\"3. Preference dependencies\")").click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Password");
		
		driver.findElement(By.id("android:id/button1")).click();
		service.stop();
	}
	@BeforeTest
	public void killServer() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(4000);
	}

}
