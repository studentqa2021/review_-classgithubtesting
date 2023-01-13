package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;

import com.util.SeleniumWait;
import com.util.SreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
public 	void getLogin() {
	 WebDriver driver=DriverManager.getBrowser("chrome");
     driver.manage().window().maximize();
     SeleniumWait.getImplicitWait(driver,3);
     
     SeleniumPageFactory pf=new SeleniumPageFactory(driver);
     driver.navigate().to(Constants.URL);
     SreenShot.getScreenShot(driver, "Home Page");
     SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0));
     HighLighter.getColor(driver, pf.getSigninBtn().get(0), "red");
     pf.getSigninBtn().get(0).click();
     
     HighLighter.getColor(driver, pf.getEmail(), "red");
     SreenShot.getScreenShot(driver, "LoginButton");
     pf.getEmail().click();
     pf.getEmail().sendKeys(Constants.user);
     HighLighter.getColor(driver, pf.getPassword(), "red");
     pf.getPassword().click();
     pf.getPassword().sendKeys(Constants.passWord);
     HighLighter.getColor(driver, pf.getSecondSigninBtn(), "red");
     pf.getSecondSigninBtn().click();
     SreenShot.getScreenShot(driver, "Login Validation");
     boolean status= pf.getWelcome().get(0).isDisplayed();
     SoftAssert sa=new SoftAssert();
     sa.assertTrue(status);
     sa.assertAll();
     
 
     
}

}
