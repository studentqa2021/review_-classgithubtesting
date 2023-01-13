package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.SeleniumWait;
import com.util.SreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FinalLoginPractice {
	
	
	public static void getFinalLogin(){
		
		//Login ==>https://magento.softwaretestingboard.com/
		//open browser
		WebDriver driver=DriverManager.getBrowser("chrome");
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver,5);
		
		// got to Application
		driver.navigate().to(Constants.URL);
		SreenShot.getScreenShot(driver, "Home page");

		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		//click sign in button
		HighLighter.getColor(driver, pf.getSigninBtn().get(0)," red");
	    pf.getSigninBtn().get(0).click();
	    SreenShot.getScreenShot(driver, "Login page");
	    HighLighter.getColor(driver, pf.getEmail()," green");
		pf.getEmail().sendKeys(Constants.user);
		//out password
		 HighLighter.getColor(driver, pf.getPassword()," blue");
		pf.getPassword().sendKeys(Constants.passWord);
		//click 2nd sign in
		 HighLighter.getColor(driver, pf.getSecondSigninBtn()," yellow");
		pf.getSecondSigninBtn().click();
		SreenShot.getScreenShot(driver, "Login validation");
		//validate = welcome sarower =xpath ==> is displayed = true = passed

		
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(pf.getWelcome().get(0).isDisplayed());
		sf.assertAll();
		
		driver.quit();

	}
	
	
	public static void main(String[] args) {
		getFinalLogin();
	}

}
