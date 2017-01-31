package measurementsetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Drandanddrop {

	WebDriver driver=null;
	public Drandanddrop(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Length() throws InterruptedException
	{ 
		//int counter1 = 0;
		int count = 0;
		WebElement lengthclick = driver.findElement(By.xpath("//div[@class='category-number menu-container measurement']/img[1]"));
	    lengthclick.click();
	    for(int j=0;j<5;j++){
	    for(int i= 0 ;i<2; i++){
	    WebElement source = driver.findElement(By.xpath(".//*[@id='button-drag-"+i+"'][@group="+i+"]"));
	    WebElement dest= driver.findElement(By.xpath("//div[@id='drop0'][@group=0]"));    
	    WebElement dest1 = driver.findElement(By.xpath("//div[@id='drop1'][@group=1]"));
	    Actions action = new Actions(driver);
	    Thread.sleep(2000);
	    action.dragAndDrop(source, dest).build().perform();
	    Thread.sleep(2000);
	    WebElement tick1 = driver.findElement(By.xpath("//img[@id='tick-1']"));
	    if(tick1.isDisplayed())
	    {
	    	System.out.println("tick Passed");
	    	
	    }
	    else
	    {
	    	System.out.println("tick failed");	
	    }   
	    action.dragAndDrop(source, dest1).build().perform();
	    Thread.sleep(2000);
	   }
	    WebElement nextclick = driver.findElement(By.xpath("//div[@class='buttons center']/a"));
	    nextclick.click();  
	    count++;
	    if(count == 5)
	    {
	    	System.out.println("All question Passed");
	    }
	    else
	    {
	    	System.out.println(+count+ "question");   	
	    }
	    }
	}
}
