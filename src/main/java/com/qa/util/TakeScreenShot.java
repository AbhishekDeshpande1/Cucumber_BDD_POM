package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	
	
	public static String getScreenShot(WebDriver driver, String methodName) throws IOException {
		
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File src = srcShot.getScreenshotAs(OutputType.FILE);
		
		String desFilePath = System.getProperty("user.dir")+"/test-output/ScreenShot/" +methodName+getCurrentTimeStamp()+".png";

		File DesFile = new File(desFilePath);
		
		FileUtils.copyFile(src,DesFile);
		
		return desFilePath;
		
	}
	
	public static String getCurrentTimeStamp(){
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		
		return timeStamp;
		
		
		
		
	}


	
	

}
