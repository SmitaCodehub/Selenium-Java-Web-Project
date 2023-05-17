package com.launch;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004_ExtentReport extends BaseTest {
	
	private static final Logger log=Logger.getLogger(TC_002.class);
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		init();
		test=report.startTest("TC_004_ExtentReort");
		
		//log.info("initializing the properties file..(environmen, production, locator, log4jcongig...)");
		test.log(LogStatus.INFO, "initializing the properties file..(environmen, production, locator, log4jcongig...)");	
		
		launchBrowser("chromebrowser");				
		//log.info(" opened the browser:-"+p.getProperty("chromebrowser"));		
		 test.log(LogStatus.INFO, " opened the browser:-"+p.getProperty("chromebrowser"));
		
		 launchUrl("amazonurl");
		//log.info(" Navigatingthe Url:-"+p.getProperty("amazonurl"));
		test.log(LogStatus.INFO, " Navigatingthe Url:-"+p.getProperty("amazonurl"));
		
		selectDropItem("amazondropbox_id","amazondropvalue");
		//log.info("Selected the option:-" +locprop.getProperty("amazondropvalue"));
		test.log(LogStatus.PASS, "Selected the option:-" +locprop.getProperty("amazondropvalue"));
		
		typeValue("amazonsearchtext_id", "amazonesearchtext");
		//log.info("entered the text:-" +locprop.getProperty("amazonesearchtext"));
		test.log(LogStatus.PASS, "entered the text:-" +locprop.getProperty("amazonesearchtext"));
		
		clickElement("amazonsearchbutton_xpath");
		//log.info("Clicked on Search element  :-" +locprop.getProperty("amazonsearchbutton_xpath"));
		test.log(LogStatus.PASS, "Clicked on Search element  :-" +locprop.getProperty("amazonsearchbutton_xpath") );
		
		report.endTest(test);
		report.flush();

	
	}

	

}
