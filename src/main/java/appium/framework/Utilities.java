package appium.framework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	public static AndroidDriver<AndroidElement> driver;
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		Utilities.driver=driver;
		
	}
	
	
	public AndroidDriver<AndroidElement> scrollText(String s)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+s+"\"));");
		return driver;
	}

}
