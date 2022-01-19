package appium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Dependencies {
	
	static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer() throws InterruptedException
	{
		boolean flag = CheckIfServerIsRunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		Thread.sleep(5000);
		}
		return service;
	}
	
	public static boolean CheckIfServerIsRunning(int port)
	 {
	   boolean isServerRunning = false;
	   ServerSocket serverSocket;
	 try
	 {
	  serverSocket = new ServerSocket(port);
	  serverSocket.close();
	  }catch(IOException e){
	   //If control comes here, then the port running is true

	   isServerRunning = true;
	 } finally {
	  
	 serverSocket = null;
	 }
	 return isServerRunning;
	 }

	public static   AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		
		FileInputStream fileDir = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		Properties prop = new Properties();
		prop.load(fileDir);
		
		
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		String deviceName = (String) prop.get("device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName );
		cap.setCapability("avd", deviceName);
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		
		 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		return driver;

	}
	
	public static void getScreenshot(String screenShots) throws IOException
	{
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+screenShots+".png"));
	}

}
