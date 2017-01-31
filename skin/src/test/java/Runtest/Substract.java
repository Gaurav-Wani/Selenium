package Runtest;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;








import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Substractskins.skin.Repository;
import Substractskins.skin.basebrowser;
import Substractskins.skin.utility;

public class Substract extends Repository{
	
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@Test
	public void Substract() throws Exception
	{   int counter =0;
		report=new ExtentReports("D:\\Reports\\PositiveTests.html",true);
		logger =report.startTest("VerifyCorrectAnswer");
		
		basebrowser browser = new basebrowser();
		WebDriver driver = browser.getBrowser("Chrome");

		logger.log(LogStatus.INFO, "Browser started");
		String url="http://west.cdn.mathletics.com/html/rainforest/index.html#/home/a/menu/number/subtract-skinks";
		driver.get(url);
		
		
		/*WebElement startgame = driver.findElement(Substractskins);
		startgame.click();*/
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO,"Game is running.");
		
		utility.Capturescreenshot(driver, "substractskins Landing page");
		String image=logger.addScreenCapture("D:/rainforestsnapshots/substractskins/substractskins Landing page.png");
		logger.log(LogStatus.PASS, "Verifyhomepage", image);
		int total = driver.findElements(skins).size();
		logger.log(LogStatus.PASS, "Total number of skins are:" +total);
		for(int j=0;j<10;j++)
		{  
		     //Xpath for individual skins
			WebElement skins1 = driver.findElement(By.xpath("//div[@class='lizard-count ng-scope']/game-images[@id="+j+"]"));
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//click on individual skins
			skins1.click();
			Thread.sleep(3000);
			counter++;
			//code for valid data
			int valid = total - counter;
			logger.log(LogStatus.INFO, "Total no of skins after substraction:" +valid);
			
			driver.findElement(Inputbox).sendKeys(Integer.toString(valid));
			//check button click
			driver.findElement(check).click();
			Thread.sleep(3000);
			//utility.Capturescreenshot(driver, "Correct-"+j);
			BufferedImage image1 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		     ImageIO.write(image1, "png", new File("D:/rainforestsnapshots/substractskins/skins"+j+".png")); 
			
			String image2=logger.addScreenCapture("D:/rainforestsnapshots/substractskins/skins"+j+".png");
			logger.log(LogStatus.PASS, "validAnswerverify", image2);
			logger.log(LogStatus.PASS, "popup for correct answer is displayed\n");
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
		
			driver.findElement(Inputbox).clear();	
			//report.endTest(logger);
			
			//logger=report.startTest("VerifyincorrectCorrectAnswer");
			
			//code for Invalid data
			int invalid = total - counter + 1;
            logger.log(LogStatus.INFO, "Total no of skins after substraction:" +invalid);
			
			driver.findElement(Inputbox).sendKeys(Integer.toString(invalid));
			driver.findElement(check).click();
			Thread.sleep(3000);
			//utility.Capturescreenshot(driver, "Correct-"+j);
			BufferedImage image3 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		     ImageIO.write(image3, "png", new File("D:/rainforestsnapshots/substractskins/skinsinvalid"+j+".png")); 
			
			String image4=logger.addScreenCapture("D:/rainforestsnapshots/substractskins/skinsinvalid"+j+".png");
			logger.log(LogStatus.PASS, "invalidAnswerverify", image4);
			logger.log(LogStatus.PASS, "Answer displayed is "+invalid+"up for incorrect answer is displayed\n");
			
			Alert alert1=driver.switchTo().alert();
			alert1.accept();
		
			driver.findElement(Inputbox).clear();	
			
			
			report.endTest(logger);
			report.flush();
		}
	
	 driver.get("D:\\Reports\\PositiveTests.html");
	 Thread.sleep(2000);
	}

}
