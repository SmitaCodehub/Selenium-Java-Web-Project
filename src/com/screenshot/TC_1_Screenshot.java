package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class TC_1_Screenshot {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 ChromeDriver driver=new ChromeDriver(options);
		 driver.get("https://www.gmail.com");
			driver.manage().window().maximize();
			
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\scr3.png"));
	
	}

}
