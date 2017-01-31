package spellologin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;

public class Spellodromelogin {
	WebDriver dr;
	
	@Test
	public void LoginPage() throws Exception
	{
		
		File src=new File("Logindetails.properties");
		FileInputStream fis=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(fis);
		
		System.out.println("Property class loaded");
		
		//new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","E:\\webdriver\\chromedriver.exe");
		dr=new ChromeDriver();
	//	dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		dr.get(pro.getProperty("url"));
		dr.findElement(By.xpath(pro.getProperty("login"))).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath(pro.getProperty("unameinputbox"))).sendKeys(pro.getProperty("username"));
		Thread.sleep(2000);
		dr.findElement(By.xpath(pro.getProperty("passinputbox"))).sendKeys(pro.getProperty("password"));
		Thread.sleep(2000);
		dr.findElement(By.xpath(pro.getProperty("loginbutton"))).click(); Thread.sleep(60000);

	
	 try   
		  {    
		    if(dr.findElement(By.xpath("//div[@class='logout-btn']")).isDisplayed() )     
		    	
		    {      
		    	System.out.println("Logout button is present-\n Home page verified, screenshot taken. ");      
		    	getscreenshot();

		    }    
		  }      
		  catch(Exception e)     
		  {       
			  System.out.println("\n"+e.getMessage()+"\n");     
		    	System.out.println("Logout button is not verified, screenshot taken. ");
		    	getscreenshot();
		  }  
	}
		public void getscreenshot() throws Exception 
		{
	        File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
	        FileUtils.copyFile(scrFile, new File("D:\\images\\screenshot.jpg"));
		}
	}
