package Measurementtest;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import measurementsetup.Addbugs;
import measurementsetup.Drandanddrop;
import measurementsetup.Morecount;
import measurementsetup.Setup;
import measurementsetup.Substractskins;

import org.testng.annotations.Test;
public class Runtest extends Setup{

@Test
	public void Test() throws IOException, InterruptedException, HeadlessException, AWTException
	{
		setupfile();
		//Drandanddrop length = new Drandanddrop(driver);	
		//length.Length();
		/*Morecount more = new Morecount(driver);
		more.frogcount();*/
		/*Addbugs add= new Addbugs(driver);
		add.Addbugcount();*/
		//setupfile();
		Substractskins sub = new Substractskins(driver);
		sub.Substract();
		
		/*pagetwo gametwo = new pagetwo();		
		gametwo.mymethod();*/
	}
}
