package apiDemosApp;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import apiDemosPageObjects.DateWidgetPage;
import apiDemosPageObjects.HomePage;
import appium.framework.Dependencies;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;


import static  io.appium.java_client.touch.offset.ElementOption.element;
import static  java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;

public class SetTimeTest extends Dependencies {

	
	
	@Test()
	public void timeSettings() throws InterruptedException, IOException
	{
		//service=startServer();
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("ApiDemosApp", true);
		
		HomePage home = new HomePage(driver);
		home.views.click();
		
		DateWidgetPage date = new DateWidgetPage(driver);
		date.dateWid.click();
		
		
		date.inLine.click();

		date.conDesc1.click();
		
		TouchAction touch = new TouchAction(driver);
		WebElement time1 = date.conDesc2;
		WebElement time2 = date.conDesc3;
		
		touch.longPress(LongPressOptions.longPressOptions().withElement(element(time1)).withDuration(ofSeconds(2))).moveTo(element(time2)).release().perform();
		
		String hours = date.hours.getText();
		
		System.out.println("Current Hours is: "+ hours);
		String minutes = date.minute.getText();
		System.out.println("Current Minutes is: "+ minutes);
		
		System.out.println("Label status: "+ date.minute.getText());
		//service.stop();
	}
}
