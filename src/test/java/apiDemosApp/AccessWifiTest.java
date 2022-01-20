package apiDemosApp;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiDemosPageObjects.HomePage;
import apiDemosPageObjects.PreferenceDependenciesPage;
import appium.framework.Dependencies;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AccessWifiTest extends Dependencies {
	
	
	
	
	@Test
	public void wifiAccess() throws InterruptedException, IOException
	
	{
		//service=startServer();
		
		AndroidDriver<AndroidElement> driver = runcloudcapabilities("ApiDemosApp", true);
		
		HomePage prefer = new HomePage(driver);
		prefer.preference.click();
		
		
		
		PreferenceDependenciesPage prefer1 = new PreferenceDependenciesPage(driver);
		prefer1.preferDep.click();
		
		
		
		prefer1.checkBox.click();
		
		prefer1.wifiSettings.click();
	
		prefer1.passEdit.sendKeys("Password");
	
		
		prefer1.oKButton.click();
		
		//service.stop();
	}
	//@BeforeTest
	public void killServer() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(4000);
	}

}
