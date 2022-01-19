package apiDemosPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DateWidgetPage {
	
	public DateWidgetPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
	public WebElement dateWid;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2. Inline']")
	public WebElement inLine;
	
	@AndroidFindBy(xpath="//*[@content-desc='4']")
	public WebElement conDesc1;
	
	@AndroidFindBy(xpath="//*[@content-desc='15']")
	public WebElement conDesc2;
	
	@AndroidFindBy(xpath="//*[@content-desc='5']")
	public WebElement conDesc3;
	
	@AndroidFindBy(id="android:id/hours")
	public WebElement hours;
	
	@AndroidFindBy(id="android:id/minutes")
	public WebElement minute;
	

	
	
	

}
