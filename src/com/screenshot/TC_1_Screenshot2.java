package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class TC_1_Screenshot2 {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 ChromeDriver driver=new ChromeDriver(options);
		 driver.get("https://www.google.com");
			driver.manage().window().maximize();
			
			Date dt=new Date();
			System.out.println(dt);
			//String dateFormat=dt.toString().replace(":", "_").replace(" ","_")+ ".jpg";
			
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+dateFormat.format(dt)+".jpg"));
	
	}

}
