package measurementsetup;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Substractskins {
    int k = 0;
	WebDriver driver=null;
	By Substractskins = By.xpath("//div[@class='category-number menu-container number']/img[4]");
	By skins = By.xpath("//div[@class='lizard-count ng-scope']/game-images[@id]");
	By Inputbox = By.xpath("//div[@class='question-container ng-scope']/input[@class='input-field']");
	
	public  Substractskins(WebDriver driver) {
		this.driver=driver;
	}
public void Substract() throws HeadlessException, AWTException, IOException, InterruptedException 
{
	driver.findElement(Substractskins).click();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image, "png", new File("D:/Addbugs/avani.png")); */
	for(int j=0;j<10;j++)
	{ 
	WebElement skins1 = driver.findElement(By.xpath("//div[@class='lizard-count ng-scope']/game-images[@id="+j+"]"));
	int i = driver.findElements(skins).size();
	System.out.println("Total skins Counts :" +i);
    skins1.click();
	k++;
	int z = i - k;
	System.out.println("Total skins Counts after skins subtract:" +z);
	driver.findElement(Inputbox).sendKeys(Integer.toString(z));
	WebElement check= driver.findElement(By.xpath("//div[@class='buttons center']/a[2]"));
	check.click();
	Thread.sleep(3000);
	Alert alert=driver.switchTo().alert();
	BufferedImage image1 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image1, "png", new File("D:/rainforestsnapshots/substractskins/skins"+j+".png")); 
	alert.accept();
	Thread.sleep(3000);
	driver.findElement(Inputbox).clear();
	
	}

}

}
