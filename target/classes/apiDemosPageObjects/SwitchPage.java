package apiDemosPageObjects;





import java.util.List;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwitchPage {

	public SwitchPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@text='9. Switch']")
	public WebElement Switch;
	
	@AndroidFindBy(id="android:id/switch_widget")
	public List<WebElement> switchWidget;

	public AndroidDriver<AndroidElement> switchWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
