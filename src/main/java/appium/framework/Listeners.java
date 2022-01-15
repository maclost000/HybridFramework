package appium.framework;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import appium.framework.Dependencies;

public class Listeners implements ITestListener{

	
	@Override
	public void onTestStart(ITestResult result)
	{
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		
	}
	

	@Override
	public void onTestFailure(ITestResult result)
	{
		
		String screenShots = result.getName();
		try {
			Dependencies.getScreenshot(screenShots);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	

	@Override
	public void onStart(ITestContext context)
	{
		
	}
	@Override
	public void onFinish(ITestContext context)
	{
		
	}

	
}
