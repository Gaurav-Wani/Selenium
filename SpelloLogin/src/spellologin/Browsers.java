package spellologin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {
	WebDriver driver;

	//public static void main(String[] args) {
		 public void browsers(String browsername)
		 {
		  if (browsername.equalsIgnoreCase("Firefox"))                                           
		  {
			  driver=new FirefoxDriver();                                      //  need to specify GekoDriver path
		  }
		  
		  else if(browsername.equalsIgnoreCase("Chrome"))
		  {
		      System.setProperty("webdriver.chrome.driver", "E:/Softwares/chromedriver.exe");
		      driver = new ChromeDriver();   
		   
		  }
		  else if (browsername.equalsIgnoreCase("IE"))
		  {
			  driver=new InternetExplorerDriver();
		  }
		   
		   else
		   {
		    System.out.println("You have entered incorrect browser name");
		   }  
		 }
		  
		  
		// }

	}


