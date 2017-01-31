package Datarepoutility;

import org.openqa.selenium.By;

public class DataRepo {

    private static int value;
	static public	By Fruitscount = By.xpath("//div[@class='image-holder ng-scope']/div[1]/img");
	static public By Data = By.xpath("//div[@class='category-number menu-container space']/img["+5+"]");	
	static public By Inputbox = By.xpath("//div[@class='input-item ng-scope']/input[@id='input0']");	
	static public By check = By.xpath("//div[@class='buttons-panel check-button action-btn red-gradient ng-scope']");
	static public By Number = By.xpath("//div[@class='action-buttons center-content']/div[0]");
	static public By Next = By.xpath("//div[@class='buttons-panel next-button action-btn red-gradient ng-scope']");
	
     
	
}
