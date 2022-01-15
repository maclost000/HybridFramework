package appium.framework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollAndSelect extends Dependencies{

	
	@Test
	public void ScrollSelect() throws InterruptedException, IOException
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
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(textMatches(\"LeBron Soldier 12 \").instance(0));");
		//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i<count;i++)
		{
			String productName= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.contains("LeBron Soldier 12 "))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
			
		}
		service.stop();
	}
}
