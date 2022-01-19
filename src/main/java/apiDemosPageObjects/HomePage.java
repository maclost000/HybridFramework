package apiDemosPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public HomePage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//driver.findElement(By.xpath("//*[@text='Preference']"))
	@AndroidFindBy(xpath="//*[@text='Preference']")
	public WebElement preference;
	
	
	//driver.findElement(By.xpath("//*[@text='Views']"))
	@AndroidFindBy(xpath="//*[@text='Views']")
	public WebElement views;
	

	
}
