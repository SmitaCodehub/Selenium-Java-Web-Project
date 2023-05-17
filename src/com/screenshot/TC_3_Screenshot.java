package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class TC_3_Screenshot {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 ChromeDriver driver=new ChromeDriver(options);
		 driver.get("https://www.google.com");
			driver.manage().window().maximize();
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			System.out.println(links.size());
			for(int i=0;i<links.size();i++)
			{
				if(!links.get(i).getText().isEmpty())
				{
					String linkname=links.get(i).getText();
					links.get(i).click();
					
					File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+ linkname+".jpg"));
					links = driver.findElements(By.tagName("a"));
					
				}
			}
	}

}
