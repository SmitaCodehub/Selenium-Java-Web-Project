package com.launch;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC_5_Verification extends BaseTest {
	
	private static final Logger log=Logger.getLogger(TC_5_Verification.class);
	
	
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
		test.log(LogStatus.INFO, " Navigating the Url:-"+p.getProperty("amazonurl"));
		
			
		String expectedLink="Customer Se";
		if(!verifyElement(expectedLink))
			reportFailure("Expected and actual links are not equal");			
		else
			reportSuccess("Expected and actual links are equal");	
		
		report.endTest(test);
		report.flush();

	
	}


	
	

}
