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

public class Addbugs {

	WebDriver driver=null;
	By Addbugs = By.xpath("//div[@class='category-number menu-container number']/img[3]");
	By leftbugs = By.xpath("//div[@class='left-side-big-leaf ng-scope']/img");
	By rightbugs = By.xpath("//div[@class='right-side-big-leaf ng-scope']/img");
	//div[@class='action-buttons center-content']/div[1]
	By button = By.xpath("//div[@class='action-buttons center-content']/div[1]");
	By button1 = By.xpath("//div[@class='action-buttons center-content']/div[2]");
	By button2 = By.xpath("//div[@class='action-buttons center-content']/div[3]");
	
	public Addbugs(WebDriver driver)
	{
		this.driver=driver;
	}

	public void Addbugcount() throws IOException, HeadlessException, AWTException 
	{
		
		driver.findElement(Addbugs).click();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File("D:/Addbugs/avani.png")); 
		
		for(int j=0;j<5;j++)
	  {
		int i=driver.findElements(leftbugs).size();
		System.out.println("Total leftbug Counts :" +i);
		int k = driver.findElements(rightbugs).size();
		System.out.println("Total leftbug Counts :" +k);
		int z = i + k;
		System.out.println("Total bug Counts :" +z);
		
		
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
		if (z==Integer.parseInt(buttontext))
		{
		System.out.println(buttontext +  "is the correct answer");
		driver.findElement(button).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if (z==Integer.parseInt(buttontext1))
		{
		System.out.println(buttontext1 +  "is the correct answer");
		driver.findElement(button1).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if (z==Integer.parseInt(buttontext2))
		{
		System.out.println(buttontext1 +  "is the correct answer");
		driver.findElement(button2).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		}
		BufferedImage image1 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image1, "png", new File("D:/rainforestsnapshots/Addbugs/bugs"+j+".png")); 
		 
		
		WebElement nextclick = driver.findElement(By.xpath("//div[@class='buttons center']/a"));
	    nextclick.click();   
	}
	}





}
