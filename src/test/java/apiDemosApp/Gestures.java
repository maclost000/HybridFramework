package apiDemosApp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import appium.framework.Dependencies;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Gestures extends Dependencies {
	
	
	@Test
	public void tapCheckBox() throws InterruptedException, IOException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
		driver.findElement(By.xpath("//*[@text='Preference']")).click();
		driver.findElement(By.xpath("//*[@text='9. Switch']")).click();
		driver.findElements(By.id("android:id/switch_widget")).get(0).click();
		service.stop();
		
		
	}

}
