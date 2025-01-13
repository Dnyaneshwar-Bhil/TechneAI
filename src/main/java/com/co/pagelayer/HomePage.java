package com.co.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.co.utils.MasterClass;


public class HomePage extends MasterClass{

	//	public static HomePage singleton = new HomePage( );
	//
	//	   /* A private Constructor prevents any other
	//	    * class from instantiating.
	//	    */ 
	//	   private HomePage() { }
	//
	//	   /* Static 'instance' method */
	//	   public static HomePage getInstance( ) {
	//	      return singleton;
	//	   }	

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//span[text()='Dashboard']")
	private WebElement dashboard;

	public WebElement dashboard()
	{
		return dashboard;
	}



}
