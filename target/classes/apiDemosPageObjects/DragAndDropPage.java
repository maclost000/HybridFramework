package apiDemosPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragAndDropPage {
	
	
	public DragAndDropPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']"))
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
	private WebElement dragDrop;
	
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
	public WebElement dot1;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_2")
	public WebElement dot2;
	
    @AndroidFindBy(id="io.appium.android.apis:id/drag_result_text")	
    public WebElement resultMessage;
	
	
	
	
	
	
	
	public WebElement getdragDrop()
	{
		return dragDrop;
	}



   
}

