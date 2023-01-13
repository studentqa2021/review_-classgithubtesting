package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.SeleniumWait;
import com.util.SreenShot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	

	

	WebDriver driver;
	SeleniumPageFactory pf;

	@Given("open any brower")
		public void open_any_browser() {
			 driver=DriverManager.getBrowser("chrome");
			    
		     driver.manage().window().maximize();
		     SeleniumWait.getImplicitWait(driver,5);
		    pf=new SeleniumPageFactory(driver);
		}

	@Given("go to application URL")
		public void go_to_application_URL() {
			 driver.navigate().to(Constants.URL);
		     SreenShot.getScreenShot(driver, "Home Page");
		    
		}

		@When("click sign in button")
		public void click_sign_in_button() {
			 SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0),4);
			 pf.getSigninBtn().get(0).click();
		     
		     HighLighter.getColor(driver, pf.getEmail(), "red");
		     SreenShot.getScreenShot(driver, "LoginButton");
		}

		@When("put email")
		public void put_email() {
			 pf.getEmail().click();
		     pf.getEmail().sendKeys(Constants.user);
		     HighLighter.getColor(driver, pf.getPassword(), "green");
		}

		@When("put password")
		public void put_password() {
			 pf.getPassword().click();
		     pf.getPassword().sendKeys(Constants.passWord);
		     HighLighter.getColor(driver, pf.getSecondSigninBtn(), "blue");
		}

		@When("click second sigin  button")
		public void click_secod_sign_button() {
			 HighLighter.getColor(driver, pf.getSecondSigninBtn()," yellow");
				pf.getSecondSigninBtn().click();
				SreenShot.getScreenShot(driver, "Login validation");
			
		     
		}

		@Then("validate login was successful")
		public void validate_login_was_successful(){
			 boolean status= pf.getWelcome().get(0).isDisplayed();
		     SoftAssert sa=new SoftAssert();
		     sa.assertTrue(status);
		     sa.assertAll();
		}

	}

	


