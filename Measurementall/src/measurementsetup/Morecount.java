package measurementsetup;

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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Morecount 
{

	WebDriver driver=null;
	By morecounting = By.xpath("//div[@class='category-number menu-container number']/img[2]");
	By frogcount = By.xpath("//div[@class='frog ng-scope']");
	
	By button = By.xpath("//div[@class='action-btn red-gradient ng-binding ng-scope'][1]");
	By button1 = By.xpath("//div[@class='action-btn red-gradient ng-binding ng-scope'][2]");
	By button2 = By.xpath("//div[@class='action-btn red-gradient ng-binding ng-scope'][3]");
	
	public Morecount(WebDriver driver)
	{
		this.driver= driver;
	}
	public void frogcount() throws IOException, HeadlessException, AWTException 
{
	
	driver.findElement(morecounting).click();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image, "png", new File("D:/Morecountscreenshot/bla1.png")); 
	
	for(int j=0;j<5;j++)
  {
	int i=driver.findElements(frogcount).size();
	System.out.println("Total frog Counts :" +i);
	/*for( k=1;k<=3;k++)
   {*/
	//	WebElement button1 = driver.findElement(By.xpath("//div[@class='action-bar center-content ng-scope']/div["+k+"]"));	       
	String buttontext =driver.findElement(button).getText();
	System.out.println("First button value :" +buttontext);
	String buttontext1 = driver.findElement(button1).getText();
	System.out.println("Second button value :" +buttontext1);
	String buttontext2 = driver.findElement(button2).getText();
	System.out.println("Third button value :" +buttontext2);
	/*String buttontext1=driver.findElement(button1).getText();
	System.out.println("Second button value :" +buttontext1);
	String buttontext2=driver.findElement(button2).getText();
	System.out.println("Third button value :" +buttontext2);
	*/
	if (i==Integer.parseInt(buttontext))
	{
	System.out.println(buttontext +  "is the correct answer");
	driver.findElement(button).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	else if (i==Integer.parseInt(buttontext1))
	{
	System.out.println(buttontext1 +  "is the correct answer");
	driver.findElement(button1).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	else if (i==Integer.parseInt(buttontext2))
	{
	System.out.println(buttontext1 +  "is the correct answer");
	driver.findElement(button2).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	BufferedImage image1 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image1, "png", new File("D:/Morecountscreenshot/bla"+j+".png")); 
	driver.switchTo().alert().accept();  
	
	WebElement nextclick = driver.findElement(By.xpath("//div[@class='buttons center']/a"));
    nextclick.click();   
}
}

	/*public static void screen() throws IOException, HeadlessException, AWTException{
	 
	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image, "png", new File("D:\\swapnil\\bla.png")); 
	}
	*/	
}