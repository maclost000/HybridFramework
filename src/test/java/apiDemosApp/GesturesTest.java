package apiDemosApp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import apiDemosPageObjects.HomePage;
import apiDemosPageObjects.SwitchPage;
import appium.framework.Dependencies;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class GesturesTest extends Dependencies {
	
	
	@Test
	public void tapCheckBox() throws InterruptedException, IOException
	{
		//service=startServer();
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("ApiDemosApp", true);
		
		HomePage home = new HomePage(driver);
		home.preference.click();
		
		SwitchPage Switch1 = new SwitchPage(driver);
		Switch1.Switch.click();
		
		driver.findElements(By.id("android:id/switch_widget")).get(0).click();
		//service.stop();
		
		
	}

}
