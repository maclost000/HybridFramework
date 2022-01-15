package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebViewCheck extends Dependencies{

	
	@Test
	public void webAutomation() throws InterruptedException, IOException
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
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(4000);
		
		Set<String> contexts = driver.getContextHandles();
		for(String contextNames:contexts)
		{
			System.out.println(contextNames);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("AutomationTesting");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		service.stop();
	}
}
