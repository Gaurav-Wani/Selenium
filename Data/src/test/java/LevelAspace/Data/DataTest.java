package LevelAspace.Data;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Datarepoutility.DataRepo;
import Datarepoutility.Utility;

/**
 * Unit test for simple App.
 */
public class DataTest extends DataRepo
{
    WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
@Test
public void Data() throws InterruptedException, HeadlessException, AWTException, IOException
{
	report = new ExtentReports("D:\\Reports\\Datatest.html",true);
   logger= report.startTest("Verifydata");
    
    Basebrowser browser = new Basebrowser();
    WebDriver driver = browser.getBrowser("Chrome");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
    logger.log(LogStatus.INFO, "Browser started");
	String url ="http://west.cdn.mathletics.com/html/rainforest/index.html#/home/a/menu";
	driver.get(url);
	logger.log(LogStatus.INFO, "Level A page opened now click on space catogorie data game");
	Thread.sleep(2000);
	//DataRepo.setValue(5);
	driver.findElement(Data).click();    
   Utility.Capturescreenshot(driver, "Datascreenhomepage");
    String homepageimage = logger.addScreenCapture("D:/RainforestAutomation/Workspace/Data/screenshot/Datascreenhomepage.png");
    logger.log(LogStatus.PASS, "Verifyhomepage", homepageimage);
   // driver.get("D:\\Reports\\Datatest.html");
 // ******************************************Verify for correct answer*************************************************************
    for(int next= 0;next<5;next++){
    for(int i=1;i<=4;i++) 
   {
    	
  	int k =i-1;	
  int fruitcount = driver.findElements(By.xpath("//div[@class='image-holder ng-scope']/div["+i+"]/img")).size();
  WebElement inputbox = driver.findElement(By.xpath("//div[@class='input-holder ng-scope']/div["+i+"]/input[@id='input"+k+"']"));
  
  int j = fruitcount + 1; 
  if(j==11)
  {
	  WebElement numpad = driver.findElement(By.xpath("//div[@class='action-buttons center-content']/div[2]")); 
	  WebElement numpad1 = driver.findElement(By.xpath("//div[@class='action-buttons center-content']/div[1]"));
	  inputbox.sendKeys(numpad.getText(),numpad1.getText());
  }
  else{
  WebElement numpad = driver.findElement(By.xpath("//div[@class='action-buttons center-content']/div["+j+"]"));
   inputbox.sendKeys(numpad.getText()); 
 }
   }
   driver.findElement(check).click();
   Thread.sleep(3000);
   BufferedImage image1 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
   ImageIO.write(image1, "png", new File("D:/rainforestsnapshots/data/Valid/datavalid"+next+".png")); 
	
	String image2=logger.addScreenCapture("D:/rainforestsnapshots/data/Valid/datavalid"+next+".png");
	logger.log(LogStatus.PASS, "popup for correct answer is displayed\n");
	logger.log(LogStatus.PASS, "validAnswerverify", image2);
	
   Alert alert=driver.switchTo().alert();
   alert.accept();
  
   
   //******************************************Verify for incorrect answer***********************************************************
   
   for(int invalid=1;invalid<=4;invalid++){
	   int m= invalid-1;
	
	   WebElement inputbox1 = driver.findElement(By.xpath("//div[@class='input-holder ng-scope']/div["+invalid+"]/input[@id='input"+m+"']"));  
	   inputbox1.clear();
	   int fruitcount1 = driver.findElements(By.xpath("//div[@class='image-holder ng-scope']/div["+invalid+"]/img")).size();
       int countnumpad = fruitcount1 - 1;
       if(countnumpad ==0)
       {
    	   WebElement numpad1 = driver.findElement(By.xpath("//div[@class='action-buttons center-content']/div[2]"));
           inputbox1.sendKeys(numpad1.getText());
       }
       else{
       WebElement numpad1 = driver.findElement(By.xpath("//div[@class='action-buttons center-content']/div["+countnumpad+"]"));
       inputbox1.sendKeys(numpad1.getText());
       }
       }
   driver.findElement(check).click();
   Thread.sleep(3000);
   BufferedImage image3 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
   ImageIO.write(image3, "png", new File("D:/rainforestsnapshots/data/invalid/datainvalid"+next+".png")); 	
	String image4=logger.addScreenCapture("D:/rainforestsnapshots/data/invalid/datainvalid"+next+".png");
	logger.log(LogStatus.PASS, "popup for incorrect answer is displayed\n");
	logger.log(LogStatus.PASS, "validAnswerverify", image4);
   Alert alert1=driver.switchTo().alert();
   alert1.accept();
   
  driver.findElement(Next).click(); 
  report.endTest(logger);
	report.flush();
   }
   driver.get("D:\\Reports\\Datatest.html");
}

  }
