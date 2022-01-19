package apiDemosPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependenciesPage {

	public PreferenceDependenciesPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElementByAndroidUIAutomator("text(\"3. Preference dependencies\")")
	@AndroidFindBy(uiAutomator="text(\"3. Preference dependencies\")")
	public WebElement preferDep;
	
	
	//driver.findElement(By.id("android:id/checkbox"))
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement checkBox;
	
	
	//driver.findElement(By.xpath("//*[@text='WiFi settings']"))
	@AndroidFindBy(xpath="//*[@text='WiFi settings']")
	public WebElement wifiSettings;
	
	//driver.findElement(By.id("android:id/edit"))
	@AndroidFindBy(id="android:id/edit")
	public WebElement passEdit;
	
	//driver.findElement(By.id("android:id/button1")
	@AndroidFindBy(id="android:id/button1")
	public WebElement oKButton;
}
