package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.SeleniumWait;
import com.util.SreenShot;


public class CostcoAutomation {

    public  static void productHandle() throws InterruptedException {

    	 WebDriver driver=DriverManager.getBrowser("chrome");
         driver.manage().window().maximize();
         driver.navigate().to(Constants.url);
         SeleniumWait.getImplicitWait(driver,5);
        System.out.println("HOmepage page title/name" +driver.getTitle() );  
        SreenShot.getScreenShot(driver, "Costco home welcome page");
        System.out.println("current page url"+driver.getCurrentUrl());
       
        
        
        SoftAssert sf=new SoftAssert();
       sf.assertEquals(driver.getCurrentUrl(), Constants.url);
       SeleniumPageFactory pf=new SeleniumPageFactory(driver);
       SeleniumWait.getExplicitWait(driver, pf.getCostcoSigininBtn().get(0),60);
    		  
       HighLighter.getColor(driver,  pf.getCostcoSigininBtn().get(0), "red");
       pf.getCostcoSigininBtn().get(0).click();
       Thread.sleep(5000);
       System.out.println("Login page title/name" +driver.getTitle() );
       SreenShot.getScreenShot(driver,"Costco sign In page");
     //6 =Go back to the home page>> navigate().back()
     		try {
     			Thread.sleep(3000);
     		} catch (InterruptedException e) {
     			e.printStackTrace();
     		}
     		driver.navigate().back();
     		driver.navigate().back();
     		while(true) {//true==> infinite loop
     			if(pf.getCostcoMenuBtn().size()>0) {
     				break;
     			}else {
     				driver.navigate().back();
     				Thread.sleep(3000);
     			}
     		}
     	
     		//7==> Read all options and count options below the login button
     			//pf.getCostcoMenuBtn()=list = all ==> loop =for
     		
     		System.out.println("Menu count = "+pf.getCostcoMenuBtn().size());
     		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
     			HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
     			System.out.println(pf.getCostcoMenuBtn().get(i).getText());
     			
     		}
     		//8 >If the deal was there, then mouse over it and read all options
     		//mouse hover= Actions class= moveToElement()
     		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {//1st loop
     			if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
     				HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
     				Actions ac = new Actions(driver);
     				ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
     				Thread.sleep(2000);
     				
     				
     				System.out.println("Deal options count = "+pf.getDealOptions().size());
     				//Read name of All deal options==> loop
     				for(int j=0;j<pf.getDealOptions().size();j++) {//2nd loop
     					HighLighter.getColor(driver, pf.getDealOptions().get(j), "green");
     					System.out.println(pf.getDealOptions().get(j).getText());
     				}
     				break;
     			}
     			//9 If the computer section was there inside the deal, then click it
	           pf.getComputerClick().get(0).click();
	           HighLighter.getColor(driver, pf.getComputerClick().get(0),"orange");
	            
     		}
     		
     		
     		
     		
     		
     		
     		
     		
     		sf.assertAll();
     	}
     	
     	public static void main(String[] args) throws InterruptedException {
     		CostcoAutomation.productHandle();
     		
     	}

     }
