package com.launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_001 extends BaseTest {

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		init();
		launchBrowser("chromebrowser");
	
		launchUrl("amazonurl");
		driver.manage().window().maximize();
		String title=	 driver.getTitle();
		System.out.println(title);
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies(); 
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}
	}

}
