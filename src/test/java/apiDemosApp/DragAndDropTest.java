package apiDemosApp;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import apiDemosPageObjects.DragAndDropPage;
import apiDemosPageObjects.HomePage;
import appium.framework.Dependencies;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class DragAndDropTest extends Dependencies {
	
	
	@Test
	public void dragDrop() throws InterruptedException, IOException
	{
		//service=startServer();
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("ApiDemosApp", true);
		
		HomePage home = new HomePage(driver);
		home.views.click();
		
		DragAndDropPage dragDrop = new DragAndDropPage(driver);
		dragDrop.getdragDrop().click();

		
		TouchAction drag = new TouchAction(driver);
		
		WebElement index1 = dragDrop.dot1;
		WebElement index2 = dragDrop.dot2;
		drag.longPress(LongPressOptions.longPressOptions().withElement(element(index1))).moveTo(element(index2)).release().perform();
		
		String dragResult =  dragDrop.resultMessage.getText();
		System.out.println("Message displayed is: "+dragResult);
		//service.stop();
	}

}
