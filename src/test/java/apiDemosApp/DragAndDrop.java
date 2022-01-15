package apiDemosApp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import appium.framework.Dependencies;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class DragAndDrop extends Dependencies {
	
	
	@Test
	public void dragDrop() throws InterruptedException, IOException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		TouchAction drag = new TouchAction(driver);
		
		WebElement index1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement index2 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		drag.longPress(LongPressOptions.longPressOptions().withElement(element(index1))).moveTo(element(index2)).release().perform();
		
		String dragResult = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println("Message displayed is: "+dragResult);
		service.stop();
	}

}
