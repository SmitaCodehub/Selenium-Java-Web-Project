package com.launch;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_002 extends BaseTest {
	
	private static final Logger log=Logger.getLogger(TC_002.class);
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		init();
		log.info("initializing the properties file..(environmen, production, locator, log4jcongig...)");
			
		launchBrowser("chromebrowser");				
		log.info(" opened the browser:-"+p.getProperty("chromebrowser"));		
	
		launchUrl("amazonurl");
		log.info(" Navigatingthe Url:-"+p.getProperty("amazonurl"));
		
		selectDropItem("amazondropbox_id","amazondropvalue");
		log.info("Selected the option:-" +locprop.getProperty("amazondropvalue"));
		
		typeValue("amazonsearchtext_id", "amazonesearchtext");
		log.info("entered the text:-" +locprop.getProperty("amazonesearchtext"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Search element  :-" +locprop.getProperty("amazonsearchbutton_xpath"));
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		for(int i=0;i<links.size();i++) {
//			System.out.println(links.get(i).getText());
//		}

	
	}

	

}
