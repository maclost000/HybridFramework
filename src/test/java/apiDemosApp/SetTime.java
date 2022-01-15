package apiDemosApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import appium.framework.Dependencies;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;


import static  io.appium.java_client.touch.offset.ElementOption.element;
import static  java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;

public class SetTime extends Dependencies {

	
	
	@Test
	public void timeSettings() throws InterruptedException, IOException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		driver.findElement(By.xpath("//*[@content-desc='4']")).click();
		
		TouchAction touch = new TouchAction(driver);
		WebElement time1 = driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement time2 = driver.findElement(By.xpath("//*[@content-desc='5']"));
		
		touch.longPress(LongPressOptions.longPressOptions().withElement(element(time1)).withDuration(ofSeconds(2))).moveTo(element(time2)).release().perform();
		
		String hours = driver.findElement(By.id("android:id/hours")).getText();
		System.out.println("Current Hours is: "+ hours);
		String minutes = driver.findElement(By.id("android:id/minutes")).getText();
		System.out.println("Current Minutes is: "+ minutes);
		
		System.out.println("Label status: "+ driver.findElement(By.id("android:id/pm_label")).getText());
		service.stop();
	}
}
