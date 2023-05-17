package com.launch;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Launch_Browser {
	
		
		public static WebDriver driver;
		public static ChromeOptions options;
		
		public static void main(String[] args)  throws Exception {
			
				System.setProperty("wedriver.chrome.driver",System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
				options.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(options);
		
		}

}
