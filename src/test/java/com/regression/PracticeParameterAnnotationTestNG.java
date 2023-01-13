package com.regression;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class PracticeParameterAnnotationTestNG {

	
	@Test
  @Parameters({"URL","user","password"})
public	void test(String URL,String user,String password) {
		System.out.println(user);
		System.out.println(password);
	}
}
//must run test from xml