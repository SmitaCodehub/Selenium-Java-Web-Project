package com.launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;


public class BaseTest  {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	public static String projectpath= System.getProperty("user.dir");
	public static Properties p;
	public static Properties prop;
	public static Properties envprop;
	public static Properties locprop;
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static String sceenshotFile;
	
	public static  void init() throws Exception
	{
		FileInputStream fis=new FileInputStream(projectpath +"//data.properties");
		 p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectpath +"//locator.properties");
		locprop=new Properties();
		locprop.load(fis);
		
		fis =new FileInputStream(projectpath +"//environment.properties");
		prop=new Properties();
		prop.load(fis);
		String e=prop.getProperty("env");
		System.out.println(e);
		
		fis =new FileInputStream(projectpath +"//" +e+".properties");
		envprop=new Properties();
		envprop.load(fis);
		String v=prop.getProperty("amazonurl");
		System.out.println(v);	
		
		fis=new FileInputStream(projectpath +"//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report= ExtentManager.getInstance(); 
		

		
	}
	public static void launchBrowser (String browser) throws Exception
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			 driver=new ChromeDriver(options);
			
		}
		
		
	}
	
	public static void launchUrl(String url) throws Exception
	{
		driver.navigate().to(envprop.getProperty(url));
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		
	}
	
	public static void selectDropItem(String locatorKey, String item ) {
		
		getElement(locatorKey).sendKeys(locprop.getProperty(item));
		//driver.findElement(By.id(locatorKey)).sendKeys(item);
		
	}

	public static void clickElement(String locatorKey) {
		
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
	}

	public static void typeValue(String locatorKey, String value) {
		getElement(locatorKey).sendKeys(locprop.getProperty(value));
		//driver.findElement(By.id(locatorKey)).sendKeys(value);
		
	}

	public static WebElement getElement(String locatorKey) {
		WebElement element=null;
		if(locatorKey.endsWith("_id"))
		{  element=driver.findElement(By.id(locprop.getProperty(locatorKey)));
		
		}else if (locatorKey.endsWith("_name"))
		{   element=driver.findElement(By.name(locprop.getProperty(locatorKey)));
		
		}else if(locatorKey.endsWith("_className"))	
		{ element=driver.findElement(By.className(locprop.getProperty(locatorKey)));
		
		}else if(locatorKey.endsWith("_xpath"))	
		{ element=driver.findElement(By.xpath(locprop.getProperty(locatorKey)));
		
		}else if(locatorKey.endsWith("_linkText"))	
		{
		 element=driver.findElement(By.linkText(locprop.getProperty(locatorKey)));
		
		}else if(locatorKey.endsWith("_cssSelector"))
		{
			element=driver.findElement(By.cssSelector(locprop.getProperty(locatorKey)));
		}
		return element;
		
		
	}
	
	
	//----------Verification-------------------
	public static boolean verifyElement(String expectedLink) {
		
		String actualLink=driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[2]/div[2]/div[1]/a[2]")).getAttribute("innerHTML");
		System.out.println("Actual Link Text :" + actualLink);
		System.out.println("Expected Link Text :" + expectedLink);
		
		if(actualLink.contains(expectedLink))
			return true;
		else
			return false;
	}
	
	
	//----------Reporting-------------------
	
	public static void reportSuccess(String successMsg) 
	{
		
			test.log(LogStatus.PASS, successMsg);
	
	}


	public static void reportFailure(String failureMsg) throws IOException {
			// TODO Auto-generated method stub
			test.log(LogStatus.FAIL, failureMsg);
			takeScreenshot();
			
	}
	private static void takeScreenshot() throws IOException
	{
		Date dt=new Date();
		
	   sceenshotFile=dt.toString().replace(":", "_").replace(" ","_")+ ".jpg";
		
		//SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		try
		{
		FileHandler.copy(srcFile, new File(projectpath+"\\FailureScreenshots\\"+sceenshotFile));
		System.out.println("file path :" +projectpath+"\\FailureScreenshots\\"+sceenshotFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//put screen shot to extent report
		test.log(LogStatus.INFO, "screenshot--" + test.addScreenCapture(projectpath +"\\FailureScreenshots\\"+sceenshotFile));
		
	}


	

	
	
}
