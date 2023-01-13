package com.testng.interview.practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTestWithTestNG {

	@BeforeTest
public void setup() {
	System.out.println("All setup code");
}
@Test(priority=0)
public void getLogin() {
	
	System.out.println("First Login");
}
@Test(priority=1)
public void getProduct() {
	System.out.println("Second  Product");
	
}
@Test(priority=2,enabled=false)
public void getCartFunction() {
	System.out.println("Third  Cart");
	
}
@AfterTest
public void teardown() {
System.out.println("After Test:close connection");	
	
	
}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
